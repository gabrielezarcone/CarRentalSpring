package com.zarconeg.carRental.domain;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "prenotazione")
public class Prenotazione implements Serializable {
    public enum Stato{
        RIFIUTATO,
        PENDING,
        APPROVATO
    }

    //-------- campi ------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "inizio", nullable = false)
    private Date inizio;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fine", nullable = false)
    private Date fine;

    @Enumerated(EnumType.STRING)
    @Column(name = "stato")
    private Stato stato = Stato.PENDING; // Una nuova prenotazione avrà di default lo stato PENDING

    @ManyToOne
    @JoinColumn(name = "auto")
    private Auto auto;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;


    //-------- getter e setter ------------------------------------------------------------------
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getInizio() {
        return inizio;
    }

    public void setInizio(Date inizio) {
        this.inizio = inizio;
    }

    public Date getFine() {
        return fine;
    }

    public void setFine(Date fine) {
        this.fine = fine;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
