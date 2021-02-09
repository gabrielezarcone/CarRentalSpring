package com.zarconeg.carRental.repository;

import com.zarconeg.carRental.domain.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserDao extends AbstractDao<Long, User>{
    public long getIdByUsername(String username){
        Query query = getSession().createSQLQuery("select id from User where username = :username");
        query.setParameter("username", username);
        return (long) query.getSingleResult();
    }
}

