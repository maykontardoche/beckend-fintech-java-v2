package br.com.fintech.model.repository;

import br.com.fintech.model.entity.ContaEntity;

import java.util.ArrayList;

public class ContaRepository {
    private static ContaRepository instance;
    private final ArrayList<ContaEntity> contas;

    public ContaRepository() {
        this.contas = new ArrayList<ContaEntity>();
    }
    public static ContaRepository getInstance() {
        if (instance == null) {
            instance = new ContaRepository();
        }
        return instance;
    }
    public ArrayList<ContaEntity> findAll() {
        return contas;
    }
    public void save(ContaEntity conta) {
        contas.add(conta);
    }
   public ContaEntity findByTitular(String titular) {
       return contas.stream()
                    .filter(conta -> conta.getTitular().equals(titular))
                    .findFirst()
                    .orElse(null);
   }
}
