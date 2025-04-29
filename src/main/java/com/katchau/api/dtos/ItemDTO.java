package com.katchau.api.dtos;


public class ItemDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String preco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
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

    public String getPreco() {
        return preco;
    }

    public void setSenha(String senha) {
        this.preco = preco;
    }

    public void setQuantidade(Object quantidade) {
    }
}
