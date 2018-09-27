package com.societegenerale.cidroid.api.actionToReplicate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.societegenerale.cidroid.api.IssueProvidingContentException;

import com.societegenerale.cidroid.api.ResourceToUpdate;
import com.societegenerale.cidroid.api.actionToReplicate.fields.ExpectedField;


import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS;

@JsonTypeInfo(use = CLASS, include = PROPERTY)
public interface ActionToReplicate {

    /**
     * Convenient default method when we don't need the resourceToUpdate to provide the content
     *
     * @param initialContent
     * @return
     */
    default String provideContent(String initialContent) throws IssueProvidingContentException {
        return provideContent(initialContent, null);
    }

    String provideContent(String initialContent, ResourceToUpdate resourceToUpdate) throws IssueProvidingContentException;

    /**
     * ActionToreplicate are being built dynamically, so we need to call init after instantiating them, so that all their internals are set properly
     * before we do anything gwith them
     *
     * @param actionDetails
     */
    void init(Map<String, String> actionDetails);

    /**
     * In case the resource to update doesn't exist, indicates whether the action should be called nonetheless.
     * In case we say yes, provideContent will be called, with null as a parameter.
     * <p>
     * This can be useful in case we want to replace file content, or create the file if it doesn't exist.
     *
     * @return
     */
    default boolean canContinueIfResourceDoesntExist() {
        return false;
    }


    /**
     * If we want the action to be made available in UI, we need to implement this method indicating what fields should be displayed
     * @return
     */
    @JsonIgnore
    default List<ExpectedField> getExpectedUIFields() {
        return Collections.emptyList();
    }

    /**
     * If we want the action to be made available in UI, we need to define a quick description for the action that can be used there
     *
     * @return
     */
    @JsonIgnore
    default String getDescriptionForUI() {
        return "";
    }
}
