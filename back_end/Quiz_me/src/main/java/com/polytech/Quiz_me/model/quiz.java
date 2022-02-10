package com.polytech.Quiz_me.model;

import lombok.*;

import java.util.List;

import javax.persistence.*; // import persistance library


@Entity // mark class as a database entity
@Getter // specify separatly lombok annotation instead of @Data to avoid some problems
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quiz") // name of database table
public class quiz {
    
    @Id // annotation for ID column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy for ID, here it well be ID++
    @Column(length = 11) // column size on database side definition
    private Integer id_quiz;

    @Column(name = "theme_quiz", length = 50)
    private String theme_quiz;

    @Column(name = "questions",length=100) 
    private List<Integer> quest_list_id;  
}
