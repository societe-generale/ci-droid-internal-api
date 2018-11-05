package com.societegenerale.cidroid.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceToUpdate {

    private String repoFullName;

    private String filePathOnRepo;

    private String branchName;

    private String placeHolderValue;

}
