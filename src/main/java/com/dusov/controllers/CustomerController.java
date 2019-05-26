package com.dusov.controllers;

import com.dusov.entities.Customer;
import com.dusov.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("customer")
public class CustomerController {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public String registrationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "registration";
    }
    @PostMapping
    public String registrationSubmit(@ModelAttribute Customer customer){
        customerRepository.save(customer);
        return"customerSubmitResult";
    }
    @GetMapping("all")
    public String getAllCustomers(Model model){
        model.addAttribute("customers", customerRepository.findAll());
        return "dateOfCustomers";
    }
    @GetMapping("entrance")
    public String entranceForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "entrance";
    }
    @PostMapping("entrance")
    public String entranceSubmit(@ModelAttribute Customer customer){
        Optional<Customer> n = customerRepository.findById();
        if (customer.getPassword() == n.get()){
            return "date";
        } else {
            return "";
        }
    }
}
