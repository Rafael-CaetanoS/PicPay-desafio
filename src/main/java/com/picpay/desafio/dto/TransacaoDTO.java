package com.picpay.desafio.dto;

import java.math.BigDecimal;

public record TransacaoDTO(BigDecimal valor, Long remetente, Long destino) {
}
