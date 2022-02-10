package com.polytech.Quiz_me.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



import java.util.*;

import com.polytech.Quiz_me.dto.QuizDTO;
import com.polytech.Quiz_me.mapper.QuizMapper;
import com.polytech.Quiz_me.model.Quiz;
import com.polytech.Quiz_me.service.QuizService;

@RequestMapping("/quizs")
@Controller
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("")
    public ResponseEntity<List<QuizDTO>> getAllQuizs() {

        List<Quiz> quizs = quizService.getAllQuizs();
        List<QuizDTO> quizsDtos = QuizMapper.toQuizDTOList(quizs);

        return ResponseEntity.ok(quizsDtos);
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<QuizDTO> getQuizById(@PathVariable Integer quizId) {

        Quiz quiz = quizService.getQuizById(quizId);

        if (quiz == null) {
            return ResponseEntity.notFound().build();
        } 
        QuizDTO dto = QuizMapper.toQuizDTO(quiz);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<QuizDTO> createQuiz(@RequestBody QuizDTO dto) {
        Quiz fromDto = QuizMapper.toQuiz(dto);
        Quiz createdQuiz = quizService.createQuiz(fromDto);
        if (createdQuiz == null) {
            return ResponseEntity.badRequest().build();
        }
        QuizDTO createdQuizDto = QuizMapper.toQuizDTO(createdQuiz);
        return ResponseEntity.ok(createdQuizDto);
    }

    @DeleteMapping("/{quizId}")
    public ResponseEntity<Boolean> deleteQuizById(@PathVariable Integer quizId) {
        boolean response = quizService.deleteQuiz(quizId);
        if (response == false) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(true);
    }

}