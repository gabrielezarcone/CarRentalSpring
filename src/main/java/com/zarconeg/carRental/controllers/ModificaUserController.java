package com.zarconeg.carRental.controllers;

import com.zarconeg.carRental.domain.Ruolo;
import com.zarconeg.carRental.domain.User;
import com.zarconeg.carRental.service.RuoloService;
import com.zarconeg.carRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/")
public class ModificaUserController {

    @Autowired
    UserService userService;
    @Autowired
    RuoloService ruoloService;


// Request Mappings------------------------------------------------------------------------------------------------------------------
    @GetMapping ("admin/modifica")
    public String adminModificaUser(@RequestParam long userid, ModelMap model){
        User user = userService.getByIdEager(userid);
        model.addAttribute("user", user);
        roleListModel(model);
        return "modificaUser";
    }


    @GetMapping("admin/aggiungi")
    public String adminAggiungiUser(ModelMap model){
        User user = new User();
        roleListModel(model);
        model.addAttribute("user", user);
        return "modificaUser";
    }

    @PostMapping(value = {
            "admin/modifica",
            "admin/aggiungi",
            "profilo",
            "admin/modifica/{conPsw}", // Aggiungo una PathVariable opzionale. Devo comunque mappare tutti i path (sia con che senza)
            "admin/aggiungi/{conPsw}",
            "profilo/{conPsw}"
    })
    public String actionAdminModificaUser(@Valid User user, BindingResult result, @PathVariable Optional<Boolean> conPsw, ModelMap model){
        if(result.hasErrors()) {
            roleListModel(model);
            return "modificaUser";
        }
        if(conPsw.isPresent() && conPsw.get()){
            userService.aggiungiAggiorna(user);
        }
        else {
            userService.aggiungiAggiornaSenzaPassword(user);
        }
        return "redirect:/";
    }

//--InitBinder----------------------------------------------------------------------------------------------------------------
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Trasformo le stringhe ricevute dal campo ruoli in elementi del Set<Ruolo> quando ricevo i dati dal form prima che vengano elaborati dal controller
        binder.registerCustomEditor(Set.class, "ruoli", new CustomCollectionEditor(Set.class){
            @Override
            protected Object convertElement(Object element) {
                long id = Long.parseLong((String) element);
                return ruoloService.getById(id);
            }
        });
    }

//------------------------------------------------------------------------------------------------------------------
    private void roleListModel(ModelMap model) {
        List<Ruolo> roleList = ruoloService.getList();
        model.addAttribute("roleList", roleList);
    }

}
