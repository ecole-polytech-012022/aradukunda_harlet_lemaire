package com.polytech.Quiz_me.service;

import org.springframework.stereotype.Service;

import java.util.*;

import com.polytech.Quiz_me.model.Result;
import com.polytech.Quiz_me.repository.ResultRepository;

@Service
public class quizService {
    
    public List<Result> list = new ArrayList<>();
    public Integer id = 1;

    public List<Result> getAllResults() {
        return this.repository.findAll();
    }

    public Result getResultById(Integer id) {

        Optional<Result> found = this.repository.findById(id);

        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }   

    public Result createResult(Result givenResult) {

        if (givenResult.getResult() != null) {
            return this.repository.save(givenResult);
        }
        return null;
    }

    public boolean deleteResult(Integer ResultId) {
        Result found = getResultById(ResultId);
        if (found != null) {
            this.repository.deleteById(found.getId());
            return true;
        }
        return false;
    }

    private final ResultRepository repository;

    public ResultService(ResultRepository repository) {
        this.repository = repository;
    } 

}