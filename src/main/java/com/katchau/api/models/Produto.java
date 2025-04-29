package com.katchau.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    public Produto() {
    }
    public Produto(Long id, String nome, String descricao, Double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
    public Produto(Produto produtoDTO) {
        this.id = produtoDTO.getId();
        this.nome = produtoDTO.getNome();
        this.descricao = produtoDTO.getDescricao();
        this.preco = produtoDTO.getPreco();
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }

}