package br.com.fintech.controller;

import br.com.fintech.model.dto.InvestimentoDTO;
import br.com.fintech.model.service.InvestimentoService;

import java.util.UUID;

public class InvestimentoController {
    private final InvestimentoService investimentoService;

    public InvestimentoController() {
        this.investimentoService = new InvestimentoService();
    }

    public void listarInvestimentos() {
        System.out.println(investimentoService.getAllInvestimentos());
    }
    public void listarInvestimentosPorCliente(String documentoTitular) {
        System.out.println(investimentoService.listarInvestimentoPorCliente(documentoTitular));
    }

    public void adicionarInvestimento(InvestimentoDTO investimentoDTO) {
        investimentoService.adicionarInvestimento(investimentoDTO);
    }

    public void calcularInvestimento(UUID id, int meses) {
        investimentoService.calcularInvestimento(id, meses);
    }


}
