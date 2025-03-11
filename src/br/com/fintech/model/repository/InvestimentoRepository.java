package br.com.fintech.model.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fintech.model.entity.InvestimentoEntity;


public class InvestimentoRepository {
    private static InvestimentoRepository instance;
    private final ArrayList<InvestimentoEntity> investimentos;

    public InvestimentoRepository() {
        this.investimentos = new ArrayList<InvestimentoEntity>();
    }

    public static InvestimentoRepository getInstance() {
        if (instance == null) {
            instance = new InvestimentoRepository();
        }
        return instance;
    }

    public ArrayList<InvestimentoEntity> findAll() {
        return investimentos;
    }

    public void save(InvestimentoEntity investimento) {
        investimentos.add(investimento);
    }

    public List<InvestimentoEntity> findByTitular(String titular) {
        return investimentos.stream()
                .filter(investimento -> investimento.getDocumentoTitular().equals(titular)).
                collect(Collectors.toList());
    }
}
