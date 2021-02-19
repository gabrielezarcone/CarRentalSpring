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
    @ManyToMany(mappedBy = "ruoli")
    private Set<User> users;


    //-------- overrides ------------------------------------------------------------------
    @Override
    public int hashCode() {
        return Long.valueOf(this.id).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof Ruolo)) {
            return false;
        }
        return this.id == ((Ruolo)obj).getId();
    }

    @Override
    public String toString() {
        return ruolo.substring(5);
    }

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
