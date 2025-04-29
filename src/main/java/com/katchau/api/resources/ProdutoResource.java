package com.katchau.api.resources;

import com.katchau.api.dtos.ProdutoDTO;
import com.katchau.api.models.Produto;
import com.katchau.api.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
    private final ProdutoService produtoService;

    public ProdutoResource(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarTodos() {
        List<ProdutoDTO> produtos = produtoService.listarTodos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarPorId(@PathVariable Long id) {
        ProdutoDTO produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criar(@RequestBody Produto produto) {
        ProdutoDTO novoProduto = produtoService.criar(produto);
        return ResponseEntity.ok(novoProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        ProdutoDTO produtoAtualizado = produtoService.atualizar(id, produto);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

