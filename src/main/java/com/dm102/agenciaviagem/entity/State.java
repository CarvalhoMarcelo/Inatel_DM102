package com.dm102.agenciaviagem.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name = "estado")
public class State extends AbstractBaseEntity{

    @Column(name = "estado")
    @JsonAlias("estado")
    private String state;

    @Column(name = "idPais")
    @JsonAlias("idPais")
    private Long idCountry;

    @ManyToOne
    @JsonAlias("pais")
    private Country country;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
