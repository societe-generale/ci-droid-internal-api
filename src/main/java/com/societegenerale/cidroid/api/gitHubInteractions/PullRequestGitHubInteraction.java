package com.societegenerale.cidroid.api.gitHubInteractions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PullRequestGitHubInteraction extends AbstractGitHubInteraction {

    @Getter
    @Setter
    @NotEmpty
    private String branchNameToCreate;

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String pullRequestName=null;

    @Override
    String getType() {
        return "PULL_REQUEST";
    }

}
