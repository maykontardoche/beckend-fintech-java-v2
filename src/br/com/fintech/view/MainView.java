package br.com.fintech.view;

import br.com.fintech.controller.ClienteController;
import br.com.fintech.controller.ContaController;
import br.com.fintech.controller.InvestimentoController;
import br.com.fintech.controller.TransacaoController;
import br.com.fintech.model.dto.ClienteDTO;
import br.com.fintech.model.dto.ContaDTO;
import br.com.fintech.model.dto.InvestimentoDTO;
import br.com.fintech.model.dto.TransacaoDTO;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class MainView {
    private static final ClienteController clienteController = new ClienteController();
    private static final TransacaoController transacaoController = new TransacaoController();
    private static final ContaController contaController = new ContaController();
    private static final InvestimentoController investimentoController = new InvestimentoController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Buscar Cliente por CPF");
            System.out.println("4. Cadastrar Transação");
            System.out.println("5. Listar Transações");
            System.out.println("6. Registrar conta bancária");
            System.out.println("7 Listar contas cadastradas");
            System.out.println("8. Exibir Extrato");
            System.out.println("9. Exibir Saldo");
            System.out.println("10. Registrar Investimento");
            System.out.println("11. Listar Investimentos");
            System.out.println("12. Calcular Investimento");
            System.out.println("13. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> clienteController.listarClientes();
                case 3 -> buscarClientePorCpf();
                case 4 -> cadastrarTransacao();
                case 5 -> transacaoController.listarTransacoes();
                case 6 -> registarConta();
                case 7 -> listarContasCadastradasCPF();
                case 8 -> exibirExtrato();
                case 9 -> exibirSaldo();
                case 10 -> registarInvestimento();
                case 11 -> listarInvestimentos();
                case 12 -> calcularInvestimento();
                case 13 -> {
                    System.out.println("Saindo...");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereco: ");
        String endereco = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("C.E.P: ");
        String cep = scanner.nextLine();

        ClienteDTO cliente = new ClienteDTO(nome, cpf, email, telefone, endereco, bairro, cidade, estado, cep);
        clienteController.registrarCliente(cliente);



        clienteController.registrarCliente(cliente);
    }

    private static void buscarClientePorCpf() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.next();
        clienteController.buscarClientePorCpf(cpf);
    }

    private static void cadastrarTransacao() {
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();


        System.out.print("Valor da transação: ");
        BigDecimal valor = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.print("Data (AAAA-MM-DD): ");
        Date data = Date.valueOf(scanner.nextLine());
        System.out.print("Tipo (crédito/débito): ");
        String tipo = scanner.nextLine();

        TransacaoDTO transacao = new TransacaoDTO(valor,data, cpf, tipo );

        transacaoController.registrarTransacao(transacao);
    }

    private static void registarConta() {
        System.out.print("Nome Titular da Conta: ");
        String titular = scanner.nextLine();
        System.out.print("Codigo Instituição Bancaria: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome Instituição: ");
        String email = scanner.nextLine();
        System.out.print("Numero Agencia: ");
        String telefone = scanner.nextLine();
        System.out.print("Conta: ");
        String numero = scanner.nextLine();
        System.out.println("Saldo Atual da Conta: ");
        BigDecimal saldo = scanner.nextBigDecimal();

        ContaDTO contaDTO = new ContaDTO(titular,cpf,email,telefone,numero,saldo);

        contaController.registrarConta(contaDTO);

    }
    private static void listarContasCadastradasCPF() {
            contaController.listarContas();
    }

    private static void exibirSaldo (){
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.next();
        contaController.exibirSaldo(cpf);
    }

    private static void exibirExtrato() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.next();
        contaController.consultarExtrato(cpf);
    }

    private static void registarInvestimento() {
        System.out.print("Digite o CPF do titular: ");
        String documentoTitular = scanner.nextLine();

        System.out.print("Valor do Investimento: ");
        BigDecimal valor = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.print("Rendimento Mensal: ");
        BigDecimal rendimento = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.print("Data do Investimento (AAAA-MM-DD): ");
        Date dataInicio = Date.valueOf(scanner.nextLine());


        InvestimentoDTO investimentoDTO = new InvestimentoDTO(documentoTitular, valor, rendimento,
                Optional.empty(),Optional.empty() ,dataInicio);
        investimentoController.adicionarInvestimento(investimentoDTO);
    }
    private static void listarInvestimentos() {
        investimentoController.listarInvestimentos();
    }

 private static void calcularInvestimento() {
    System.out.println("Digite o ID do investimento: ");
    UUID id = UUID.fromString(scanner.nextLine());
    System.out.println("Digite a quantidade de meses: ");
    int meses = scanner.nextInt();

    investimentoController.calcularInvestimento(id, meses);
   }
}
