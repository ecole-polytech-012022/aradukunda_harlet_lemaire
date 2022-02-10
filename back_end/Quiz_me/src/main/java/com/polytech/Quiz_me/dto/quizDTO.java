package com.polytech.Quiz_me.dto;


import java.util.List;

import lombok.*;
@Builder
@Data

public class quizDTO {
    private Integer id_quiz;
    private String theme_quiz;
    private List<Integer> quest_list_id; 
}
