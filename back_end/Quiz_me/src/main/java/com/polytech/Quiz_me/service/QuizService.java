package com.polytech.Quiz_me.service;

import org.springframework.stereotype.Service;

import java.util.*;

import com.polytech.Quiz_me.model.quiz;
import com.polytech.Quiz_me.repository.QuizRepository;

@Service
public class quizService {
    
    public List<Quiz> list = new ArrayList<>();
    public Integer id = 1;

    public List<Quiz> getAllQuiz() {
        return this.repository.findAll();
    }

    public Quiz getQuizById(Integer id) {

        Optional<Quiz> found = this.repository.findById(id);

        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }

    public Quiz createQuiz(Quiz givenQuiz) {

        if (givenQuiz.getThemeQuiz() != null ) {
            return this.repository.save(givenQuiz);
        }
        return null;
    }

    public boolean deleteQuiz(Integer quizId) {
        Quiz found = getQuizById(quizId);
        if (found != null) {
            this.repository.deleteById(found.getId());
            return true;
        }
        return false;
    }

    private final QuizRepository repository;

    public QuizService(QuizRepository repository) {
        this.repository = repository;
    }
}