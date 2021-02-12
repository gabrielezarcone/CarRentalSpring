package com.zarconeg.carRental.service;

import com.zarconeg.carRental.domain.Ruolo;
import com.zarconeg.carRental.domain.User;
import com.zarconeg.carRental.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service("userService")
@Transactional
public class UserService {
    @Autowired
    UserDao dao;

    public User getByUsername(String username){
        return dao.getByUsername(username);
    }

    public long getIdByUsername(String username){
        return dao.getIdByUsername(username);
    }

    public User getById(long id){
        return dao.getById(id);
    }

    public List<User> getList(){
        return dao.getList();
    }

    public void aggiungi(User user){
        dao.aggiungi(user);
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
}
