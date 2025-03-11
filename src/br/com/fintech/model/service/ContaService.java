package br.com.fintech.model.service;

import br.com.fintech.model.dto.ContaDTO;
import br.com.fintech.model.repository.ClienteRepository;
import br.com.fintech.model.repository.ContaRepository;
import br.com.fintech.model.repository.TransacaoRepository;
import br.com.fintech.model.entity.ContaEntity;
import br.com.fintech.model.entity.TransacaoEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ContaService {
    private final ContaRepository contaRepository;
    private  final TransacaoRepository transacaoRepository;
    private final ClienteRepository clienteRepository;

    public ContaService() {
        this.contaRepository = ContaRepository.getInstance();
        this.transacaoRepository = TransacaoRepository.getInstance();
        this.clienteRepository = ClienteRepository.getInstance();
    }

    public List<ContaEntity> listarContas() {
        return contaRepository.findAll();
    }

   public String saldoConta(String cpf) {
        var conta = contaRepository.findByTitular(cpf);
        List<TransacaoEntity> transacoes = transacaoRepository.buscarPorConta(cpf);
        BigDecimal saldoInicial = conta.getSaldo();
        var saldoFinal = saldoInicial.add(calcularSaldo(transacoes));
        return String.format("Saldo da conta: %s", saldoFinal.compareTo(BigDecimal.ZERO) < 0 ?
                saldoFinal + "  **Você está usando limite do cheque especial** " : saldoFinal);
    }

    public String incluirConta(ContaDTO contaDTO) {
        var cliente = clienteRepository.findByCpf(contaDTO.titular());
        if(cliente.isEmpty()){
            return "Cliente não encontrado na base de dados, por favor," +
                    " cadastre o cliente antes de registrar a conta.";
        }
        ContaEntity novaConta = new ContaEntity(
                contaDTO.codigo(),
                contaDTO.instituicao(),
                contaDTO.titular(),
                contaDTO.agencia(),
                contaDTO.conta(),
                false,
                contaDTO.saldo()
        );
        contaRepository.save(novaConta);

        return "Conta registrada com sucesso!";
    }

    public void exibirExtrato(String cpf) {
        var conta = contaRepository.findByTitular(cpf);
        if (conta == null) {
            System.out.println("Conta não encontrada para o CPF informado.");
        }
        List<TransacaoEntity> transacoes = transacaoRepository.buscarPorConta(cpf);
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação encontrada para esta conta.");
        } else {
            System.out.println("Extrato da conta: ");
            transacoes.forEach(System.out::println);
        }
    }


    private BigDecimal calcularSaldo(List<TransacaoEntity> transacoes) {
        return transacoes.stream()
                .map(transacao -> {
                    boolean isCredito = Objects.equals(transacao.getTipo(), "credito");
                    BigDecimal valor = transacao.getValor();
                    return isCredito ? valor : valor.negate();
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}