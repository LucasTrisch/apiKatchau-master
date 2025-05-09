package com.katchau.api.resources;


import com.katchau.api.dtos.ItemDTO;
import com.katchau.api.models.Item;
import com.katchau.api.services.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemResource {

    private final ItemService itemService;

    public ItemResource(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<ItemDTO>> listarTodos() {
        List<ItemDTO> itens = itemService.listarTodos();
        return ResponseEntity.ok(itens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> buscarPorId(@PathVariable Long id) {
        ItemDTO item = itemService.buscarPorId(id);
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<ItemDTO> criar(@RequestBody Item item) {
        ItemDTO novoItem = itemService.criar(item);
        return ResponseEntity.status(201).body(novoItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDTO> atualizar(@PathVariable Long id, @RequestBody Item item) {
        ItemDTO itemAtualizado = itemService.atualizar(id, item);
        return ResponseEntity.ok(itemAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        itemService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

