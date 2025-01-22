package com.picpay.desafio.service;

import com.picpay.desafio.domain.Usuarios.TipoUsuario;
import com.picpay.desafio.domain.Usuarios.Usuario;
import com.picpay.desafio.domain.Usuarios.UsuarioDTO;
import com.picpay.desafio.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validandoTransacao(Usuario user, BigDecimal valor) throws Exception {
        if(user.getTipoUsuario() == TipoUsuario.lojista){
            throw new Exception("lojista não pode fazer transação");
        }

        if(user.getCaixa().compareTo(valor) < 0){
            throw new Exception("saldo insuficiente");
        }

    }

    public Usuario findUsuarioById(Long id) throws Exception {
        return this.usuarioRepository.findUsuarioById(id).orElseThrow(() -> new Exception("usuario não encontrado"));
    }

    public List<Usuario> getAllUsuarios(){
        return this.usuarioRepository.findAll();
    }

    public Usuario criarUsuario(UsuarioDTO usuario) throws Exception {
        Usuario novoUsuario = new Usuario(usuario);
        this.saveUsuario(novoUsuario);
        return novoUsuario;
    }

    public Usuario saveUsuario(Usuario user) throws Exception {
        Usuario usuarioResult = null;

        if (user.getId() != null) {
            usuarioResult = this.usuarioRepository.findUsuarioById(user.getId()).orElseThrow(() -> new Exception("usuario não encontrado"));
            if (usuarioResult != null) {
                usuarioResult.setPrimeiroNome(user.getPrimeiroNome());
                usuarioResult.setUltimoNome(user.getUltimoNome());
                usuarioResult.setCpf(user.getCpf());
                usuarioResult.setEmail(user.getEmail());
                usuarioResult.setSenha(user.getSenha());
                usuarioResult.setCaixa(user.getCaixa());
                usuarioResult.setTipoUsuario(user.getTipoUsuario());

                usuarioResult = this.usuarioRepository.save(usuarioResult);

            }
        }else usuarioResult = this.usuarioRepository.save(user);
        return usuarioResult;
    }
}
