package com.societegenerale.cidroid.api.gitHubInteractions;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GitHubInteractionTest {

    ObjectMapper objectMapper = new ObjectMapper();

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();


    @Test
    public void canSerializePullRequestInteraction_withNullPRname() throws IOException {

        PullRequestGitHubInteraction prInteraction = new PullRequestGitHubInteraction("someBranchName",null);

        String serializedInteraction = objectMapper.writeValueAsString(prInteraction);

        assertThat(serializedInteraction).isEqualTo("{\"@c\":\".PullRequestGitHubInteraction\",\"branchNameToCreate\":\"someBranchName\"}");

    }

    @Test
    public void canSerializePullRequestInteraction_withProvidedPrName() throws IOException {

        PullRequestGitHubInteraction prInteraction = new PullRequestGitHubInteraction("someBranchName","the PR name");

        String serializedInteraction = objectMapper.writeValueAsString(prInteraction);

        assertThat(serializedInteraction).isEqualTo("{\"@c\":\".PullRequestGitHubInteraction\",\"branchNameToCreate\":\"someBranchName\",\"pullRequestName\":\"the PR name\"}");

    }


    @Test
    public void canSerializeDirectPushInteraction() throws IOException {

        DirectPushGitHubInteraction directPushInteraction = new DirectPushGitHubInteraction();

        String serializedInteraction = objectMapper.writeValueAsString(directPushInteraction);

        assertThat(serializedInteraction).isEqualTo("{\"@c\":\".DirectPushGitHubInteraction\"}");
    }

    @Test
    public void canDeserializePullRequestWithNoBranch_butInvalid() throws IOException {

        String gitHubInteractionAsString = "{\"interaction\":{\n" +
                "    \"@c\":\".PullRequestGitHubInteraction\"" +
                "  }}";

        TestGithubInteraction gitHubInteraction = objectMapper.readValue(gitHubInteractionAsString, TestGithubInteraction.class);

        assertThat(gitHubInteraction.interaction).isInstanceOf(PullRequestGitHubInteraction.class);


        Set<ConstraintViolation<AbstractGitHubInteraction>> violations = validator.validate(gitHubInteraction.interaction);
        assertThat(violations).hasSize(1);
    }

    @Test
    public void canDeserializePullRequestWithNoPrName() throws IOException {

        String gitHubInteractionAsString = "{\"interaction\":{\n" +
                "    \"@c\":\".PullRequestGitHubInteraction\",\n" +
                "    \"branchNameToCreate\":\"someName\"\n" +
                "  }}";

        TestGithubInteraction gitHubInteraction = objectMapper.readValue(gitHubInteractionAsString, TestGithubInteraction.class);

        assertThat(gitHubInteraction.interaction).isInstanceOf(PullRequestGitHubInteraction.class);

        Set<ConstraintViolation<AbstractGitHubInteraction>> violations = validator.validate(gitHubInteraction.interaction);
        assertThat(violations).isEmpty();

        PullRequestGitHubInteraction prAction=(PullRequestGitHubInteraction)gitHubInteraction.interaction;
        assertThat(prAction.getBranchNameToCreate()).isEqualTo("someName");
    }

    @Test
    public void canDeserializePullRequestWithPrName() throws IOException {

        String gitHubInteractionAsString = "{\"interaction\":{\n" +
                "    \"@c\":\".PullRequestGitHubInteraction\",\n" +
                "    \"branchNameToCreate\":\"someName\",\n" +
                "    \"pullRequestName\":\"the PR name\"\n" +
                "  }}";

        TestGithubInteraction gitHubInteraction = objectMapper.readValue(gitHubInteractionAsString, TestGithubInteraction.class);

        assertThat(gitHubInteraction.interaction).isInstanceOf(PullRequestGitHubInteraction.class);

        Set<ConstraintViolation<AbstractGitHubInteraction>> violations = validator.validate(gitHubInteraction.interaction);
        assertThat(violations).isEmpty();

        PullRequestGitHubInteraction prAction=(PullRequestGitHubInteraction)gitHubInteraction.interaction;
        assertThat(prAction.getBranchNameToCreate()).isEqualTo("someName");
        assertThat(prAction.getPullRequestName()).isEqualTo("the PR name");
    }



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    protected static class TestGithubInteraction {

        private AbstractGitHubInteraction interaction;

    }

}