package com.pondmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
    @GetMapping("/login")
    public String loginPage(){
        return "/accounts/login";
    }
    @GetMapping("/register")
    public String registerPage(Model model){

        return "/accounts/register";
    }
}
