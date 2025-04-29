package com.katchau.api.services;

import com.katchau.api.dtos.ItemDTO;
import com.katchau.api.models.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItenService {

    public List<ItemDTO> listarTodos() {
        List<Item> itens = new ArrayList<>(); // Simulação de busca no banco
        List<ItemDTO> itensDTO = new ArrayList<>();
        for (Item item : itens) {
            itensDTO.add(toDTO(item));
        }
        return itensDTO;
    }

    public ItemDTO buscarPorId(Long id) {
        Item item = new Item(); // Simulação de busca no banco
        return toDTO(item);
    }

    public ItemDTO criar(Item itemDTO) {
        Item item = toEntity(itemDTO);

        return toDTO(item);
    }

    public ItemDTO atualizar(Long id, Item itemDTO) {
        Item item = toEntity(itemDTO);
        return toDTO(item);
    }

    public void deletar(Long id) {
        // Simulação de exclusão no banco
    }

    private ItemDTO toDTO(Item item) {
        ItemDTO dto = new ItemDTO();
        dto.setId(item.getId());
        dto.setNome(item.getNome());
        dto.setQuantidade(item.getQuantidade());
        return dto;
    }

    private Item toEntity(Item dto) {
        Item item = new Item();
        item.setId(dto.getId());
        item.setNome(dto.getNome());
        item.setQuantidade(dto.getQuantidade());
        return item;
    }
}
