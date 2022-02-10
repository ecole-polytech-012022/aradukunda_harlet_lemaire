package com.polytech.Quiz_me.mapper;

import java.util.ArrayList;
import java.util.List;

import com.polytech.Quiz_me.dto.ResultDTO;
import com.polytech.Quiz_me.model.Result;

public class ResultMapper {

    public static ResultDTO toResultDTO(Result result) {
        return ResultDTO.builder()
                        .id_result(result.getIdResult())
                        .id_user(result.getIdUser())
                        .id_quiz(result.getIdQuiz())
                        .result(result.getResult())
                        .build();
    }

    public static List<ResultDTO> toResultDTOList(List<Result> list) {
        List<ResultDTO> dtoList = new ArrayList<>();
        for (Result result : list) {
            dtoList.add(toResultDTO(result));
        }
        return dtoList;
    }
    
    public static Result toResult(ResultDTO dto) {
        return Result.builder()
                        .id_result(dto.getIdResult())
                        .id_user(dto.getIdUser())
                        .id_quiz(dto.getIdQuiz())
                        .result(dto.getResult())
                        .build();
    }

    public static List<Result> toResultList(List<ResultDTO> list) {
        List<Result> resultList = new ArrayList<>();
        for (ResultDTO dto : list) {
            resultList.add(toResult(dto));
        }
        return resultList;
    }
    
}
