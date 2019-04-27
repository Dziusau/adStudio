package com.dusov.controllers;

import com.dusov.entities.Order;
import com.dusov.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/advertising")
    public String advertisingForm(Model model){
        model.addAttribute("order", new Order());
        return "ad_studio/advertising";
    }
    @PostMapping("/advertising")
    public String advertisingSubmit(@ModelAttribute Order order){
        return "ad_studio/advertising";
    }
}
