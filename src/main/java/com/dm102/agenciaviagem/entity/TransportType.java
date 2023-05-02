package com.dm102.agenciaviagem.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name = "transporte")
public class TransportType extends AbstractBaseEntity {
    @Column(name = "tipo")
    @JsonAlias(value = "tipo")
    private String type;

    @Column(name = "classe")
    @JsonAlias(value = "classe")
    private String classType;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }
}
