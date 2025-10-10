package com.itb.inf2fm.innova.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Projeto Innova está funcionando!";
    }
    
    @GetMapping("/api/test")
    public String test() {
        return "API funcionando corretamente";
    }
}