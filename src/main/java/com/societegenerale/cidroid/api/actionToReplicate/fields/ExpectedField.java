package com.societegenerale.cidroid.api.actionToReplicate.fields;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS;

@Data
@JsonTypeInfo(use = CLASS, include = PROPERTY)
public abstract class ExpectedField {

    protected final String name;

    protected final String label;

    protected final String fieldType;

}
