package com.dm102.agenciaviagem.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name = "pais")
public class Country extends AbstractBaseEntity{

    @Column(name = "pais")
    @JsonAlias(value = "pais")
    private String country;

    @Column(name = "continente")
    @JsonAlias(value = "continente")
    private String continent;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

}
