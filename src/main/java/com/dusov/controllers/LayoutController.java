package com.dusov.controllers;

import com.dusov.entities.OrderEntity;
import com.dusov.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("layout")
public class LayoutController {
    private final OrderRepository orderRepository;

    @Autowired
    public LayoutController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @GetMapping
    public String layoutForm(Model model){
        model.addAttribute("layoutEntity", new OrderEntity());
        return "layout";
    }
    @PostMapping
    public String layoutSubmit(@ModelAttribute OrderEntity layoutEntity){
        orderRepository.save(layoutEntity);
        return "redirect:/all";
    }
}

