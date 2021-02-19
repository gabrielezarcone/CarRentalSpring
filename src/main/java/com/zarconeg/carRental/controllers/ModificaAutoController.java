package com.zarconeg.carRental.controllers;

import com.zarconeg.carRental.domain.Auto;
import com.zarconeg.carRental.domain.User;
import com.zarconeg.carRental.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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

    @GetMapping("aggiungiAuto")
    public String aggiungiAuto(ModelMap model){
        Auto auto = new Auto();
        model.addAttribute("auto", auto);
        return "modificaAuto";
    }

    // Gestione forms ------------------------------------------------------------------------------------
    @PostMapping(value = {
            "modificaAuto/{idAuto}",
            "aggiungiAuto"
    })
    public String formModificaAuto(@Valid Auto auto, BindingResult result, ModelMap model){
        if(result.hasErrors()) {
            return modificaAuto(auto.getId(),model);
        }
        autoService.aggiungiAggiorna(auto);
        return "redirect:/parcoAuto/";
    }

}
