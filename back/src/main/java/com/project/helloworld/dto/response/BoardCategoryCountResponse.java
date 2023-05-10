package com.project.helloworld.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public interface BoardCategoryCountResponse {
    Long getCategorySeq();

    int getCount();


}
