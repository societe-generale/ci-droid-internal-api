package com.societegenerale.cidroid.api.actionToReplicate.fields;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpectedFieldTest {

    @Test
    public void shouldBeAbleToMap() throws IOException {

        String fieldAsString = "{\"field\":" +
                "{\"@class\": \"com.societegenerale.cidroid.api.actionToReplicate.fields.TextArea\"," +
                "\"name\": \"testName\"," +
                "\"label\": \"testLabel\"" +
                "}}";

        TestField field = new ObjectMapper().readValue(fieldAsString, TestField.class);

        assertThat(field.getField()).isInstanceOf(TextArea.class);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    protected static class TestField {

        private ExpectedField field;

    }

}