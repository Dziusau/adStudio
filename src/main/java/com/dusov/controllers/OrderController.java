package com.dusov.controllers;

import com.dusov.entities.OrderEntity;
import com.dusov.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("advertising")
public class OrderController {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public String advertisingForm(Model model){
        model.addAttribute("orderEntity", new OrderEntity());
        return "advertising";
    }
    @PostMapping
    public String advertisingSubmit(@ModelAttribute OrderEntity orderEntity){
        orderRepository.save(orderEntity);
        return "redirect:/advertising/all";
    }

    @GetMapping("all")
    public String getAdvertisingAll(Model model){
        model.addAttribute("orderEntities", orderRepository.findAll());
        return "date";
    }
}
