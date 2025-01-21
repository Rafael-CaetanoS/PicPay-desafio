package com.picpay.desafio.domain.transacao;

import com.picpay.desafio.domain.Usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacao")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn (name = "destino_id")
    private Usuario destino;

    @ManyToOne
    @JoinColumn (name = "remetente_id")
    private Usuario remetente;

    private LocalDateTime dataTransacao;
}

