package com.katchau.api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository<Item> extends JpaRepository<Item, Long> {
    Optional<Item> findByEmail(String email);
}

