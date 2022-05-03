package com.pondmanage.controller;

import com.pondmanage.dto.AccountDTO;
import com.pondmanage.dto.PasswordDTO;
import com.pondmanage.model.Account;
import com.pondmanage.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/login")
    public String loginPage(){
        return "/accounts/login";
    }
    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("account", new AccountDTO());
        return "/accounts/register";
    }
    @PostMapping("/register")
    public String registerProcess(Model model,
                                  @Valid AccountDTO accountDTO,
                                  BindingResult result,
                                  RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("error", "Error Occurred");
            return "redirect:/login";
        }
        accountService.register(accountDTO);
        return "redirect:/login";
    }
    @GetMapping("/changePassword")
    public String changePassword(Model model){
        model.addAttribute("passwordDTO", new PasswordDTO());
        return "/accounts/changePassword";
    }
    @PostMapping("/changePassword")
    public String handleChangePassword(@Valid PasswordDTO passwordDTO, BindingResult result){
        if (result.hasErrors()) return "redirect:/changePassword";
        accountService.changePassword(passwordDTO);
        return "home";
    }
}
