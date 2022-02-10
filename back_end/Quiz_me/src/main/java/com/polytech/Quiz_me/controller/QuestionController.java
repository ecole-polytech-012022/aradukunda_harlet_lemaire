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

import com.polytech.Quiz_me.dto.QuestionDTO;
import com.polytech.Quiz_me.mapper.QuestionMapper;
import com.polytech.Quiz_me.model.Question;
import com.polytech.Quiz_me.service.QuestionService;

@RequestMapping("/questions")
@Controller
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("")
    public ResponseEntity<List<QuestionDTO>> getAllQuestions() {

        List<Question> questions = questionService.getAllQuestion();
        List<QuestionDTO> questionsDtos = QuestionMapper.toQuestionDTOList(questions);

        return ResponseEntity.ok(questionsDtos);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionDTO> getQuestionById(@PathVariable Integer questionId) {

        Question question = questionService.getQuestionById(questionId);

        if (question == null) {
            return ResponseEntity.notFound().build();
        } 
        QuestionDTO dto = QuestionMapper.toQuestionDTO(question);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<QuestionDTO> createQuestion(@RequestBody QuestionDTO dto) {
        Question fromDto = QuestionMapper.toQuestion(dto);
        Question createdQuestion = questionService.createQuestion(fromDto);
        if (createdQuestion == null) {
            return ResponseEntity.badRequest().build();
        }
        QuestionDTO createdQuestionDto = QuestionMapper.toQuestionDTO(createdQuestion);
        return ResponseEntity.ok(createdQuestionDto);
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<Boolean> deleteQuestionById(@PathVariable Integer questionId) {
        boolean response = questionService.deleteQuestion(questionId);
        if (response == false) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(true);
    }

}