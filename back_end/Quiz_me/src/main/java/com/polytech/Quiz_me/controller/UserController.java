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

import com.polytech.Quiz_me.dto.UserDTO;
import com.polytech.Quiz_me.mapper.UserMapper;
import com.polytech.Quiz_me.model.User;
import com.polytech.Quiz_me.service.UserService;

@RequestMapping("/users")
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        List<User> users = userService.getAllUsers();
        List<UserDTO> usersDtos = UserMapper.toUserDTOList(users);

        return ResponseEntity.ok(usersDtos);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId) {

        User user = userService.getUserById(userId);

        if (user == null) {
            return ResponseEntity.notFound().build();
        } 
        UserDTO dto = UserMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto) {
        User fromDto = UserMapper.toUser(dto);
        User createdUser = userService.createUser(fromDto);
        if (createdUser == null) {
            return ResponseEntity.badRequest().build();
        }
        UserDTO createdUserDto = UserMapper.toUserDTO(createdUser);
        return ResponseEntity.ok(createdUserDto);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable Integer userId) {
        boolean response = userService.deleteUser(userId);
        if (response == false) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(true);
    }

}