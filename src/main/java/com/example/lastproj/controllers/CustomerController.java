package com.example.lastproj.controllers;

import com.example.lastproj.dto.request.CustomerCreateRequest;
import com.example.lastproj.models.Address;
import com.example.lastproj.models.Customer;
import com.example.lastproj.services.CustomersService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomersService customersService;
    @GetMapping
    public String customer(Model model){
        model.addAttribute("customers", customersService.findAll());
        return "customers/index";
    }
    @GetMapping("/{id}")
    public String customerShow(@PathVariable("id") int id, Model model){
        model.addAttribute("customer", customersService.findOne(id));
        return "customers/show";
    }
    @GetMapping("/new")
    public ModelAndView newCustomer(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
    @PostMapping
    public String create(@ModelAttribute CustomerCreateRequest customer) {
        Customer newCustomer = new Customer();
        newCustomer.setFirstname(customer.getFirstname());
        newCustomer.setLastname(customer.getLastname());
        newCustomer.setPhoneNumber(customer.getPhoneNumber());
        newCustomer.setEmail(customer.getEmail());
        System.out.println(customer.getFirstname() + customer.getLastname()+ customer.getPhoneNumber() + customer.getEmail());

        customersService.save(newCustomer);
        return "redirect:/customers";
    }
}
