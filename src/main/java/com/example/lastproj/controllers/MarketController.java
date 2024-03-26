package com.example.lastproj.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/market")
public class MarketController {
    @GetMapping()
    public String index(){
        return "market";
    }

}
