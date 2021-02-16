package com.zarconeg.carRental.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "auto")
public class Auto {
    //-------- campi ------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "targa", nullable = false, unique = true)
    private String targa;

    @NotNull
    @Column(name = "costruttore", nullable = false)
    private String costruttore;

    @NotNull
    @Column(name = "modello", nullable = false)
    private String modello;

    @NotNull
    @Column(name = "tipologia", nullable = false)
    private String tipologia;

    @NotNull
    @Column(name = "immatricolazione", nullable = false)
    private Date immatricolazione;

    @OneToMany(mappedBy = "auto", cascade = CascadeType.ALL)
    private Set<Prenotazione> prenotazione;


    //-------- getter e setter ------------------------------------------------------------------
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getCostruttore() {
        return costruttore;
    }

    public void setCostruttore(String costruttore) {
        this.costruttore = costruttore;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public Date getImmatricolazione() {
        return immatricolazione;
    }

    public void setImmatricolazione(Date immatricolazione) {
        this.immatricolazione = immatricolazione;
    }

    public Set<Prenotazione> getPrenotazione() {
        return prenotazione;
    }

    public void setPrenotazione(Set<Prenotazione> prenotazione) {
        this.prenotazione = prenotazione;
    }
}
