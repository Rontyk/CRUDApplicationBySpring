package com.example.lastproj.controllers;

import com.example.lastproj.models.Address;
import com.example.lastproj.models.Sale;
import com.example.lastproj.services.SalesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/market/sales")
public class SaleController {
    private final SalesService salesService;
    @GetMapping("")
    public String sale(Model model){
        model.addAttribute("sales", salesService.findAll());
        return "sale/index";
    }
    @GetMapping("/{id}")
    public String saleShow(@PathVariable("id") int id, Model model){
        model.addAttribute("sale", salesService.findOne(id));
        return "sale/show";
    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("sale") Sale sale){
        return "sale/new";
    }
    @PostMapping
    public String create(@ModelAttribute("sale") @Valid Sale sale,
                         BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "sale/new";
        }

        salesService.save(sale);
        return "redirect:/sales";
    }
}
