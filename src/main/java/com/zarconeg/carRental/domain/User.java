package com.zarconeg.carRental.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {
    //-------- campi ------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min=2)
    @Column(name="username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Size(min=8)
    @Column(name="password", nullable = false)
    private String password;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @Column(name="birthDate")
    private Date birthDate;

    @Column(name="deleted")
    private boolean deleted;


    //-------- relazioni ------------------------------------------------------------------
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Prenotazione> prenotazione;

   @ManyToMany
   @JoinTable(
           name = "user_ruoli",
           joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "ruolo_id")
   )
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
