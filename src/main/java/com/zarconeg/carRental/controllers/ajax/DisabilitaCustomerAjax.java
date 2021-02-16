package com.zarconeg.carRental.controllers.ajax;

import com.zarconeg.carRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/ajax/")
public class DisabilitaCustomerAjax {
    @Autowired
    UserService userService;

    @GetMapping("disabilitaCustomer")
    public ModelAndView disabilitaCustomer(@RequestParam String username, ModelMap model){
        userService.disabilitaCustomer(username);
        return new ModelAndView("homeAdmin", model);
    }
}
