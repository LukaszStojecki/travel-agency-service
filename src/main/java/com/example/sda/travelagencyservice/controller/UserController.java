package com.example.sda.travelagencyservice.controller;


import com.example.sda.travelagencyservice.dto.UserDto;
import com.example.sda.travelagencyservice.exception.ConflictException;
import com.example.sda.travelagencyservice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/sign-up")
    public String getSignUpForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String signup(@ModelAttribute("user") @Valid UserDto userDto,
                         Model model) throws ConflictException {
        if (userService.checkUserExists(userDto.getUsername(), userDto.getEmail())){
            if (userService.checkUsernameExists(userDto.getUsername())){
                model.addAttribute("usernameExists",true);
            }
            if (userService.checkEmailExists(userDto.getEmail())) {
                model.addAttribute("emailExists", true);
            }
            if (userService.checkValidatePassword(userDto.getPassword())){
                model.addAttribute("passwordCheck",true);
            }

            return "sign-up";

        }else {
            userService.signup(userDto);
            model.addAttribute("message", "User " + userDto.getUsername() + " registered successfully. Please login.");
            return "login";
        }
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, @RequestParam(required = false) String logout,
                        Model model) {
        if (error != null)
            model.addAttribute("error", "Invalid username or password.");

        if (logout != null)
            model.addAttribute("message", "User logged out successfully.");

        return "login";
    }

}
