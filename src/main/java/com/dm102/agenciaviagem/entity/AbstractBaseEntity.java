package com.dm102.agenciaviagem.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class AbstractBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}