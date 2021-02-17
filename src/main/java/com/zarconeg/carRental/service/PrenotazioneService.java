package com.zarconeg.carRental.service;

import com.zarconeg.carRental.domain.Prenotazione;
import com.zarconeg.carRental.repository.PrenotazioneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("prenotazioneService")
@Transactional
public class PrenotazioneService{
    @Autowired
    PrenotazioneDao dao;
    
    public Prenotazione getById(long id){
        return dao.getById(id);
    }

    public List<Prenotazione> getList(){
        return dao.getList();
    }

    public void aggiungi(Prenotazione prenotazione){
        dao.aggiungi(prenotazione);
    }

    public void elimina(Prenotazione prenotazione){
        dao.elimina(prenotazione);
    }

    public void updateStato(Prenotazione prenotazione, Prenotazione.Stato stato){
        dao.updateStato(prenotazione,stato);
    }

    public void updateStatoAsString(Prenotazione prenotazione, String statoString){
        dao.updateStatoAsString(prenotazione, statoString);
    }
}
