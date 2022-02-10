package com.polytech.Quiz_me.model;

import lombok.*;


import javax.persistence.*; // import persistance library


@Entity // mark class as a database entity
@Getter // specify separatly lombok annotation instead of @Data to avoid some problems
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "response") // name of database table

public class reponse {

    @Column(name = "question_id",length=100) 
    private Integer id_quest;

    @Column(name = "response",length=100) 
    private String response;
    
}
