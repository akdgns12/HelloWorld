package com.project.helloworld.dto;

import com.project.helloworld.domain.Family;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FamilyResponseDto {


    private Long familySeq;

    private String relationName;

    private String relationComment;

    private Long familyUserSeq;

    private String familyNickName;




    private Integer isAccepted;



    public FamilyResponseDto(Family family) {
        this.familySeq = family.getFamilySeq();
        this.relationName = family.getRelationName();
        this.relationComment = family.getRelationComment();
        this.familyUserSeq = family.getFamilyUser().getUserSeq();
        this.isAccepted = family.getIsAccepted();
        this.familyNickName = family.getFamilyUserNickname();
    }
}
