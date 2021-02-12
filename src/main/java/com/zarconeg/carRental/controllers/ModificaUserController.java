package com.zarconeg.carRental.controllers;

import com.zarconeg.carRental.domain.User;
import com.zarconeg.carRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ModificaUserController {

    @Autowired
    UserService userService;

    @RequestMapping("admin/modifica")
    public ModelAndView adminModificaUser(@RequestParam long userid, ModelMap model){
        User user = userService.getById(userid);
        model.addAttribute("user", user);
        return new ModelAndView("modificaUser", model);
    }
}
