package com.katchau.api.models;

import com.katchau.api.dtos.PedidoDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Pedido() {}

    public Pedido(PedidoDTO pedidoDTO) {
        this.id = pedidoDTO.getId();
        this.nome = pedidoDTO.getNome();
        this.descricao = pedidoDTO.getDescricao();
        this.preco = pedidoDTO.getPreco();
    }

    public Pedido(Long id, String nome, String descricao, Double preco, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.usuario = usuario;
    }

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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}