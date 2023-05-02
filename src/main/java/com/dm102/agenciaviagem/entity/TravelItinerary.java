package com.dm102.agenciaviagem.entity;


import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roteiro")
public class TravelItinerary extends AbstractBaseEntity{

    @Column(name = "idTransporte")
    @JsonAlias("idTransporte")
    private Long idTransport;

    @Column(name = "idPais")
    @JsonAlias("idPais")
    private Long idCountry;

    @Column(name = "idEstado")
    @JsonAlias("idEstado")
    private Long idState;

    @Column(name = "idCidade")
    @JsonAlias("idCidade")
    private Long idCity;

    public Long getIdTransport() {
        return idTransport;
    }

    public void setIdTransport(Long idTransport) {
        this.idTransport = idTransport;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }

    public Long getIdState() {
        return idState;
    }

    public void setIdState(Long idState) {
        this.idState = idState;
    }

    public Long getIdCity() {
        return idCity;
    }

    public void setIdCity(Long idCity) {
        this.idCity = idCity;
    }

}
