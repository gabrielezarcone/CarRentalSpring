package com.zarconeg.carRental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MostraPrenotazioniController {
    @GetMapping("admin/prenotazioni/{userid}")
    public String mostraPrenotazioniUtente(@PathVariable long userid, ModelMap model){
        return "prenotazioni";
    }
}
