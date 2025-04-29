package com.katchau.api.resources;


import com.katchau.api.dtos.ItemDTO;
import com.katchau.api.models.Item;
import com.katchau.api.services.ItenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ItenResource {
    public class itenResource {
        private final ItenService itenService;

        public itenResource(ItenService itenService) {
            this.itenService = itenService;
        }

        @GetMapping
        public ResponseEntity<List<ItemDTO>> listarTodos() {
            List<ItemDTO> itens = itenService.listarTodos();
            return ResponseEntity.ok(itens);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ItemDTO> buscarPorId(@PathVariable Long id) {
            ItemDTO iten = itenService.buscarPorId(id);
            return ResponseEntity.ok(iten);
        }

        @PostMapping
        public ResponseEntity<ItemDTO> criar(@RequestBody Item item) {
            ItemDTO novoIten = itenService.criar(item);
            return ResponseEntity.ok(novoIten);
        }

        @PutMapping("/{id}")
        public ResponseEntity<ItemDTO> atualizar(@PathVariable Long id, @RequestBody Item item) {
            ItemDTO itenAtualizado = itenService.atualizar(id, item);
            return ResponseEntity.ok(itenAtualizado);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletar(@PathVariable Long id) {
            itenService.deletar(id);
            return ResponseEntity.noContent().build();
        }
    }
}

