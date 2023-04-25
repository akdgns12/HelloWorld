package com.project.helloworld.dto.response;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
public class GrassResponse {



        private LocalDate grassDate;

        private List<Long> boardList;

        @Builder
        public GrassResponse( LocalDate grassDate, List<Long> boardList) {

                this.grassDate = grassDate;
                this.boardList = boardList;
        }
}
