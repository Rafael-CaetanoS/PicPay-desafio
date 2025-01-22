package com.picpay.desafio.domain.Usuarios;

import java.math.BigDecimal;

public record UsuarioDTO(String primeiroNomer, String segundoNome, String cpf, String email, String senha, BigDecimal caixa, TipoUsuario tipoUsuario) {
}
