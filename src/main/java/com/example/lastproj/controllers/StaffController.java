package com.example.lastproj.controllers;

import com.example.lastproj.dto.request.StaffCreateRequest;
import com.example.lastproj.models.Staff;
import com.example.lastproj.services.AddressesService;
import com.example.lastproj.services.StaffsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/staffs")
@AllArgsConstructor
public class StaffController {
    private final StaffsService staffsService;
    private final AddressesService addressesService;

    @GetMapping
    public String staff(Model model){
        model.addAttribute("staffs", staffsService.findAll());
        return "staffs/index";
    }
    @GetMapping("/{id}")
    public String staffShow(@PathVariable("id") int id, Model model){
        model.addAttribute("staff", staffsService.findOne(id));
        model.addAttribute("address", addressesService.findOne(staffsService.findOne(id).getAddress().getId()));
        return "staffs/show";
    }
    @GetMapping("/new")
    public ModelAndView newStaff(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("staff", new Staff());
        return modelAndView;
    }
    @PostMapping
    public String create(@ModelAttribute StaffCreateRequest staff) {
        Staff newStaff = new Staff();
        System.out.println(staff.getLast_name() + " " + staff.getFirst_name() + staff.getPosition() + staff.getPhone() + staff.getAddress_id());
        newStaff.setFirstname(staff.getFirst_name());
        newStaff.setLastname(staff.getLast_name());
        newStaff.setPhone(staff.getPhone());
        newStaff.setPosition(staff.getPosition());
        newStaff.setAddress(addressesService.findOne(staff.getAddress_id()));

        staffsService.save(newStaff);
        return "redirect:/staffs";
    }
}
