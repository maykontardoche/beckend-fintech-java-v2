package fintech.model;

public class Conta {
    protected int numeroConta;
    protected double saldo;
    protected Cliente titular;
    
    // Construtor padrão
    public Conta() {
    }
    
    // Construtor com parâmetros
    public Conta(int numeroConta, double saldo, Cliente titular) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.titular = titular;
    }
    
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado: " + valor);
    }
    
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado: " + valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
    
    public void exibirSaldo() {
        System.out.println("Saldo atual: " + saldo);
    }
}
