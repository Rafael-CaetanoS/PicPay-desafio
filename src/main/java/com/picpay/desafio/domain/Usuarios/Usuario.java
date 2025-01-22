package com.picpay.desafio.domain.Usuarios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String primeiroNome;

    @Column(nullable = false)
    private String ultimoNome;

    @Column(unique = true,nullable = false)
    private String cpf;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private BigDecimal caixa;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipoUsuario;

    public Usuario(UsuarioDTO usuarioDTO){
        this.primeiroNome = usuarioDTO.primeiroNomer();
        this.ultimoNome = usuarioDTO.segundoNome();
        this.cpf = usuarioDTO.cpf();
        this.email = usuarioDTO.email();
        this.senha = usuarioDTO.senha();
        this.caixa = usuarioDTO.caixa();
        this.tipoUsuario = usuarioDTO.tipoUsuario();
    }
}
