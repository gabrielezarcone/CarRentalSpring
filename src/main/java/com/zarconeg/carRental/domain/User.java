package com.zarconeg.carRental.domain;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    //-------- campi ------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @UniqueElements
    @NotNull
    @Column(name="username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name="password", nullable = false)
    private String password;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="birthDate")
    private Date birthDate;

    @Column(name="deleted")
    private boolean deleted;


    //-------- relazioni ------------------------------------------------------------------
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Prenotazione> prenotazione;

   @ManyToMany
   private Set<Ruolo> ruoli;


    //-------- getter e setter ------------------------------------------------------------------
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Set<Prenotazione> getPrenotazione() {
        return prenotazione;
    }

    public void setPrenotazione(Set<Prenotazione> prenotazione) {
        this.prenotazione = prenotazione;
    }

    public Set<Ruolo> getRuoli() {
        return ruoli;
    }

    public void setRuoli(Set<Ruolo> ruoli) {
        this.ruoli = ruoli;
    }
}
