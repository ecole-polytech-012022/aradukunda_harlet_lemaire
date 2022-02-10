package com.polytech.Quiz_me.mapper;


import java.util.ArrayList;
import java.util.List;

import com.polytech.Quiz_me.dto.QuestionDTO;
import com.polytech.Quiz_me.model.Question;

public class QuestionMapper {
    
    public static QuestionDTO toQuestionDTO(Question question) {
        return QuestionDTO.builder()
                        .id_quest(question.getIdQuest())
                        .id_quiz(question.getIdQuiz())
                        .response_id(question.getResponseId())
                        .question(question.getQuestion())
                        .response(question.getResponse())
                        .build();
    }

    public static List<QuestionDTO> toQuestionDTOList(List<Question> list) {
        List<QuestionDTO> dtoList = new ArrayList<>();
        for (Question question : list) {
            dtoList.add(toQuestionDTO(question));
        }
        return dtoList;
    }
    
    public static Question toQuestion(QuestionDTO dto) {
        return Question.builder()
                        .id_quest(dto.getIdQuest())
                        .id_quiz(dto.getIdQuiz())
                        .response_id(dto.getResponseId())
                        .question(dto.getQuestion())
                        .response(dto.getResponse())
                        .build();
    }

    public static List<Question> toQuestionList(List<QuestionDTO> list) {
        List<Question> questionList = new ArrayList<>();
        for (QuestionDTO dto : list) {
            questionList.add(toQuestion(dto));
        }
        return questionList;
    }
}
