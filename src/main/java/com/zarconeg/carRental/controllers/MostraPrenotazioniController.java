package com.zarconeg.carRental.controllers;

import com.zarconeg.carRental.domain.Auto;
import com.zarconeg.carRental.domain.Prenotazione;
import com.zarconeg.carRental.domain.User;
import com.zarconeg.carRental.service.AutoService;
import com.zarconeg.carRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MostraPrenotazioniController {

    @Autowired
    UserService userService;
    @Autowired
    AutoService autoService;

    @GetMapping("admin/prenotazioni/{userid}")
    public String mostraPrenotazioniUtente(@PathVariable long userid, ModelMap model){
        User user = userService.getById(userid);
        List<Prenotazione> prenotazioneList = userService.getPrenotazioni(user);
        model.addAttribute("listaPrenotazioniUtente", prenotazioneList);
        return "prenotazioni";
    }

    @GetMapping("admin/prenotazioni/auto/{autoId}")
    public String mostraPrenotazioniAuto(@PathVariable long autoId, ModelMap model){
        Auto auto = autoService.getById(autoId);
        List<Prenotazione> prenotazioneList = autoService.getPrenotazioni(auto);
        model.addAttribute("auto", auto);
        model.addAttribute("listaPrenotazioniAuto", prenotazioneList);
        return "prenotazioniAuto";
    }
}
