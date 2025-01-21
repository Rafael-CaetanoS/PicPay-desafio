package com.picpay.desafio.repositorys;

import com.picpay.desafio.domain.transacao.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
