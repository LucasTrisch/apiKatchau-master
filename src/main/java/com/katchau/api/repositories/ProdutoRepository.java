package com.katchau.api.repositories;
import com.katchau.api.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository

public interface ProdutoRepository<Usuario> extends JpaRepository<Produto, Long> {
    Optional<Produto> findByDescricao(String descricao);
}
