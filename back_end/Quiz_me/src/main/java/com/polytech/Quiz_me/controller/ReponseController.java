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

import com.polytech.Quiz_me.dto.ReponseDTO;
import com.polytech.Quiz_me.mapper.ReponseMapper;
import com.polytech.Quiz_me.model.Reponse;
import com.polytech.Quiz_me.service.ReponseService;

@RequestMapping("/reponses")
@Controller
public class ReponseController {

    private final ReponseService reponseService;

    public ReponseController(ReponseService reponseService) {
        this.reponseService = reponseService;
    }

    @GetMapping("")
    public ResponseEntity<List<ReponseDTO>> getAllReponses() {

        List<Reponse> reponses = reponseService.getAllReponses();
        List<ReponseDTO> reponsesDtos = ReponseMapper.toReponseDTOList(reponses);

        return ResponseEntity.ok(reponsesDtos);
    }

    @GetMapping("/{reponseId}")
    public ResponseEntity<ReponseDTO> getReponseById(@PathVariable Integer reponseId) {

        Reponse reponse = reponseService.getReponseById(reponseId);

        if (reponse == null) {
            return ResponseEntity.notFound().build();
        } 
        ReponseDTO dto = ReponseMapper.toReponseDTO(reponse);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<ReponseDTO> createReponse(@RequestBody ReponseDTO dto) {
        Reponse fromDto = ReponseMapper.toReponse(dto);
        Reponse createdReponse = reponseService.createReponse(fromDto);
        if (createdReponse == null) {
            return ResponseEntity.badRequest().build();
        }
        ReponseDTO createdReponseDto = ReponseMapper.toReponseDTO(createdReponse);
        return ResponseEntity.ok(createdReponseDto);
    }

    @DeleteMapping("/{reponseId}")
    public ResponseEntity<Boolean> deleteReponseById(@PathVariable Integer reponseId) {
        boolean response = reponseService.deleteReponse(reponseId);
        if (response == false) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(true);
    }

}