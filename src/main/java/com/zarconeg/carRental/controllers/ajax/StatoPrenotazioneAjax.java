package com.zarconeg.carRental.controllers.ajax;

import com.zarconeg.carRental.domain.Prenotazione;
import com.zarconeg.carRental.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/prenotazioni/ajax/")
public class StatoPrenotazioneAjax {

    @Autowired
    PrenotazioneService prenotazioneService;

    @GetMapping("approva/{idPrenotazione}")
    public String approvaPrenotazione(@PathVariable long idPrenotazione, ModelMap model){
        Prenotazione prenotazione = prenotazioneService.getById(idPrenotazione);
        prenotazioneService.updateStatoAsString(prenotazione, "APPROVATO");
        return "homeAdmin";
    }
    @GetMapping("rifiuta/{idPrenotazione}")
    public String rifiutaPrenotazione(@PathVariable long idPrenotazione, ModelMap model){
        Prenotazione prenotazione = prenotazioneService.getById(idPrenotazione);
        prenotazioneService.updateStatoAsString(prenotazione, "RIFIUTATO");
        return "homeAdmin";
    }
}
