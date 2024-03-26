package com.example.lastproj.controllers;

import com.example.lastproj.models.Address;
import com.example.lastproj.models.Staff;
import com.example.lastproj.services.StaffsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/market/staffs")
@AllArgsConstructor
public class StaffController {
    private final StaffsService staffsService;

    @GetMapping("")
    public String staff(Model model){
        model.addAttribute("staffs", staffsService.findAll());
        return "staff/index";
    }
    @GetMapping("/{id}")
    public String staffShow(@PathVariable("id") int id, Model model){
        model.addAttribute("staff", staffsService.findOne(id));
        return "staff/show";
    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("staff") Staff staff){
        return "staff/new";
    }
    @PostMapping
    public String create(@ModelAttribute("staff") @Valid Staff staff,
                         BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "staff/new";
        }

        staffsService.save(staff);
        return "redirect:/staffs";
    }
}
