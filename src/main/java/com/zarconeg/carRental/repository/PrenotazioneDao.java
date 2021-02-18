package com.zarconeg.carRental.repository;

import com.zarconeg.carRental.domain.Auto;
import com.zarconeg.carRental.domain.Prenotazione;
import com.zarconeg.carRental.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.ParameterExpression;
import java.util.List;

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


    public List<Prenotazione> cercaStato(User user, String statoStr) {
        Prenotazione.Stato stato = Prenotazione.Stato.valueOf(statoStr);
        CriteriaContainer cc = new CriteriaContainer();
        // SELECT * FROM EntityClass
        cc.query.select(cc.root);
        // SELECT * FROM EntityClass WHERE colonnaFiltro LIKE :testoParam
        ParameterExpression<Prenotazione.Stato> statoParam = cc.builder.parameter(Prenotazione.Stato.class);
        ParameterExpression<User> userParam = cc.builder.parameter(User.class);
        cc.query.where(
                cc.builder.equal(cc.root.get("stato"), statoParam),
                cc.builder.equal(cc.root.get("user"), userParam)
        );
        // Ottengo la lista risultante dalla query
        return getSession().createQuery(cc.query)
                .setParameter(statoParam, stato)
                .setParameter(userParam, user)
                .getResultList();
    }

    public List<Prenotazione> cercaAuto(User user, Auto auto) {
        CriteriaContainer cc = new CriteriaContainer();
        // SELECT * FROM EntityClass
        cc.query.select(cc.root);
        // SELECT * FROM EntityClass WHERE colonnaFiltro LIKE :testoParam
        ParameterExpression<Auto> autoParam = cc.builder.parameter(Auto.class);
        ParameterExpression<User> userParam = cc.builder.parameter(User.class);
        cc.query.where(
                cc.builder.equal(cc.root.get("auto"), autoParam),
                cc.builder.equal(cc.root.get("user"), userParam)
        );
        // Ottengo la lista risultante dalla query
        return getSession().createQuery(cc.query)
                .setParameter(autoParam, auto)
                .setParameter(userParam, user)
                .getResultList();
    }
}
