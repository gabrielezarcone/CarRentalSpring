package com.zarconeg.carRental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parcoAuto/")
public class ParcoAutoController {
    @GetMapping("")
    public String renderParcoAuto(ModelMap model){
        return "parcoAuto";
    }
}
