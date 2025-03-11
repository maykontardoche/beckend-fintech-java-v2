package br.com.fintech.model.service;

import br.com.fintech.model.dto.ClienteDTO;
import br.com.fintech.model.entity.ClienteEntity;
import br.com.fintech.model.entity.EnderecoEntity;
import br.com.fintech.model.repository.ClienteRepository;

import java.util.List;

public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService() {
        this.clienteRepository = ClienteRepository.getInstance();
    }

    public List<ClienteEntity> listarClientes() {
        return clienteRepository.findAll();
    }

public String registrarCliente(ClienteDTO clienteDTO) {
    if (clienteRepository.findByCpf(clienteDTO.documento()).isPresent()) {
        return "Cliente já cadastrado com esse CPF!";
    }

    EnderecoEntity enderecoEntity = new EnderecoEntity(
            clienteDTO.endereco(),
            clienteDTO.bairro(),
            clienteDTO.cidade(),
            clienteDTO.estado(),
            clienteDTO.cep()
    );


    ClienteEntity clienteEntity = new ClienteEntity(
            clienteDTO.nome(),
            clienteDTO.documento(),
            clienteDTO.email(),
            clienteDTO.telefone(),
            enderecoEntity

    );

    clienteRepository.save(clienteEntity);
    return "Cliente cadastrado com sucesso!";
}

    public String atualizarCliente(ClienteEntity cliente) {
        if (clienteRepository.findByCpf(cliente.getDocumento()).isEmpty()) {
            return "Cliente não encontrado!";
        }
        clienteRepository.update(cliente);
        return "Cliente atualizado com sucesso!";
    }

    public String removerCliente(String cpf) {
        if (clienteRepository.findByCpf(cpf).isEmpty()) {
            return "Cliente não encontrado!";
        }
        clienteRepository.deleteByCpf(cpf);
        return "Cliente removido com sucesso!";
    }

    public ClienteEntity buscarClienteCPF(String cpf) {
        return clienteRepository.findByCpf(cpf).orElse(null);
    }
}
