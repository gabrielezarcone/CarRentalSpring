package com.zarconeg.carRental.controllers;

import com.zarconeg.carRental.domain.Ruolo;
import com.zarconeg.carRental.domain.User;
import com.zarconeg.carRental.service.RuoloService;
import com.zarconeg.carRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class ModificaUserController {

    @Autowired
    UserService userService;
    @Autowired
    RuoloService ruoloService;

    @RequestMapping("admin/modifica")
    public ModelAndView adminModificaUser(@RequestParam long userid, ModelMap model){
        User user = userService.getByIdEager(userid);
        List<String> roleNameList = ruoloService.getNameList();
        model.addAttribute("user", user);
        model.addAttribute("roleList", roleNameList);
        return new ModelAndView("modificaUser", model);
    }

    @PostMapping("admin/modifica")
    public ModelAndView actionAdminModificaUser(User user, BindingResult result, ModelMap model){
        userService.aggiungiAggiorna(user);
        return new ModelAndView("home", model);
    }
}
