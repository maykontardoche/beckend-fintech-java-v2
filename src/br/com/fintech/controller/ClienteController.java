package br.com.fintech.controller;

import br.com.fintech.model.dto.ClienteDTO;
import br.com.fintech.model.entity.ClienteEntity;
import br.com.fintech.model.service.ClienteService;

import java.util.List;

public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController() {
        this.clienteService = new ClienteService();
    }

    public void listarClientes() {
        List<ClienteEntity> clientes = clienteService.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            clientes.forEach(System.out::println);
        }
    }

    public void registrarCliente(ClienteDTO clienteDTO) {
        if (clienteDTO == null) {
            return;
        }
        String mensagem = clienteService.registrarCliente(clienteDTO);
        System.out.println(mensagem);
    }

    public void removerCliente(ClienteEntity cliente) {
        var clienteDocumento = cliente.getDocumento();
        String mensagem = clienteService.removerCliente(clienteDocumento);
        System.out.println(mensagem);
    }

    public void atualizarCliente(ClienteEntity cliente) {
        String mensagem = clienteService.atualizarCliente(cliente);
        System.out.println(mensagem);
    }

    public void buscarClientePorCpf(String cpf) {
        ClienteEntity cliente = clienteService.buscarClienteCPF(cpf);
        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}
