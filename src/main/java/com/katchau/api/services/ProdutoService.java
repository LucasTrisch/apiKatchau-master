package com.katchau.api.services;

import com.katchau.api.dtos.ProdutoDTO;
import com.katchau.api.models.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    public List<ProdutoDTO> listarTodos() {
        List<Produto> produtos = new ArrayList<>(); // Simulação de busca no banco
        List<ProdutoDTO> produtosDTO = new ArrayList<>();
        for (Produto produto : produtos) {
            produtosDTO.add(toDTO(produto));
        }
        return produtosDTO;
    }

    public ProdutoDTO buscarPorId(Long id) {
        Produto produto = new Produto(); // Simulação
        return toDTO(produto);
    }

    public ProdutoDTO criar(Produto produto) {
        Produto novoProduto = new Produto(); // Simulação
        return toDTO(novoProduto);
    }

    public ProdutoDTO atualizar(Long id, Produto produto) {
        Produto produtoAtualizado = new Produto(); // Simulação
        return toDTO(produtoAtualizado);
    }

    public void deletar(Long id) {
        // Simulação de exclusão
    }

    private ProdutoDTO toDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setPreco(produto.getPreco());
        return dto;
    }
}