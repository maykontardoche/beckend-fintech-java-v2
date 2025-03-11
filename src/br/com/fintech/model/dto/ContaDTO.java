package br.com.fintech.model.dto;

import java.math.BigDecimal;

public record ContaDTO(
                       String titular,
                       String codigo,
                       String instituicao,
                       String agencia,
                       String conta,
                       BigDecimal saldo
) {}
