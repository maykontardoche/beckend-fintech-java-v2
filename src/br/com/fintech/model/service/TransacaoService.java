package br.com.fintech.model.service;

import br.com.fintech.model.dto.TransacaoDTO;
import br.com.fintech.model.entity.TransacaoEntity;
import br.com.fintech.model.repository.ClienteRepository;
import br.com.fintech.model.repository.TransacaoRepository;

import br.com.fintech.model.entity.ClienteEntity;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final ClienteRepository clienteRepository;

    public TransacaoService() {
        this.transacaoRepository = TransacaoRepository.getInstance();
        this.clienteRepository = ClienteRepository.getInstance();
    }

    public List<TransacaoEntity> listarTransacoes() {
        return transacaoRepository.listarTransacoes();
    }

    public String registrarTransacao(TransacaoDTO transacao) {
        Optional<ClienteEntity> clienteOpt = clienteRepository.findByCpf(transacao.cpf());
        System.out.println(clienteOpt);
        if (clienteOpt.isEmpty()) {
            return "Cliente não encontrado na base de dados";
        }

        TransacaoEntity transacaoEntity = toTransacaoEntity(transacao, clienteOpt.get());
        transacaoRepository.adicionarTransacao(transacaoEntity);
        return "Transação registrada com sucesso!";
    }

    public TransacaoEntity buscarTransacaoPorId(UUID id) {
        return transacaoRepository.buscarPorId(id);
    }

    public List<TransacaoEntity> buscarTransacoesPorCliente(UUID clienteId) {
        return transacaoRepository.buscarPorCliente(clienteId);
    }

    private TransacaoEntity toTransacaoEntity(TransacaoDTO transacaoDTO, ClienteEntity clienteEntity) {
        TransacaoEntity transacaoEntity = new TransacaoEntity();
        transacaoEntity.setValor(transacaoDTO.valor());
        transacaoEntity.setData(transacaoDTO.data());
        transacaoEntity.setTipo(transacaoDTO.tipo());
        transacaoEntity.setCliente(clienteEntity);
        return transacaoEntity;
    }
}