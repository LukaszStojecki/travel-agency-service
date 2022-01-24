package com.example.sda.travelagencyservice.service;


import com.example.sda.travelagencyservice.dto.UserDto;
import com.example.sda.travelagencyservice.exception.ConflictException;
import com.example.sda.travelagencyservice.exception.NotFoundException;
import com.example.sda.travelagencyservice.mapper.UserMapper;
import com.example.sda.travelagencyservice.model.Role;
import com.example.sda.travelagencyservice.model.User;
import com.example.sda.travelagencyservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {


    private static final long IDENTIFIER = 1L;
    private static final User USER = new User(IDENTIFIER, "Admin", "password", "admin@p2.pl", Role.USER);
    private static final UserDto USER_DTO = new UserDto(IDENTIFIER, "admin", "password", "admin@o2.pl", "ADMIN");
    private static final UserDto USER_DTO_NULL = new UserDto(null, "Admin", "password", "admin@p2.pl", "ADMIN");

    @Mock
    UserRepository userRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @Spy
    UserMapper userMapper;

    @InjectMocks
    UserService userService;

    @Test
    public void shouldAddUser() throws ConflictException {
        //given
        when(userRepository.existsById(USER_DTO.getId())).thenReturn(false);
        when(passwordEncoder.encode(USER_DTO.getPassword())).thenReturn(USER_DTO.getPassword());
        //when
        userService.signup(USER_DTO);
        //then
        verify(userRepository).existsById(USER_DTO.getId());
        verify(userRepository).save(userMapper.mapToUser(USER_DTO));
        verify(passwordEncoder).encode(anyString());
    }

    @Test
    public void shouldAddUserWithNullId() throws ConflictException {

        when(passwordEncoder.encode(USER_DTO_NULL.getPassword())).thenReturn(USER_DTO_NULL.getPassword());
        //when
        userService.signup(USER_DTO_NULL);
        //then
        verify(userRepository, never()).existsById(USER_DTO_NULL.getId());
        verify(userRepository).save(userMapper.mapToUser(USER_DTO_NULL));
        verify(passwordEncoder).encode(USER_DTO_NULL.getPassword());
    }


    @Test
    public void shouldGetUserById() throws NotFoundException {
        //given
        when(userRepository.findById(USER.getId())).thenReturn(Optional.of(USER));
        //when
        UserDto actualUser = userService.getUserById(USER.getId());
        //then
        assertThat(actualUser).isEqualTo(userMapper.mapUserToDto(USER));
        verify(userRepository).findById(USER.getId());
    }

    @Test
    void addUserShouldThrowExceptionForUserExisting() {
        // given
        when(userRepository.existsById(USER_DTO.getId())).thenReturn(true);

        // then
        assertThrows(ConflictException.class, () -> userService.signup(USER_DTO));
        verify(userRepository).existsById(USER_DTO.getId());
        verify(userRepository, never()).save(userMapper.mapToUser(USER_DTO));
    }

    @Test
    void addUserShouldThrowIllegalArgumentExceptionForNullUser() {
        //then
        assertThrows(IllegalArgumentException.class, () -> userService.signup(null));
        verify(userRepository, never()).existsById(any());
        verify(userRepository, never()).save(userMapper.mapToUser(USER_DTO));
    }

}
