package com.societegenerale.cidroid.api.gitHubInteractions;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.MINIMAL_CLASS;

@JsonTypeInfo(use = MINIMAL_CLASS, include = PROPERTY)
@EqualsAndHashCode
@ToString
public abstract class AbstractGitHubInteraction {
    abstract String getType();

}
