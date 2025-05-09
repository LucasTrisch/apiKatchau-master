package com.katchau.api.repositories;

import com.katchau.api.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository<Usuario> extends JpaRepository<Pedido, Long> {
    Optional<Usuario> findByDescricao(String descricao);
}
