package com.picpay.desafio.controllers;

import com.picpay.desafio.domain.Usuarios.Usuario;
import com.picpay.desafio.domain.Usuarios.UsuarioDTO;
import com.picpay.desafio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody UsuarioDTO usuario) throws Exception {
        Usuario novoUsuario = this.usuarioService.criarUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuario(){
        List<Usuario> usuarios = this.usuarioService.getAllUsuarios();
        return new ResponseEntity<>(usuarios,HttpStatus.OK);
    }
}
