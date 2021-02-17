package com.zarconeg.carRental.repository;

import com.zarconeg.carRental.domain.Prenotazione;
import org.springframework.stereotype.Repository;

@Repository("prenotazioneDao")
public class PrenotazioneDao extends AbstractDao<Long, Prenotazione>{

    public void updateStato(Prenotazione prenotazione, Prenotazione.Stato stato){
        prenotazione.setStato(stato);
        getSession().update(prenotazione);
    }

    public void updateStatoAsString(Prenotazione prenotazione, String statoString){
        Prenotazione.Stato enumStato = Prenotazione.Stato.valueOf(statoString);
        updateStato(prenotazione, enumStato);
    }
}
