package com.katchau.api.services;

import com.katchau.api.dtos.UsuarioDTO;
import com.katchau.api.models.Usuario;
import com.katchau.api.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDTO> listarTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuariosDTO.add(toDTO(usuario));
        }
        return usuariosDTO;
    }

    public UsuarioDTO buscarPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(this::toDTO).orElse(null);
    }

    public UsuarioDTO criar(UsuarioDTO usuarioDTO) {
        Usuario usuario = toEntity(usuarioDTO);
        Usuario novoUsuario = (Usuario) usuarioRepository.save(usuario);
        return toDTO(novoUsuario);
    }

    public UsuarioDTO atualizar(Long id, UsuarioDTO usuarioDTO) {
        if (usuarioRepository.existsById(id)) {
            Usuario usuario = toEntity(usuarioDTO);
            usuario.setId(id);
            Usuario usuarioAtualizado = (Usuario) usuarioRepository.save(usuario);
            return toDTO(usuarioAtualizado);
        }
        return null;
    }

    public void deletar(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        }
    }

    private UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        return dto;
    }

    private Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        return usuario;
    }
}