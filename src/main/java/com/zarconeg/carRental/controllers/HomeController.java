package com.zarconeg.carRental.controllers;

import com.zarconeg.carRental.domain.User;
import com.zarconeg.carRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    @Autowired
    UserService userService;

    @RequestMapping()
    public ModelAndView renderHomePage(ModelMap model){
        return new ModelAndView("home", model);
    }
}
