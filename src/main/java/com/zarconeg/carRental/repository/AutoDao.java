package com.zarconeg.carRental.repository;

import com.zarconeg.carRental.domain.Auto;
import com.zarconeg.carRental.domain.Prenotazione;
import com.zarconeg.carRental.domain.User;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository("autoDao")
public class AutoDao extends AbstractDao<Long, Auto>{

    //Restituisce la lista delle prenotazioni dell'utente
    public List<Prenotazione> getPrenotazioni(Auto auto) {
        getSession().update(auto);
        Hibernate.initialize(auto.getPrenotazione());
        Set<Prenotazione> setPrenotazioni = auto.getPrenotazione();
        return new ArrayList<>(setPrenotazioni);
    }
}
