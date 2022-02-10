package com.polytech.Quiz_me.dto;

import lombok.*;
@Builder
@Data
public class ResultDTO {

    private Integer id_result;
    private Integer id_user; 
    private Integer id_quiz; 
    private String result;
}
