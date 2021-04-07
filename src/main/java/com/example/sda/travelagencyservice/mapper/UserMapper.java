package com.example.sda.travelagencyservice.mapper;

import com.example.sda.travelagencyservice.dto.UserDto;
import com.example.sda.travelagencyservice.model.Role;
import com.example.sda.travelagencyservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(UserDto userDto){
        if (userDto==null){
            return null;
        }else {
            return User.builder()
                    .username(userDto.getUsername())
                    .password(userDto.getPassword())
                    .email(userDto.getEmail())
                    .roles(Role.USER)
                    .build();
        }
    }

    public UserDto mapUserToDto(User user){
        if (user ==null){
            return null;
        }else {
            return UserDto.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .email(user.getEmail())
                    .role(user.getRoles().name())
                    .build();
        }
    }
}
