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

    @Test
    public void cantSerializePullRequestInteraction() throws IOException {

        PullRequestGitHubInteraction prInteraction = new PullRequestGitHubInteraction("someBranchName");

        String serializedInteraction = objectMapper.writeValueAsString(prInteraction);

        assertThat(serializedInteraction).isEqualTo("{\"@c\":\".PullRequestGitHubInteraction\",\"branchNameToCreate\":\"someBranchName\"}");

    }

    @Test
    public void cantSerializeDirectPushInteraction() throws IOException {

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

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<AbstractGitHubInteraction>> violations = validator.validate(gitHubInteraction.interaction);
        assertThat(violations).hasSize(1);

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    protected static class TestGithubInteraction {

        private AbstractGitHubInteraction interaction;

    }

}