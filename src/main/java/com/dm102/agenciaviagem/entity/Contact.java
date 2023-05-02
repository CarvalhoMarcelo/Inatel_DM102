package com.dm102.agenciaviagem.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name = "contato")
public class Contact extends AbstractBaseEntity{

    private String email;

    @Column(name = "celular")
    @JsonAlias("celular")
    private Long cellPhone;

    @Column(name = "telefoneFixo")
    @JsonAlias("telefoneFixo")
    private Long landLine;

    @Column(name = "idCliente")
    @JsonAlias("idCliente")
    private Long idClient;

    @OneToOne
    @JsonAlias("cliente")
    private Client client;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(Long cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Long getLandLine() {
        return landLine;
    }

    public void setLandLine(Long landLine) {
        this.landLine = landLine;
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
