package br.com.fintech.model.service;


import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import br.com.fintech.model.dto.InvestimentoDTO;
import br.com.fintech.model.entity.InvestimentoEntity;
import br.com.fintech.model.repository.ClienteRepository;
import br.com.fintech.model.repository.InvestimentoRepository;


public class InvestimentoService {
    private final InvestimentoRepository investimentoRepository;
    private final ClienteRepository clienteRepository;
    public InvestimentoService() {
        this.investimentoRepository = InvestimentoRepository.getInstance();
        this.clienteRepository = ClienteRepository.getInstance();
    }

    public List<InvestimentoEntity> getAllInvestimentos() {
        return investimentoRepository.findAll();
    }
public void adicionarInvestimento(InvestimentoDTO investimentoDTO) {
    var cliente = clienteRepository.findByCpf(investimentoDTO.documentoTitular());
    if (cliente.isEmpty()) {
        System.out.println("Cliente não encontrado na base de dados, por favor," +
                " cadastre o cliente antes de registrar o investimento.");
        return;
    }

    InvestimentoEntity investimentoEntity = new InvestimentoEntity(
    investimentoDTO.documentoTitular(),
    investimentoDTO.valor(),
    investimentoDTO.rendimento(),
    investimentoDTO.dataInicio()
    );

    investimentoRepository.save(investimentoEntity);
    System.out.println("Investimento adicionado com sucesso!");
}
    public List<InvestimentoEntity> listarInvestimentoPorCliente(String titular) {
        return investimentoRepository.findByTitular(titular);
    }
public void calcularInvestimento(UUID id, int meses) {
    System.out.println("recebendo na service investimento" + id);
    InvestimentoEntity investimento = investimentoRepository.findAll().stream()
            .filter(inv -> inv.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Investimento não encontrado"));

    BigDecimal taxaMensal = investimento.getRendimento().divide(BigDecimal.valueOf(100));
    BigDecimal valorInicial = investimento.getValor();

    BigDecimal valorFinal = valorInicial;
    for (int i = 0; i < meses; i++) {
        BigDecimal ganhoMensal = valorFinal.multiply(taxaMensal);
        valorFinal = valorFinal.add(ganhoMensal);
       System.out.println(String.format("Mês %d: Ganho = %.2f", (i + 1), ganhoMensal));
    }

    investimento.setValorFinal(valorFinal);
    System.out.printf("Valor final do investimento: %.2f no período de %s meses" , valorFinal, meses);
}
}