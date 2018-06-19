package com.societegenerale.cidroid.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceToUpdate {

    private String repoFullName;

    private String filePathOnRepo;

    private String branchName;

    private String placeHolderValue;

}
