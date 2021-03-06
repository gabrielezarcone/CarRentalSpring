package com.zarconeg.carRental.repository;

import com.zarconeg.carRental.domain.Prenotazione;
import com.zarconeg.carRental.domain.Ruolo;
import com.zarconeg.carRental.domain.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository("userDao")
public class UserDao extends AbstractDao<Long, User>{
    public User getByUsername(String username){
        CriteriaContainer cc = new CriteriaContainer();
        ParameterExpression<String> usernameParam = cc.builder.parameter(String.class);
        cc.query.select(cc.root)
                .where(
                        cc.builder.equal(cc.root.get("username"), usernameParam)
                );
        return getSession().createQuery(cc.query)
                .setParameter(usernameParam, username)
                .getSingleResult();
    }

    public long getIdByUsername(String username){
        User user = getByUsername(username);
        return user.getId();
    }

    public void disabilitaCustomer(String username) {
        User user = getByUsername(username);
        user.setDeleted(true);
    }

    public Set<Ruolo> getRuoliperUser(User user) {
        getSession().update(user);
        Hibernate.initialize(user.getRuoli());
        return user.getRuoli();
    }

    //Restituisce la lista delle prenotazioni dell'utente
    public List<Prenotazione> getPrenotazioni(User user) {
        getSession().update(user);
        Hibernate.initialize(user.getPrenotazione());
        Set<Prenotazione> setPrenotazioni = user.getPrenotazione();
        return new ArrayList<>(setPrenotazioni);
    }
}

