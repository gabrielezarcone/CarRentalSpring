package com.zarconeg.carRental.controllers;

import com.zarconeg.carRental.domain.User;
import com.zarconeg.carRental.service.RuoloService;
import com.zarconeg.carRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/profilo")
public class ProfiloController {

    @Autowired
    UserService userService;
    @Autowired
    RuoloService ruoloService;

    // Model mapping --------------------------------------------------------------------------------------------------------------
    @ModelAttribute("roleList")
    public void initializeAutoList(ModelMap model) {
        List<String> roleNameList = ruoloService.getNameList();
        model.addAttribute("roleList", roleNameList);
    }
    @ModelAttribute("user")
    public void initializeLoggedUser(Principal principal, ModelMap model) {
        User user = userService.getByUsername(principal.getName());
        user = userService.getByIdEager(user.getId());
        model.addAttribute("user", user);
    }

    // Request mapping --------------------------------------------------------------------------------------------------------------
    @GetMapping("")
    public String renderProfilo(Principal principal, ModelMap model){
        return "modificaUser";
    }
}
