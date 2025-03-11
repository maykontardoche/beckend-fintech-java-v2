package br.com.fintech.model.repository;

import br.com.fintech.model.entity.ClienteEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

    public class ClienteRepository {
        private static ClienteRepository instance;
        private final List<ClienteEntity> clientes;

        public ClienteRepository() {
            this.clientes = new ArrayList<>();
        }
        public static ClienteRepository getInstance() {
            if (instance == null) {
                instance = new ClienteRepository();
            }
            return instance;
        }
        public List<ClienteEntity> findAll() {
            return new ArrayList<>(clientes);
        }

        public Optional<ClienteEntity> findByCpf(String cpf) {
            return clientes.stream().filter(cliente -> cpf.equals(cliente.getDocumento()))
                    .findFirst();

        }

        public void save(ClienteEntity cliente) {
            clientes.add(cliente);
        }

        public void update(ClienteEntity cliente) {
            deleteByCpf(cliente.getDocumento());
            save(cliente);
        }

        public void deleteByCpf(String cpf) {
            clientes.removeIf(cliente -> cliente.getDocumento().equals(cpf));
        }
    }

