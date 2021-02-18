package com.zarconeg.carRental.controllers;

import com.zarconeg.carRental.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parcoAuto/")
public class ParcoAutoController {

    @Autowired
    AutoService autoService;

    // Model Attribute --------------------------------------------------------------------------------------------------------------------------------------------
    @ModelAttribute("autoList")
    public void initializeAutoList(ModelMap model) {
        model.addAttribute("autoList" ,autoService.getList());
    }


    // Mapping --------------------------------------------------------------------------------------------------------------------------------------------
    @GetMapping("")
    public String renderParcoAuto(ModelMap model){
        return "parcoAuto";
    }
}
