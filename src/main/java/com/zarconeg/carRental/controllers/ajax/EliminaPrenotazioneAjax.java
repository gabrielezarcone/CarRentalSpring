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
@RequestMapping("/customer/ajax/")
public class EliminaPrenotazioneAjax {

    @Autowired
    PrenotazioneService prenotazioneService;

    @GetMapping("eliminaPrenotazione/{idPrenotazione}")
    public String eliminaPrenotazione(@PathVariable long idPrenotazione, ModelMap model){
        Prenotazione prenotazione = prenotazioneService.getById(idPrenotazione);
        prenotazioneService.elimina(prenotazione);
        return "homeCustomer";
    }
}
