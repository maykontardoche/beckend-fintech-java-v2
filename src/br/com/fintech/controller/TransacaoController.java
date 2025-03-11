package br.com.fintech.controller;

import br.com.fintech.model.dto.TransacaoDTO;
import br.com.fintech.model.service.TransacaoService;
import br.com.fintech.model.entity.TransacaoEntity;

import java.util.List;
import java.util.UUID;


public class TransacaoController {
    private TransacaoService transacaoService;

    public TransacaoController() {
        this.transacaoService = new TransacaoService();
    }
    public void listarTransacoes() {
        List<TransacaoEntity> transacoes = transacaoService.listarTransacoes();
        transacoes.forEach(System.out::println);
    }

    public void registrarTransacao(TransacaoDTO transacao) {
        String mensagem = transacaoService.registrarTransacao(transacao);
        System.out.println(mensagem);
    }

    public void buscarTransacaoPorId(UUID id) {
        TransacaoEntity transacao = transacaoService.buscarTransacaoPorId(id);
        if (transacao != null) {
            System.out.println(transacao);
        } else {
            System.out.println("Transação não encontrada.");
        }
    }

    public void buscarTransacoesPorCliente(UUID clienteId) {
        List<TransacaoEntity> transacoes = transacaoService.buscarTransacoesPorCliente(clienteId);
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação encontrada para esse cliente.");
        } else {
            transacoes.forEach(System.out::println);
        }
    }
}
