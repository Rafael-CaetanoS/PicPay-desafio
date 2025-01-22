package com.picpay.desafio.controllers;

import com.picpay.desafio.domain.transacao.Transacao;
import com.picpay.desafio.dto.TransacaoDTO;
import com.picpay.desafio.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Transacao> criarTransacao(@RequestBody TransacaoDTO transacao) throws Exception {
     Transacao novaTransacao =  this.transacaoService.criarTransacao(transacao);
     return new ResponseEntity<>(novaTransacao, HttpStatus.CREATED);
    }
}
