package fintech.model;

public class ContaCorrente extends Conta {
    private double limite;
    
    // Construtor padrão
    public ContaCorrente() {
        super();
    }
    
    // Construtor com parâmetros
    public ContaCorrente(int numeroConta, double saldo, Cliente titular, double limite) {
        super(numeroConta, saldo, titular);
        this.limite = limite;
    }
    
    // Método para utilizar o cheque especial
    public void usarChequeEspecial(double valor) {
        if (valor <= (saldo + limite)) {
            saldo -= valor;
            System.out.println("Cheque especial utilizado: " + valor);
        } else {
            System.out.println("Limite excedido.");
        }
    }
    
    // Getters e Setters para limite
    public double getLimite() {
        return limite;
    }
    
    public void setLimite(double limite) {
        this.limite = limite;
    }
}
