package com.picpay.desafio.repositorys;

import com.picpay.desafio.domain.Usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findUsuarioByCpf(String cpf);
    Optional<Usuario> findUsuarioById(Long id);

}
