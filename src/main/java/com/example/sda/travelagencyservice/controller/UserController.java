package com.example.sda.travelagencyservice.controller;


import com.example.sda.travelagencyservice.dto.UserDto;
import com.example.sda.travelagencyservice.model.User;
import com.example.sda.travelagencyservice.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {

    private UserDetailServiceImpl userDetailServiceImpl;

    @Autowired
    public UserController(UserDetailServiceImpl userDetailServiceImpl) {
        this.userDetailServiceImpl = userDetailServiceImpl;
    }


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user",new UserDto());
        return "login";
    }

    @GetMapping("/sign-up")
    public String getSignUpForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "sign-up";
    }

    @PostMapping("/register")
    public String saveUserSignUpForm(@ModelAttribute("user") UserDto user, BindingResult bindingResult) {
        User existing = userDetailServiceImpl.findByUsername(user.getUsername());
        if (existing!=null){
            bindingResult.rejectValue("username",null,"There is already an account registered with that username");
        }
        if (bindingResult.hasErrors()){
            return "sign-up";
        }
        userDetailServiceImpl.addNewUser(user);
        System.out.println(user);
        return "redirect:/login";
    }

}
