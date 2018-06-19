package com.societegenerale.cidroid.api.actionToReplicate.fields;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TextField extends ExpectedField {

    @JsonCreator
    public TextField(@JsonProperty("name") String name, @JsonProperty("label") String label) {

        super(name, label, "textField");
    }

}
