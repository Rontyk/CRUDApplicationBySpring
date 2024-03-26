package com.example.lastproj.controllers;

import com.example.lastproj.models.Address;
import com.example.lastproj.models.Product;
import com.example.lastproj.services.AddressesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/market/addresses")
@AllArgsConstructor
public class AddressController {
    private final AddressesService addressesService;

    @GetMapping("")
    public String address(Model model){
        model.addAttribute("addresses", addressesService.findAll());
        return "address/index";
    }
    @GetMapping("/{id}")
    public String addressShow(@PathVariable("id") int id, Model model){
        model.addAttribute("address", addressesService.findOne(id));
        return "address/show";
    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("address") Address address){
        return "address/new";
    }
    @PostMapping
    public String create(@ModelAttribute("address") @Valid Address address,
                         BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "address/new";
        }

        addressesService.save(address);
        return "redirect:/addresses";
    }
}
