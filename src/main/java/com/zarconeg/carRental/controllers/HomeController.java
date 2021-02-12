package com.zarconeg.carRental.controllers;

import com.zarconeg.carRental.domain.Ruolo;
import com.zarconeg.carRental.domain.User;
import com.zarconeg.carRental.repository.UserDao;
import com.zarconeg.carRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    UserDao dao;

    @RequestMapping()
    public ModelAndView renderHomePage(ModelMap model){
        return new ModelAndView("home", model);
    }

    @RequestMapping("admin/home")
    public ModelAndView adminHomePage(ModelMap model){
        List<User> userList = userService.getList();
        User user = userService.getByUsername("admin");
        Set<Ruolo> ruoliList = dao.getRuoliperUser(user);
        model.addAttribute("userList", userList);
        model.addAttribute("ruoliList", ruoliList);
        return new ModelAndView("homeAdmin", model);
    }

    @RequestMapping("customer/home")
    public ModelAndView customerHomePage(ModelMap model){
        return new ModelAndView("homeCustomer", model);
    }
}
