package com.project.helloworld.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StickerRequest {



    Long userSeq;

    Long boardSeq;

    Integer type;


}
