package fintech;

import fintech.model.Cliente;
import fintech.model.ContaCorrente;
import fintech.model.Transacao;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Teste da herança na classe Cliente (Pessoa -> Cliente)
        Cliente cliente1 = new Cliente(1, "João Silva", "111.222.333-44", "joao@email.com",
                "Rua das Flores, 123");
        cliente1.mostrarDadosCliente();
        
        // Teste da herança na classe Conta (Conta -> ContaCorrente)
        ContaCorrente conta1 = new ContaCorrente(1001, 3000.0, cliente1, 1000.0);
        conta1.exibirSaldo();
        conta1.depositar(500.0);
        conta1.sacar(1000.0);
        conta1.usarChequeEspecial(2000.0);
        conta1.exibirSaldo();
        
        // Teste de uma transação
        Transacao transacao1 = new Transacao(1, new Date(), 500.0, "Depósito");
        transacao1.processarTransacao();
    }
}
