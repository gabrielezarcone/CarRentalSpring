package com.zarconeg.carRental.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Ruolo {
    //-------- campi ------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ruolo")
    private String ruolo;


    //-------- relazioni ------------------------------------------------------------------
    @ManyToMany
    private Set<User> users;


    //-------- getter e setter ------------------------------------------------------------------
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
