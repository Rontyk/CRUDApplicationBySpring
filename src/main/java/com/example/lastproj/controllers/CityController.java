package com.example.lastproj.controllers;

import com.example.lastproj.models.Address;
import com.example.lastproj.models.City;
import com.example.lastproj.services.CitiesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("market/cities")
@AllArgsConstructor
public class CityController {
    private final CitiesService citiesService;
    @GetMapping("")
    public String city(Model model){
        model.addAttribute("cities", citiesService.findAll());
        return "city/index";
    }
    @GetMapping("/{id}")
    public String cityShow(@PathVariable("id") int id, Model model){
        model.addAttribute("city", citiesService.findOne(id));
        return "city/show";
    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("city") City city){
        return "city/new";
    }
    @PostMapping
    public String create(@ModelAttribute("city") @Valid City city,
                         BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "city/new";
        }

        citiesService.save(city);
        return "redirect:/cities";
    }
}
