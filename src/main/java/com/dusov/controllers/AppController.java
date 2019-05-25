package com.dusov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/")
    public String advertisingForm() {
        return "index";
    }
    @GetMapping("/contact")
    public String contactForm(){
        return "contact";
    }
    @GetMapping("/date")
    public String dateForm(){
        return "date";
    }
}
