package com.zarconeg.carRental.repository;

import com.zarconeg.carRental.domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDao<PK extends Serializable, EntityClass> {

    private final Class<EntityClass> entityClass;

    @Autowired
    private SessionFactory sessionFactory;

    // tupla di root e query per utilizzare i criteria senza duplicare il codice
    protected class CriteriaContainer{
        public CriteriaBuilder builder;
        public CriteriaQuery<EntityClass> query;
        public Root<EntityClass> root;
        public CriteriaContainer(){
            this.builder = getSession().getCriteriaBuilder();
            this.query = builder.createQuery(entityClass);
            this.root = query.from(entityClass);
        }
    }


    //---------------------------------------------------------------------------------------------

    @SuppressWarnings("unchecked") // Il compilatore non emetterà Warning quando uso dei tipi RAW
    public AbstractDao(){
        // per prendere a compile time il generico http://download.oracle.com/javase/6/docs/api/java/lang/reflect/ParameterizedType.html#getActualTypeArguments%28%29
        this.entityClass = (Class<EntityClass>)  ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    protected  Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public EntityClass getById(PK id){
        return (EntityClass) getSession().get(entityClass, id);
    }

    public void aggiungi(EntityClass object){
        getSession().persist(object);
    }

    public void aggiungiAggiorna(EntityClass object){
        getSession().saveOrUpdate(object);
    }

    public void elimina(EntityClass object){
        getSession().remove(object);
    }

    public List<EntityClass> getList(){
        return getSession().createQuery(selectCriteria()).getResultList();
    }

    //--- CRITERIA -----------------------------------------------------
    public CriteriaQuery<EntityClass> selectCriteria(){
        CriteriaContainer cc = new CriteriaContainer();
        return cc.query.select(cc.root);
    }
}
