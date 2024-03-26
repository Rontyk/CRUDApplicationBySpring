package com.example.lastproj.controllers;

import com.example.lastproj.models.Address;
import com.example.lastproj.models.Customer;
import com.example.lastproj.services.CustomersService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/market/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomersService customersService;
    @GetMapping("")
    public String customer(Model model){
        model.addAttribute("customers", customersService.findAll());
        return "customer/index";
    }
    @GetMapping("/{id}")
    public String customerShow(@PathVariable("id") int id, Model model){
        model.addAttribute("customer", customersService.findOne(id));
        return "customer/show";
    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("customer") Customer customer){
        return "customer/new";
    }
    @PostMapping
    public String create(@ModelAttribute("customer") @Valid Customer customer,
                         BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "customer/new";
        }

        customersService.save(customer);
        return "redirect:/customers";
    }
}
