package com.zarconeg.carRental.controllers;

import com.zarconeg.carRental.domain.Auto;
import com.zarconeg.carRental.domain.Prenotazione;
import com.zarconeg.carRental.service.AutoService;
import com.zarconeg.carRental.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class ModificaPrenotazione {

    @Autowired
    PrenotazioneService prenotazioneService;
    @Autowired
    AutoService autoService;
    @Autowired
    HomeController homeController;

    // Model Attributes ---------------------------------------------------------------------------------------------------------------------------
    @ModelAttribute("autoList")
    public List<Auto> initializeAutoList() {
        return autoService.getList();
    }

    // Request Mapping ---------------------------------------------------------------------------------------------------------------------------
    @GetMapping("/customer/modificaPrenotazione/{idPrenotazione}")
    public String modificaPrenotazione(@PathVariable long idPrenotazione, ModelMap model){
        Prenotazione prenotazione = prenotazioneService.getById(idPrenotazione);
        model.addAttribute("prenotazione", prenotazione);
        return "modificaPrenotazione";
    }

    @PostMapping("/customer/modificaPrenotazione/{idPrenotazione}")
    public String formModificaPrenotazione(@Valid Prenotazione prenotazione, BindingResult result, ModelMap model){
        if(result.hasErrors()) {
            return modificaPrenotazione(prenotazione.getId(),model);
        }
        prenotazioneService.aggiungiModifica(prenotazione);
        return "redirect:/customer/home";
    }
}