package com.zarconeg.carRental.controllers;

import com.zarconeg.carRental.domain.Prenotazione;
import com.zarconeg.carRental.domain.User;
import com.zarconeg.carRental.service.PrenotazioneService;
import com.zarconeg.carRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        String username = principal.getName();
        User user = userService.getByUsername(username);
        HashMap<Prenotazione, Boolean> prenotazioneMap= mapEditablePrenotazioni(user);
        List<Prenotazione> prenotazioneList = new ArrayList<>(prenotazioneMap.keySet());
        model.addAttribute("loggedUser",user);
        model.addAttribute("listaPrenotazioniUtente", prenotazioneList);
        model.addAttribute("mappaPrenotazioniUtente", prenotazioneMap);
        return "homeCustomer";
    }


    // Funzioni private --------------------------------------------------------------------------------------------------------------------------------------------
    private HashMap<Prenotazione, Boolean> mapEditablePrenotazioni(User user){
        List<Prenotazione> prenotazioneList = userService.getPrenotazioni(user);
        Map<Prenotazione, Boolean> map = prenotazioneList.stream().collect(
                Collectors.toMap(Function.identity(), prenotazione -> prenotazioneService.isEditable(prenotazione)));
        return new HashMap<>(map);
    }
}
