package com.dusov.controllers;

import com.dusov.entities.Customer;
import com.dusov.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/add")
    public @ResponseBody
    Iterable<Customer> addNewCustomer(@RequestParam String name){
        Customer n = new Customer();
        n.setName(name);
        customerRepository.save(n);
        return customerRepository.findAll();
    }
}
