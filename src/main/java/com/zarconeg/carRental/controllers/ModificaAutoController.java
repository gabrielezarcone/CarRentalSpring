package com.zarconeg.carRental.controllers;

import com.zarconeg.carRental.domain.Auto;
import com.zarconeg.carRental.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class ModificaAutoController {

    @Autowired
    AutoService autoService;

    @GetMapping("modificaAuto/{idAuto}")
    public String modificaAuto(@PathVariable long idAuto, ModelMap model){
        Auto auto = autoService.getById(idAuto);
        model.addAttribute("auto", auto);
        return "modificaAuto";
    }
}
