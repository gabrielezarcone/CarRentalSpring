package com.zarconeg.carRental.service;

import com.zarconeg.carRental.domain.Ruolo;
import com.zarconeg.carRental.repository.RuoloDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("ruoloService")
@Transactional
public class RuoloService {

    @Autowired
    RuoloDao dao;

    public Ruolo getById(long id){
        return dao.getById(id);
    }

    public List<Ruolo> getList(){
        return dao.getList();
    }

    public void aggiungi(Ruolo ruolo){
        dao.aggiungi(ruolo);
    }

    public void elimina(Ruolo ruolo){
        dao.elimina(ruolo);
    }

    public List<String> getNameList(){
        List<Ruolo> roleList = getList();
        return roleList.stream().map(
                ruolo -> {
                    return ruolo.getRuolo().substring(5); // per togliere ROLE_ davanti al nome del ruolo
                }).collect(Collectors.toList());
    }

}
