package br.com.treinaweb.e_diarista.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AuthController {
    
    @RequestMapping("/login")
    public String login() {
        return "admin/auth/login";
    }
}
