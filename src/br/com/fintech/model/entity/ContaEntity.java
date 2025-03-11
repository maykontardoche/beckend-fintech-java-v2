package br.com.fintech.model.entity;

import java.math.BigDecimal;

public class ContaEntity extends BancoEntity{
    private String titular;
    private String agencia;
    private String conta;
    private boolean poupanca;
    private BigDecimal saldo;


    public ContaEntity(String instituicao, String codigo,String titular, String agencia, String conta, boolean poupanca, BigDecimal saldo){
        super(instituicao,codigo);
        this.titular = titular;
        this.agencia = agencia;
        this.conta = conta;
        this.poupanca = poupanca;
        this.saldo = saldo;
    }


    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public boolean isPoupanca() {
        return poupanca;
    }

    public void setPoupanca(boolean poupanca) {
        this.poupanca = poupanca;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return String.format(
                "Titular: %s |Banco: %s | codigo: %s  | Agência: %s | Conta: %s | %s | Saldo: %s",
                this.titular,
                this.instituicao,
                this.codigo,
                this.agencia,
                this.conta,
                (this.poupanca) ? "Conta Poupança" : "Conta Corrente",
                this.saldo
        );
    }
}
