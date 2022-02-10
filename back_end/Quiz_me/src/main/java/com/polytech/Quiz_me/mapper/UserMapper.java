package com.polytech.Quiz_me.mapper;

import com.polytech.Quiz_me.dto.UserDTO;
import com.polytech.Quiz_me.model.User;

import java.util.*;

public class UserMapper {

    public static UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                        .id(user.getId())
                        .pseudo(user.getPseudo())
                        .build();
    }

    public static List<UserDTO> toUserDTOList(List<User> list) {
        List<UserDTO> dtoList = new ArrayList<>();
        for (User user : list) {
            dtoList.add(toUserDTO(user));
        }
        return dtoList;
    }
    
    public static User toUser(UserDTO dto) {
        return User.builder()
                        .id(dto.getID())
                        .pseudo(dto.getPseudo())
                        .build();
    }

    public static List<User> toUserList(List<UserDTO> list) {
        List<User> userList = new ArrayList<>();
        for (UserDTO dto : list) {
            userList.add(toUser(dto));
        }
        return userList;
    }
    
}
