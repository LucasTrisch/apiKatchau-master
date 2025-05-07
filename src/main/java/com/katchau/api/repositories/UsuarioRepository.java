package com.katchau.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository<Usuario> extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
