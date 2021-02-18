package com.zarconeg.carRental.controllers;

import com.zarconeg.carRental.domain.Auto;
import com.zarconeg.carRental.domain.Prenotazione;
import com.zarconeg.carRental.domain.User;
import com.zarconeg.carRental.service.AutoService;
import com.zarconeg.carRental.service.PrenotazioneService;
import com.zarconeg.carRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    PrenotazioneService prenotazioneService;
    @Autowired
    AutoService autoService;


    // Model Attribute --------------------------------------------------------------------------------------------------------------------------------------------
    @ModelAttribute("autoList")
    public void initializeAutoList(ModelMap model) {
        model.addAttribute("autoList" ,autoService.getList());
    }


    // Home --------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping()
    public ModelAndView renderHomePage(ModelMap model){
        return new ModelAndView("home", model);
    }

    // ADMIN --------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping("admin/home")
    public ModelAndView adminHomePage(ModelMap model){
        List<User> userList = userService.getList();
        model.addAttribute("userList", userList);
        return new ModelAndView("homeAdmin", model);
    }

    @RequestMapping("admin/home/cerca/{filtro}/{testo}")
    public String cercaUtenteConFiltro(@PathVariable String filtro, @PathVariable String testo, ModelMap model){
        List<User> userList = userService.cerca(testo,filtro);
        model.addAttribute("userList", userList);
        return "homeAdmin";
    }


    // CUSTOMER --------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping("customer/home")
    public String customerHomePage(Principal principal, ModelMap model){
        User user = getUserFromPrincipal(principal);
        List<Prenotazione> prenotazioneList = userService.getPrenotazioni(user);
        initHomeCustomer(model, user, prenotazioneList);
        return "homeCustomer";
    }

    @RequestMapping("customer/home/cerca/prenotazione/stato/{stato}")
    public String customerHomePage(Principal principal, @PathVariable String stato, ModelMap model){
        User user = getUserFromPrincipal(principal);
        List<Prenotazione> prenotazioneList = prenotazioneService.cercaStato(user, stato);
        initHomeCustomer(model, user, prenotazioneList);
        return "homeCustomer";
    }
    @RequestMapping("customer/home/cerca/prenotazione/auto/{autoId}")
    public String customerHomePage(Principal principal, @PathVariable long autoId, ModelMap model){
        User user = getUserFromPrincipal(principal);
        Auto auto = autoService.getById(autoId);
        List<Prenotazione> prenotazioneList = prenotazioneService.cercaAuto(user, auto);
        initHomeCustomer(model, user, prenotazioneList);
        return "homeCustomer";
    }


    // Funzioni private --------------------------------------------------------------------------------------------------------------------------------------------
    private HashMap<Prenotazione, Boolean> mapEditablePrenotazioni(List<Prenotazione> prenotazioneList){
        // Trasformo la lista delle prenotazioni di quell'utente in una mappa che per ogni prenotazione(chiave) mi dice se l'inizio di quella prenotazione dista meno di due giorni da oggi o meno (valore booleano)
        Map<Prenotazione, Boolean> map = prenotazioneList.stream().collect(
                // toMap crea un elemento della mappa per ogni elemento della lista di partenza
                // con Function.identity() sto dicendo che la key deve essere lo stesso identico elemento della lista da cui parto
                // il valore invece lo genero usando quello stesso elemento e passandolo a prenotazioneService.isEditable
                Collectors.toMap(Function.identity(), prenotazione -> prenotazioneService.isEditable(prenotazione)));
        return new HashMap<>(map);
    }

    private User getUserFromPrincipal(Principal principal) {
        String username = principal.getName();
        return userService.getByUsername(username);
    }

    private void initHomeCustomer(ModelMap model, User user, List<Prenotazione> prenotazioneList) {
        HashMap<Prenotazione, Boolean> prenotazioneMap= mapEditablePrenotazioni(prenotazioneList);
        // alla view passo sia la lista che la mappa
        model.addAttribute("loggedUser", user);
        model.addAttribute("listaPrenotazioniUtente", prenotazioneList);
        model.addAttribute("mappaPrenotazioniUtente", prenotazioneMap);
    }
}
