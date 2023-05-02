package com.dm102.agenciaviagem.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name = "atendente")
public class Attendant extends AbstractBaseEntity{

    @Column(name = "nome")
    @JsonAlias(value = "nome")
    private String name;

    @Column(name = "sobrenome")
    @JsonAlias(value = "sobrenome")
    private String surname;


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
}
