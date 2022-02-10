package com.polytech.Quiz_me.dto;

import lombok.*;
@Builder
@Data
public class QuestionDTO {
    private Integer id_quest;
    private Integer quiz_id; 
    private Integer response_id;  
    private String question; 
    private String response;   
}
