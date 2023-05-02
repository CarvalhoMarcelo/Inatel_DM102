package com.dm102.agenciaviagem.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Address extends AbstractBaseEntity{

    @Column(name = "tipoLogradouro")
    @JsonAlias("tipoLogradouro")
    private String typeOfStreet;

    @Column(name = "endereco")
    @JsonAlias(value = "endereco")
    private String address;

    @Column(name = "numero")
    @JsonAlias("numero")
    private String number;

    @Column(name = "cep")
    @JsonAlias("cep")
    private String postalCode;

    @Column(name = "idCidade")
    @JsonAlias("idCidade")
    private Long idCity;

    @Column(name = "idEstado")
    @JsonAlias("idEstado")
    private Long idState;

    @Column(name = "idPais")
    @JsonAlias("idPais")
    private Long idCountry;

    @OneToOne
    @JsonAlias("pais")
    private Country country;

    @OneToOne
    @JsonAlias("estado")
    private State state;

    @OneToOne
    @JsonAlias("cidade")
    private City city;

    @ManyToOne
    private Client client;

    public String getTypeOfStreet() {
        return typeOfStreet;
    }

    public void setTypeOfStreet(String typeOfStreet) {
        this.typeOfStreet = typeOfStreet;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Long getIdCity() {
        return idCity;
    }

    public void setIdCity(Long idCity) {
        this.idCity = idCity;
    }

    public Long getIdState() {
        return idState;
    }

    public void setIdState(Long idState) {
        this.idState = idState;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
