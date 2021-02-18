package com.zarconeg.carRental.controllers.ajax;

import com.zarconeg.carRental.domain.Auto;
import com.zarconeg.carRental.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("parcoAuto/ajax/eliminaAuto/")
public class EliminaAutoAjax {

    @Autowired
    AutoService autoService;

    @GetMapping("{idAuto}")
    public String eliminaAuto(@PathVariable long idAuto, ModelMap model){
        Auto auto = autoService.getById(idAuto);
        autoService.elimina(auto);
        return "parcoAuto";
    }
}
