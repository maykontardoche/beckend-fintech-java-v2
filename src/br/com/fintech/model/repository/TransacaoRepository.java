package br.com.fintech.model.repository;

import br.com.fintech.model.entity.TransacaoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TransacaoRepository {
    private static TransacaoRepository instance;
    private final List<TransacaoEntity> transacoes;

    public TransacaoRepository() {
        this.transacoes = new ArrayList<TransacaoEntity>();
    }
    public static TransacaoRepository getInstance() {
        if(instance == null) {
            instance = new TransacaoRepository();
        }
        return instance;
    }
    public List<TransacaoEntity> listarTransacoes() {
        return new ArrayList<>(transacoes);
    }

    public void adicionarTransacao(TransacaoEntity transacao) {
            transacoes.add(transacao);
    }


    public TransacaoEntity buscarPorId(UUID id) {
        return transacoes.stream()
                .filter(transacao -> transacao.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<TransacaoEntity> buscarPorCliente(UUID clienteId) {
        return transacoes.stream()
                .filter(transacao -> transacao.getCliente().getId().equals(clienteId))
                .collect(Collectors.toList());
    }
    public List<TransacaoEntity> buscarPorConta(String documento) {
            return transacoes.stream().filter(transacao -> transacao.getCliente().getDocumento().equals(documento)).collect(Collectors.toList());
    }
}
