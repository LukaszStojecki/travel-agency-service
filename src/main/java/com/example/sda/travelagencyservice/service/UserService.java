package com.example.sda.travelagencyservice.service;


import com.example.sda.travelagencyservice.dto.UserDto;
import com.example.sda.travelagencyservice.exception.ConflictException;
import com.example.sda.travelagencyservice.exception.NotFoundException;
import com.example.sda.travelagencyservice.mapper.UserMapper;
import com.example.sda.travelagencyservice.model.Role;
import com.example.sda.travelagencyservice.model.User;
import com.example.sda.travelagencyservice.repository.UserRepository;
import com.example.sda.travelagencyservice.utils.PasswordValidator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Transactional
    public void signup(UserDto userDto) throws ConflictException {

        if (userDto == null) {
            logger.error("Attempt to add null user.");
            throw new IllegalArgumentException("User cannot be null.");
        }
        if (userDto.getId() != null && userRepository.existsById(userDto.getId())) {
            logger.error("Attempt to add user already existing.");
            throw new ConflictException("User already exists.");
        }
        User user = userMapper.mapToUser(userDto);
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Role.USER);
        userMapper.mapUserToDto(user);
        userRepository.save(user);
    }


    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::mapUserToDto)
                .collect(Collectors.toList());
    }

    public boolean checkUsernameExists(String username) {
        return  userRepository.existsByUsername(username);
    }

    public boolean checkEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean checkValidatePassword(String password) {
        return !PasswordValidator.validate(password);
    }

    public boolean checkUserExists(String username, String email) {
        return checkUsernameExists(username) || checkEmailExists(email);
    }

    public UserDto getUserById(Long id) throws NotFoundException {
        return userRepository.findById(id)
                .map(userMapper::mapUserToDto)
                .orElseThrow(() -> new NotFoundException("User of id " + id + ", doesn't exist"));
    }

    public User getUserByEmail(String email) throws NotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("User not found"));
    }
}
