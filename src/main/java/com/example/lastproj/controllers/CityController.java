package com.example.lastproj.controllers;

import com.example.lastproj.dto.request.CityCreateRequest;
import com.example.lastproj.models.City;
import com.example.lastproj.services.CitiesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cities")
@Slf4j
@AllArgsConstructor
public class CityController {
    private final CitiesService citiesService;
    @GetMapping
    public List<City> city(Model model){
        return citiesService.findAll();

    }
    @GetMapping("/{id}")
    public String cityShow(@PathVariable("id") int id, Model model){
        model.addAttribute("city", citiesService.findOne(id));
        return "cities/show";
    }
    @GetMapping("/new")
    public ModelAndView newCity(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("city", new City());
        return modelAndView;
    }
    @PostMapping
    public String create(@ModelAttribute CityCreateRequest city) {
        City newCity = new City();
        newCity.setCityName(city.getCityName());

        citiesService.save(newCity);
        return "redirect:/cities";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("city", citiesService.findOne(id));
        return "cities/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute @Valid City city ,@PathVariable("id") int id){

        citiesService.update(id, city);
        return "redirect:/cities";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        citiesService.delete(id);
        return "redirect:/cities";
    }

}
