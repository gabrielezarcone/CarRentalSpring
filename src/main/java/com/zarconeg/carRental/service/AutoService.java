package com.zarconeg.carRental.service;

import com.zarconeg.carRental.domain.Auto;
import com.zarconeg.carRental.repository.AutoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("autoService")
@Transactional
public class AutoService {
    @Autowired
    AutoDao dao;

    public Auto getById(long id){
        return dao.getById(id);
    }

    public List<Auto> getList(){
        return dao.getList();
    }

    public void aggiungi(Auto auto){
        dao.aggiungi(auto);
    }

    public void elimina(Auto auto){
        dao.elimina(auto);
    }
}
