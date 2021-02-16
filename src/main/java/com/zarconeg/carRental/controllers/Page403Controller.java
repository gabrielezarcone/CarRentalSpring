package com.zarconeg.carRental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class Page403Controller {
    @RequestMapping("Access_Denied")
    public ModelAndView accessDenied(ModelMap model){
        return new ModelAndView("accessDenied", model);
    }
}
