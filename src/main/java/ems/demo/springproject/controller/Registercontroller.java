package ems.demo.springproject.controller;

import ems.demo.springproject.entityvalues.Userdetail;
import ems.demo.springproject.repository.Userrepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class Registercontroller {
    private final Userrepository userrepository;
    private final PasswordEncoder passwordencoder;
    public Registercontroller(Userrepository userrepository,PasswordEncoder passwordencoder){
        this.userrepository=userrepository;
        this.passwordencoder=passwordencoder;
    }
    @GetMapping("/register")
    public String showregisterform(Model model){
        model.addAttribute("user",new Userdetail());
        return "register";
    }
    @PostMapping("/register")
    public String registeruserI(@ModelAttribute Userdetail user ){
        user.setPassword(passwordencoder.encode(user.getPassword()));
        userrepository.save(user);
        return "redirect:/login";
    }
}
