package com.project.helloworld.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FamilyNameBody {

    private Long familySeq;
    private String name;

    @Builder
    public FamilyNameBody(Long familySeq, String name) {
        this.familySeq = familySeq;
        this.name = name;
    }
}
