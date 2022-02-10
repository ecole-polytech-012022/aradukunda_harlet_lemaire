package com.polytech.Quiz_me.repository;

import com.polytech.Quiz_me.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<User, Integer> { // using JpaRepository super class
}