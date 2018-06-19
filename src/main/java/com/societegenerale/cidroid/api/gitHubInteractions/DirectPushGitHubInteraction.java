package com.societegenerale.cidroid.api.gitHubInteractions;

public class DirectPushGitHubInteraction extends AbstractGitHubInteraction {

    @Override
    String getType() {
        return "DIRECT_PUSH";
    }
}
