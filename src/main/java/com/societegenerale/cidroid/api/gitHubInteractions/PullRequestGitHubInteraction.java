package com.societegenerale.cidroid.api.gitHubInteractions;

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

    @Override
    String getType() {
        return "PULL_REQUEST";
    }

}
