package com.dm102.agenciaviagem.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name = "cidade")
public class City extends AbstractBaseEntity {

    @Column(name = "cidade")
    @JsonAlias("cidade")
    private String city;

    @Column(name = "idEstado")
    @JsonAlias("idEstado")
    private Long idState;

    @ManyToOne
    private State state;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getIdState() {
        return idState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
