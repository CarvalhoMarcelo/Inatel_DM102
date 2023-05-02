package com.dm102.agenciaviagem.entity;


import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cliente")
public class Client extends AbstractBaseEntity{

    @Column(name = "nome")
    @JsonAlias(value = "nome")
    private String name;

    @Column(name = "sobrenome")
    @JsonAlias(value = "sobrenome")
    private String surname;

    @Column(name = "idEndereco")
    @JsonAlias("idEndereco")
    private Long idAddress;

    @Column(name = "idDocumento")
    @JsonAlias("idDocumento")
    private Long idDocument;

    @Column(name = "idContato")
    @JsonAlias("idContato")
    private Long idContact;

    @OneToOne
    @JoinColumn(name = "id")
    @JsonAlias("documento")
    private Document document;

    @OneToMany
    @Column(name = "enderecos")
    @JsonAlias("enderecos")
    private List<Address> addresses;

    @OneToOne
    @JsonAlias("contato")
    private Contact contact;

    public Client(){}

    public Client(String name, String surname, Long idAddress, Long idDocument, Long idContact) {
        this.name = name;
        this.surname = surname;
        this.idAddress = idAddress;
        this.idDocument = idDocument;
        this.idContact = idContact;
    }

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

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public Long getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Long idDocument) {
        this.idDocument = idDocument;
    }

    public Long getIdContact() {
        return idContact;
    }

    public void setIdContact(Long idContact) {
        this.idContact = idContact;
    }


    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", idAddress=" + idAddress +
                ", idDocument=" + idDocument +
                ", idContact=" + idContact +
                '}';
    }
}
