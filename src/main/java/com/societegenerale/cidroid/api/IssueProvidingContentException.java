package com.societegenerale.cidroid.api;

public class IssueProvidingContentException extends Exception {

    public IssueProvidingContentException(String message) {
        super(message);
    }

    public IssueProvidingContentException(String message, Exception e) {
        super(message,e);
    }

}
