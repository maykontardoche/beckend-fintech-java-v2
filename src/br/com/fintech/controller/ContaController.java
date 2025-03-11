package br.com.fintech.controller;

import br.com.fintech.model.dto.ContaDTO;
import br.com.fintech.model.service.ContaService;


public class ContaController {
    private final ContaService contaService;

    public ContaController() {
        this.contaService = new ContaService();
    }

    public void listarContas (){
        System.out.println(contaService.listarContas());
    }

    public void consultarExtrato(String cpf){
        contaService.exibirExtrato(cpf);
    }
    public void exibirSaldo(String cpf){
        System.out.println(contaService.saldoConta(cpf));
    }

    public void registrarConta(ContaDTO contaDTO) {
        String mensagem =  contaService.incluirConta(contaDTO);
        System.out.println(mensagem);
    }
}
