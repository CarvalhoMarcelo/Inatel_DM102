package com.dm102.agenciaviagem.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name = "documento")
public class Document extends AbstractBaseEntity{

    @Column
    private String rg;

    @Column
    private Integer cpf;

    @Column(name = "passaporte")
    @JsonAlias(value = "passaporte")
    private String passaport;

    @Column(name = "idCliente")
    @JsonAlias("idCliente")
    private Long idClient;

    @OneToOne
    @JoinColumn(name = "id")
    private Client client;

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getPassaport() {
        return passaport;
    }

    public void setPassaport(String passaport) {
        this.passaport = passaport;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
