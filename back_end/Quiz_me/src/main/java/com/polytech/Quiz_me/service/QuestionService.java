package com.polytech.Question_me.service;

import org.springframework.stereotype.Service;

import java.util.*;

import com.polytech.Question_me.model.question;
import com.polytech.Question_me.repository.UserRepository;

@Service
public class questionService {


    public List<Question> list = new ArrayList<>();
    public Integer id = 1;

    public List<Question> getAllQuestion() {
        return this.repository.findAll();
    }

    public Question getQuestionById(Integer id) {

        Optional<Question> found = this.repository.findById(id);

        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }

    public Question createQuestion(Question givenQuestion) {

        if (givenQuestion.getQuestion() != null ) {
            return this.repository.save(givenQuestion);
        }
        return null;
    }

    public boolean deleteQuestion(Integer questionId) {
        Question found = getQuestionById(questionId);
        if (found != null) {
            this.repository.deleteById(found.getId());
            return true;
        }
        return false;
    }

    private final QuestionRepository repository;

    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }
}