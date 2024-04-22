package com.example.lastproj.controllers;

import com.example.lastproj.dto.request.AddressCreateRequest;
import com.example.lastproj.models.Address;
import com.example.lastproj.services.AddressesService;
import com.example.lastproj.services.CitiesService;
import com.example.lastproj.util.AddressNotFoundException;
import com.example.lastproj.util.AddressesErrorResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/addresses")
@AllArgsConstructor
@Slf4j
public class AddressController {
    private final AddressesService addressesService;
    private final CitiesService citiesService;

    @ExceptionHandler
    private ResponseEntity<AddressesErrorResponse> handleException(AddressNotFoundException e){
        AddressesErrorResponse response = new AddressesErrorResponse(
                "Address not found ", System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Address> address(Model model){
        return addressesService.findAll();
    }
    @GetMapping("/{id}")
    public String addressShow(@PathVariable("id") int id, Model model){
        model.addAttribute("address", addressesService.findOne(id));
        model.addAttribute("city" , citiesService.findOne(addressesService.findOne(id).getCity().getCity_id()));
        return "addresses/show";
    }
    @GetMapping("/new")
    public ModelAndView newAddress(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("address", new Address());
        return modelAndView;
    }
    @PostMapping
    public String create(@ModelAttribute @Valid AddressCreateRequest address) {
        Address newAddress = new Address();
        newAddress.setStreet(address.getStreet());
        newAddress.setCity(citiesService.findOne(address.getCity_id()));
        newAddress.setZip_code(address.getZip_code());

        addressesService.save(newAddress);
        return "redirect:/addresses";
    }
}
