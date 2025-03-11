package br.com.fintech.model.dto;

import br.com.fintech.model.entity.ClienteEntity;
import br.com.fintech.model.entity.ContaEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

public record TransacaoResponseDTO(BigDecimal valor,
                                   Date data,
                                   Optional<ClienteEntity> cliente,
                                   ContaEntity conta, String tipo) {
}
