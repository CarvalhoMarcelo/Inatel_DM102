package com.dm102.agenciaviagem.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name = "pagamento")
public class PaymentType extends AbstractBaseEntity{

    @Column(name = "descricao")
    @JsonAlias(value = "descricao")
    private String description;

    @Column(name = "parcelas")
    @JsonAlias(value = "parcelas")
    private Integer installments;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }
}
