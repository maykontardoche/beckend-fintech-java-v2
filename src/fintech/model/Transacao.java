package fintech.model;

import java.util.Date;

public class Transacao {
    private int idTransacao;
    private Date dataTransacao;
    private double valor;
    private String tipo; // Exemplo: "Depósito", "Saque", "Transferência"
    
    // Construtor padrão
    public Transacao() {
    }
    
    // Construtor com parâmetros
    public Transacao(int idTransacao, Date dataTransacao, double valor, String tipo) {
        this.idTransacao = idTransacao;
        this.dataTransacao = dataTransacao;
        this.valor = valor;
        this.tipo = tipo;
    }
    
    public void processarTransacao() {
        System.out.println("Processando transação: " + tipo + " no valor: " + valor);
    }
}
