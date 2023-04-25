package com.project.helloworld.service;


import com.project.helloworld.dto.response.GrassResponse;
import com.project.helloworld.dto.response.GrassTable;
import com.project.helloworld.repository.GrassRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GrassServiceImpl implements GrassService{

    private final GrassRepository grassRepository;
    @Override
    public ResponseEntity<?> getGrass(LocalDate startDate, LocalDate endDate, Long userSeq) {
        List<GrassTable> list = grassRepository.getGrassByDate(startDate,endDate,userSeq);

        long days = ChronoUnit.DAYS.between(startDate,endDate);
        List<GrassResponse> grassList = new ArrayList<GrassResponse>();
        for(int i=0,j=0;  j<=days; j++   ){


            // j를 1씩 증가시켜
            grassList.add( GrassResponse.builder().grassDate(startDate.plusDays(j)).boardList(new ArrayList<>()).build());
            // 안에선 i를 1씩 증가시켜
            while(true){
                if(i<list.size()  && list.get(i).getGrassDate().equals(startDate.plusDays(j))){
                    Long boardSeq = list.get(i).getBoardSeq();
                    grassList.get(j).getBoardList().add(boardSeq);
                    i++;
                }else{
                    break;
                }


            }


        }
        return ResponseEntity.ok().body(grassList);
    }
}
