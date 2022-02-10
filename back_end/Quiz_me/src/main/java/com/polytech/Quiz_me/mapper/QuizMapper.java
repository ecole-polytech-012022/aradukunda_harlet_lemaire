package com.polytech.Quiz_me.mapper;

import java.util.ArrayList;
import java.util.List;

import com.polytech.Quiz_me.dto.QuizDTO;
import com.polytech.Quiz_me.model.Quiz;

public class QuizMapper {

    public static QuizDTO toQuizDTO(Quiz quiz) {
        return QuizDTO.builder()
                        .id_quiz(quiz.getIdQuiz())
                        .theme_quiz(quiz.getThemeQuiz())
                        .quest_list_id(quiz.getQuestListId())
                        .build();
    }

    public static List<QuizDTO> toQuizDTOList(List<Quiz> list) {
        List<QuizDTO> dtoList = new ArrayList<>();
        for (Quiz quiz : list) {
            dtoList.add(toQuizDTO(quiz));
        }
        return dtoList;
    }
    
    public static Quiz toQuiz(QuizDTO dto) {
        return Quiz.builder()
                        .id_quiz(dto.getIdQuiz())
                        .theme_quiz(dto.getThemeQuiz())
                        .quest_list_id(dto.getQuestListId())
                        .build();
    }

    public static List<Quiz> toQuizList(List<QuizDTO> list) {
        List<Quiz> quizList = new ArrayList<>();
        for (QuizDTO dto : list) {
            quizList.add(toQuiz(dto));
        }
        return quizList;
    }
    
}
