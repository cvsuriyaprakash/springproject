package ems.demo.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class Logincontrol {
    @GetMapping("/login")
    public String loginPage(){
        return "login" ;
    }
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
