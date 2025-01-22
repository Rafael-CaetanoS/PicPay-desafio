package com.picpay.desafio.service;

import com.picpay.desafio.domain.Usuarios.Usuario;
import com.picpay.desafio.domain.transacao.Transacao;
import com.picpay.desafio.dto.TransacaoDTO;
import com.picpay.desafio.repositorys.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransacaoService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Transacao criarTransacao(TransacaoDTO transacao) throws Exception {
        Usuario remetente = this.usuarioService.findUsuarioById(transacao.remetente());
        Usuario destino = this.usuarioService.findUsuarioById(transacao.destino());

        this.usuarioService.validandoTransacao(remetente, transacao.valor());
        boolean autorizado =this.autorizacaoTransacao();

        if (!autorizado){
            throw new Exception("transação não autorizada");
        }

        Transacao nvTransacao = new Transacao();
        nvTransacao.setRemetente(remetente);
        nvTransacao.setDestino(destino);
        nvTransacao.setValor(transacao.valor());
        nvTransacao.setDataTransacao(LocalDateTime.now());

        remetente.setCaixa(remetente.getCaixa().subtract(transacao.valor()));
        destino.setCaixa(destino.getCaixa().add(transacao.valor()));

        this.usuarioService.saveUsuario(destino);
        this.usuarioService.saveUsuario(remetente);
        this.transacaoRepository.save(nvTransacao);

        return nvTransacao;
    }

    public boolean autorizacaoTransacao() {
        ResponseEntity<Map> autorizacaoResponse = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);
        if (autorizacaoResponse.getStatusCode() == HttpStatus.OK) {
            Map<String, Object> body = autorizacaoResponse.getBody();
            if (body != null && body.containsKey("data")) {
                Map<String, Object> data = (Map<String, Object>) body.get("data");
                return Boolean.TRUE.equals(data.get("authorization"));
            }
        }
        return false;
    }
}
