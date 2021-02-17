package com.zarconeg.carRental.controllers;

import com.zarconeg.carRental.domain.Auto;
import com.zarconeg.carRental.domain.Prenotazione;
import com.zarconeg.carRental.service.AutoService;
import com.zarconeg.carRental.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class ModificaPrenotazione {

    @Autowired
    PrenotazioneService prenotazioneService;
    @Autowired
    AutoService autoService;

    @GetMapping("/customer/modificaPrenotazione/{idPrenotazione}")
    public String modficaPrenotazione(@PathVariable long idPrenotazione, ModelMap model){
        Prenotazione prenotazione = prenotazioneService.getById(idPrenotazione);
        model.addAttribute("prenotazione", prenotazione);
        return "modificaPrenotazione";
    }

    @ModelAttribute("autoList")
    public List<Auto> initializeAutoList() {
        return autoService.getList();
    }
}
