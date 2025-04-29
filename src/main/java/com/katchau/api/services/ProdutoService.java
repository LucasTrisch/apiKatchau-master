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
        Produto produto = new Produto();
        return toDTO(produto);
    }

    public ProdutoDTO criar(Produto produtoDTO) {
        Produto produto = toEntity(produtoDTO);
        return toDTO(produto);
    }

    public ProdutoDTO atualizar(Long id, Produto produtoDTO) {
        Produto produto = toEntity(produtoDTO);
        return toDTO(produto);
    }

    public void deletar(Long id) {
    }

    private ProdutoDTO toDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setPreco(produto.getPreco());
        return dto;
    }

    private Produto toEntity(Produto dto) {
        Produto produto = new Produto();
        produto.setId(dto.getId());
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        return produto;
    }
}


