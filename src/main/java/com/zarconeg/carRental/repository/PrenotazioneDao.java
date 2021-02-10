package com.zarconeg.carRental.repository;

import com.zarconeg.carRental.domain.Prenotazione;
import org.springframework.stereotype.Repository;

@Repository("prenotazioneDao")
public class PrenotazioneDao extends AbstractDao<Long, Prenotazione>{
}
