package com.example.lastproj.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/market/main")
public class MarketController {
    @GetMapping()
    public String index(){
        return "market";
    }

}
