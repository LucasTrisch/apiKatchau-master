package com.katchau.api.services;

import com.katchau.api.dtos.PedidoDTO;
import com.katchau.api.models.Pedido;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    public List<PedidoDTO> listarTodos() {
        List<Pedido> pedidos = new ArrayList<>(); // Simulação de busca no banco
        List<PedidoDTO> pedidosDTO = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            pedidosDTO.add(toDTO(pedido));
        }
        return pedidosDTO;
    }

    public PedidoDTO buscarPorId(Long id) {
        Pedido pedido = new Pedido();
        return toDTO(pedido);
    }

    public PedidoDTO atualizar(Long id, Pedido pedidoDTO) {
        Pedido pedido = toEntity(pedidoDTO);
        return toDTO(pedido);
    }

    public void deletar(Long id) {

    }

    private PedidoDTO toDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setNome(pedido.getNome());
        dto.setDescricao(pedido.getDescricao());
        return dto;
    }

    private Pedido toEntity(Pedido dto) {
        Pedido pedido = new Pedido();
        pedido.setId(dto.getId());
        pedido.setNome(dto.getNome());
        pedido.setDescricao(dto.getDescricao());
        return pedido;
    }

    public Pedido create(Pedido pedido) {
    return pedido;
    }
}