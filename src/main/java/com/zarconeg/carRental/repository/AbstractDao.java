package com.zarconeg.carRental.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
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

    // Uso criteria per rendere dinamica la colonna su cui fare il Like e poter cercare dentro ad una tabella con diversi filtri
    public List<EntityClass> cerca(String testoRicerca, String colonnaFiltro){
        CriteriaContainer cc = new CriteriaContainer();
        // SELECT * FROM EntityClass
        cc.query.select(cc.root);
        // SELECT * FROM EntityClass WHERE colonnaFiltro LIKE :testoParam
        ParameterExpression<String> testoParam = cc.builder.parameter(String.class);
        cc.query.where(
                cc.builder.like(cc.root.get(colonnaFiltro), testoParam)
        );
        // Ottengo la lista risultante dalla query
        return getSession().createQuery(cc.query)
                .setParameter(testoParam, "%"+testoRicerca+"%")  // :testoParam -> "%testoRicerca%"
                .getResultList();
    }
}
