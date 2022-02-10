package com.polytech.Quiz_me.model;

import lombok.*;
import javax.persistence.*; // import persistance library

@Entity // mark class as a database entity
@Getter // specify separatly lombok annotation instead of @Data to avoid some problems
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "results") // name of database table
public class Result {
    
    @Id // annotation for ID column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy for ID, here it well be ID++
    @Column(length = 11) // column size on database side definition
    private Integer id_result;

    @Column(name="id_user") // column size on database side definition
    private Integer id_user;  // TODO:: This will come from USER model

    @Column(name="id_quiz") // column size on database side definition
    private Integer id_quiz;  // TODO:: This will come from USER model

    @Column(name = "result", length = 50)
    private String result;



}
