package com.polytech.Quiz_me.model;


import lombok.*;


import javax.persistence.*; // import persistance library


@Entity // mark class as a database entity
@Getter // specify separatly lombok annotation instead of @Data to avoid some problems
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question") // name of database table

public class Question {

    @Id // annotation for ID column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy for ID, here it well be ID++
    @Column(length = 11) // column size on database side definition
    private Integer id_quest;

    @Column(name = "quiz_id",length=100) 
    private Integer quiz_id;  

    @Column(name = "response_id",length=100) 
    private Integer response_id;  

    @Column(name = "question",length=100) 
    private String question;

    @Column(name = "response",length=100) 
    private String response;
    
}
