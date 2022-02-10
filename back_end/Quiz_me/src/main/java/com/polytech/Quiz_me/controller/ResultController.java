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

import com.polytech.Quiz_me.dto.ResultDTO;
import com.polytech.Quiz_me.mapper.ResultMapper;
import com.polytech.Quiz_me.model.Result;
import com.polytech.Quiz_me.service.ResultService;

@RequestMapping("/Results")
@Controller
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("")
    public ResponseEntity<List<ResultDTO>> getAllResult() {

        List<Result> result = resultService.getAllResult();
        List<ResultDTO> resultDtos = ResultMapper.toResultDTOList(result);

        return ResponseEntity.ok(resultDtos);
    }

    @GetMapping("/{ResultId}")
    public ResponseEntity<ResultDTO> getResultById(@PathVariable Integer ResultId) {

        Result Result = resultService.getResultById(ResultId);

        if (Result == null) {
            return ResponseEntity.notFound().build();
        } 
        ResultDTO dto = ResultMapper.toResultDTO(Result);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<ResultDTO> createResult(@RequestBody ResultDTO dto) {
        Result fromDto = ResultMapper.toResult(dto);
        Result createdResult = resultService.createResult(fromDto);
        if (createdResult == null) {
            return ResponseEntity.badRequest().build();
        }
        ResultDTO createdResultDto = ResultMapper.toResultDTO(createdResult);
        return ResponseEntity.ok(createdResultDto);
    }

    @DeleteMapping("/{ResultId}")
    public ResponseEntity<Boolean> deleteResultById(@PathVariable Integer ResultId) {
        boolean response = resultService.deleteResult(ResultId);
        if (response == false) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(true);
    }

}