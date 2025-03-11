package br.com.fintech.model.dto;

import java.math.BigDecimal;
import java.util.Date;

public record TransacaoDTO(
                           BigDecimal valor,
                           Date data,
                           String cpf,
                           String tipo
){}
