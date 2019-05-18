package com.dusov.controllers;

import com.dusov.entities.OrderEntity;
import com.dusov.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/advertising")
    public String advertisingForm(Model model){
        model.addAttribute("orderEntity", new OrderEntity());
        return "advertising";
    }
    @PostMapping("/advertising")
    public String advertisingSubmit(@ModelAttribute OrderEntity orderEntity){
        orderRepository.save(orderEntity);
        return "date";
    }
}
