package com.example.sda.travelagencyservice.service;

import com.example.sda.travelagencyservice.dto.UserDto;
import com.example.sda.travelagencyservice.model.Role;
import com.example.sda.travelagencyservice.model.User;
import com.example.sda.travelagencyservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserDetailServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void addNewUser(UserDto userDto) {
        User addUser = new User();
        addUser.setUsername(userDto.getUsername());
        addUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        addUser.setRoles((Role.USER));
        userRepository.save(addUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Role role) {
        return singletonList(new SimpleGrantedAuthority("ROLE_" + role.toString()));
    }
}

