package com.win.tts.springboothw;

import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class UserController {
    

    @GetMapping("/signup")
    public String showSignUpForm(User user){
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-user";
        }
        userRepository.save(user);
        model.addAttribute("user", userRepository.findAll());
        return "redirect:/index";
    }
}