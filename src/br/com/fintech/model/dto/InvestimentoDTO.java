package br.com.fintech.model.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

public record InvestimentoDTO(
                              String documentoTitular,
                              BigDecimal valor,
                              BigDecimal rendimento,
                              Optional<BigInteger> meses,
                              Optional<BigDecimal> valorFinal,
                              Date dataInicio) {
}