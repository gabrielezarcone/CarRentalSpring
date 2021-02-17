package com.zarconeg.carRental.service;

import com.zarconeg.carRental.domain.Prenotazione;
import com.zarconeg.carRental.domain.Ruolo;
import com.zarconeg.carRental.domain.User;
import com.zarconeg.carRental.repository.UserDao;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service("userService")
@Transactional
public class UserService {
    @Autowired
    UserDao dao;
    @Autowired
    PasswordEncoder passwordEncoder;

    public User getByUsername(String username){
        return dao.getByUsername(username);
    }

    public long getIdByUsername(String username){
        return dao.getIdByUsername(username);
    }

    public User getByIdEager(long id){
        User user = dao.getById(id);
        Hibernate.initialize(user.getRuoli());
        return user;
    }

    public User getById(long id){
        return dao.getById(id);
    }

    public List<User> getList(){
        return dao.getList();
    }

    public void elimina(User user){
        dao.elimina(user);
    }

    public void disabilitaCustomer(String username) {
        dao.disabilitaCustomer(username);
    }

    public Set<Ruolo> getRuoliperUser(User user) {
        return dao.getRuoliperUser(user);
    }

    // I due metodi che seguono aggiungono o aggiornano l'utente criptando la password
    public void aggiungi(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.aggiungi(user);
    }

    public void aggiungiAggiorna(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.aggiungiAggiorna(user);
    }

    // NB da usare solo quando l'utente non ha modificato la password e quindi non c'è bisogno di criptare
    public void aggiungiAggiornaSenzaPassword(User user) {
        dao.aggiungiAggiorna(user);
    }


    //Restituisce la lista delle prenotazioni dell'utente
    public List<Prenotazione> getPrenotazioni(User user) {
        return dao.getPrenotazioni(user);
    }

}
