package com.societegenerale.cidroid.api.actionToReplicate.fields;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TextArea extends ExpectedField {

    @JsonCreator
    public TextArea(@JsonProperty("name") String name, @JsonProperty("label") String label) {
        super(name, label, "textArea");
    }

}
