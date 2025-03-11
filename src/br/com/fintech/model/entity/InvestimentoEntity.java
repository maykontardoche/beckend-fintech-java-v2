package br.com.fintech.model.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class InvestimentoEntity {
    private final UUID id = UUID.randomUUID();
    private String documentoTitular;
    private BigDecimal valor;
    private BigDecimal rendimento; // Taxa de rendimento mensal em porcentagem
    private int meses; // Duração do investimento em meses
    private BigDecimal valorFinal = BigDecimal.ZERO;
    private Date dataInicio;

    public InvestimentoEntity(String documentoTitular, BigDecimal valor, BigDecimal rendimento, Date dataInicio) {
        this.documentoTitular = documentoTitular;
        this.valor = valor;
        this.rendimento = rendimento;
        this.meses = meses;
        this.dataInicio = dataInicio;
    }

    public UUID getId() {
        return id;
    }


    public String getDocumentoTitular() {
        return documentoTitular;
    }

    public void setDocumentoTitular(String documentoTitular) {
        this.documentoTitular = documentoTitular;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getRendimento() {
        return rendimento;
    }

    public void setRendimento(BigDecimal rendimento) {
        this.rendimento = rendimento;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public String toString() {
        return String.format("InvestimentoEntity{id='%s', documentoTitular='%s', " +
                        "valor=%s, rendimento=%s, meses=%d, valorFinal=%s, dataInicio=%s}",
                id, documentoTitular, valor, rendimento, meses, valorFinal, dataInicio);
    }

}