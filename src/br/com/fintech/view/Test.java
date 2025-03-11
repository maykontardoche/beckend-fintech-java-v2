package br.com.fintech.view;


import br.com.fintech.controller.ClienteController;
import br.com.fintech.controller.ContaController;
import br.com.fintech.controller.InvestimentoController;
import br.com.fintech.controller.TransacaoController;
import br.com.fintech.model.dto.ClienteDTO;
import br.com.fintech.model.dto.ContaDTO;
import br.com.fintech.model.dto.InvestimentoDTO;
import br.com.fintech.model.dto.TransacaoDTO;
import br.com.fintech.model.repository.InvestimentoRepository;


import java.math.BigDecimal;
import java.sql.Date;

public class Test {
    private static final ClienteController clienteController = new ClienteController();
    private static final ContaController contaController = new ContaController();
    private static final  TransacaoController transacaoController = new TransacaoController();
    private static final InvestimentoController investimentoController = new InvestimentoController();



    public static void main(String[] args) {

            ClienteDTO cliente = new ClienteDTO("João da Silva", "12345678900",
                    "joao@gmail.com", "139919100101","rua marajo 31", "santa luzia",
                    "São Paulo", "SP","11400-001");

            clienteController.registrarCliente(cliente);

        ContaDTO contaDTO = new ContaDTO("12345678900", "001", "João da Silva",
                "12345678900", "1234", BigDecimal.valueOf(1000.00));

        contaController.registrarConta(contaDTO);

        TransacaoDTO transacaoDTO = new TransacaoDTO( BigDecimal.valueOf(1500.00), Date.valueOf("2025-10-01"),
              "12345678900", "debito");

       transacaoController.registrarTransacao(transacaoDTO);

        contaController.exibirSaldo("12345678900");


        TransacaoDTO transacaoDTO2 = new TransacaoDTO( BigDecimal.valueOf(1500.00), Date.valueOf("2025-10-01"),
                "12345678900", "credito");

        transacaoController.registrarTransacao(transacaoDTO2);

        contaController.consultarExtrato("12345678900");

        contaController.exibirSaldo("12345678900");

        InvestimentoDTO investimentoDTO = new InvestimentoDTO("12345678900", BigDecimal.valueOf(1000.00),
                BigDecimal.valueOf(1.0), null, null, Date.valueOf("2025-10-01"));

        investimentoController.adicionarInvestimento(investimentoDTO);

        investimentoController.calcularInvestimento(InvestimentoRepository.getInstance().findAll().get(0).getId(),
                12);
    }
}

