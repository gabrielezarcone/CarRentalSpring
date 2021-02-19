package com.zarconeg.carRental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class ModificaAutoController {

    @GetMapping("modificaAuto/{idAuto}")
    public String modificaAuto(@PathVariable long idAuto, ModelMap model){
        return "modificaAuto";
    }
}
