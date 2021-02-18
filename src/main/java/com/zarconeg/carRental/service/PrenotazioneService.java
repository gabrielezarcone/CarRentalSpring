package com.zarconeg.carRental.service;

import com.zarconeg.carRental.domain.Auto;
import com.zarconeg.carRental.domain.Prenotazione;
import com.zarconeg.carRental.domain.User;
import com.zarconeg.carRental.repository.PrenotazioneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    public void aggiungiModifica(Prenotazione prenotazione) {
        dao.aggiungiAggiorna(prenotazione);
    }

    // Restituisce true se dista più di due giorni da oggi ed è quindi modificabile
    public boolean isEditable(Prenotazione prenotazione){
        Date oggi = new Date();
        long diffInMillies = Math.abs(prenotazione.getInizio().getTime() - oggi.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return diff > 2;
    }

    public List<Prenotazione> cercaStato(User user, String stato) {
        return dao.cercaStato(user,stato);
    }

    public List<Prenotazione> cercaAuto(User user, Auto auto) {
        return dao.cercaAuto(user, auto);
    }
}
