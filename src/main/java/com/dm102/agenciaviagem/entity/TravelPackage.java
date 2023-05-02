package com.dm102.agenciaviagem.entity;


import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name = "pacote")
public class TravelPackage extends AbstractBaseEntity{

    @Column(name = "idAtendente")
    @JsonAlias("idAtendente")
    private Long idAttendant;

    @Column(name = "idCliente")
    @JsonAlias("idCliente")
    private Long idClient;

    @Column(name = "idRoteiro")
    @JsonAlias("idRoteiro")
    private Long idItinerary;

    @Column(name = "idPgto")
    @JsonAlias("idPgto")
    private Long idPayment;

    @Column(name = "vlrPacote")
    @JsonAlias("vlrPacote")
    private Double packageValue;

    public Long getIdAttendant() {
        return idAttendant;
    }

    public void setIdAttendant(Long idAttendant) {
        this.idAttendant = idAttendant;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Long getIdItinerary() {
        return idItinerary;
    }

    public void setIdItinerary(Long idItinerary) {
        this.idItinerary = idItinerary;
    }

    public Long getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Long idPayment) {
        this.idPayment = idPayment;
    }

    public Double getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(Double packageValue) {
        this.packageValue = packageValue;
    }
}
