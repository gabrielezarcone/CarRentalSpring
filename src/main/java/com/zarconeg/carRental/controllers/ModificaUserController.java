package com.zarconeg.carRental.controllers;

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

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class ModificaUserController {

    @Autowired
    UserService userService;
    @Autowired
    RuoloService ruoloService;


// Request Mappings------------------------------------------------------------------------------------------------------------------
    @RequestMapping("admin/modifica")
    public String adminModificaUser(@RequestParam long userid, ModelMap model){
        User user = userService.getByIdEager(userid);
        model.addAttribute("user", user);
        roleListModel(model);
        return "modificaUser";
    }

    @PostMapping("admin/modifica")
    public String actionAdminModificaUser(@Valid User user, BindingResult result, ModelMap model){
        if(result.hasErrors()) {
            roleListModel(model);
            return "modificaUser";
        }
        userService.aggiungiAggiorna(user);
        return "home";
    }


//------------------------------------------------------------------------------------------------------------------
    private void roleListModel(ModelMap model) {
        List<String> roleNameList = ruoloService.getNameList();
        model.addAttribute("roleList", roleNameList);
    }

}
