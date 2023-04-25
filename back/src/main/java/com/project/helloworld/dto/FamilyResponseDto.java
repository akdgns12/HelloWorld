package com.project.helloworld.dto;

import com.project.helloworld.domain.Family;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FamilyResponseDto {



    private String relationName;

    private String relationComment;

    private Long familyUserSeq;




    private Integer isAccepted;



    public FamilyResponseDto(Family family) {

        this.relationName = family.getRelationName();
        this.relationComment = family.getRelationComment();
        this.familyUserSeq = family.getFamilyUserSeq();
        this.isAccepted = family.getIsAccepted();

    }
}
