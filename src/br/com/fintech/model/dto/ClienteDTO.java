package br.com.fintech.model.dto;

public record ClienteDTO(
            String nome,
            String documento,
            String email,
            String telefone,
            String endereco,
            String bairro,
            String cidade,
            String estado,
            String cep
    ) {}

