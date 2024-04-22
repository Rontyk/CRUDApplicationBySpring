package com.example.lastproj.controllers;

import com.example.lastproj.dto.request.SaleCreateRequest;
import com.example.lastproj.models.Address;
import com.example.lastproj.models.Sale;
import com.example.lastproj.services.CustomersService;
import com.example.lastproj.services.ProductsService;
import com.example.lastproj.services.SalesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/sales")
public class SaleController {
    private final SalesService salesService;
    private final ProductsService productsService;
    private final CustomersService customersService;
    @GetMapping
    public String sale(Model model){
        model.addAttribute("sales", salesService.findAll());
        return "sales/index";
    }
    @GetMapping("/{id}")
    public String saleShow(@PathVariable("id") int id, Model model){
        model.addAttribute("sale", salesService.findOne(id));
        model.addAttribute("customer", customersService.findOne(salesService.findOne(id).getCustomer().getCustomer_id()));
        model.addAttribute("product", productsService.findOne(salesService.findOne(id).getProduct().getProduct_id()));
        return "sales/show";
    }
    @GetMapping("/new")
    public ModelAndView newSale(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sale", new Sale());
        return modelAndView;
    }
    @PostMapping
    public String create(@ModelAttribute SaleCreateRequest sale) {
        Sale newSale = new Sale();
        System.out.println(sale.getSalesDate() + " " + sale.getTotalAmount() +" "+ sale.getCustomer_id() + sale.getProduct_id());
        newSale.setSaleDate(sale.getSalesDate());
        newSale.setProduct(productsService.findOne(sale.getProduct_id()));
        newSale.setCustomer(customersService.findOne(sale.getCustomer_id()));
        newSale.setTotalAmount(sale.getTotalAmount());


        salesService.save(newSale);
        return "redirect:/sales";
    }
}
