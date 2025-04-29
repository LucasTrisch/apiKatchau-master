package com.katchau.api.services;

import com.katchau.api.dtos.UsuarioDTO;
import com.katchau.api.models.Usuario;
import com.katchau.api.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRespository;

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());
        return new UsuarioDTO();

    }

    public UsuarioDTO converterUsuarioParaUsuarioDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setSenha(usuario.getSenha());
        return usuarioDTO;
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRespository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
                        new IllegalArgumentException("Usuário não encontrado"));
    }

    public UsuarioDTO buscarUsuarioPorEmail(String email) {
        return converterUsuarioParaUsuarioDTO(UsuarioRepository.findByEmail(email)
                .orElseThrow(() ->
                        new IllegalArgumentException("Usuário não encontrado")));
    }

    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) {
        if (isNull(usuarioDTO.getId())) {
            throw new IllegalArgumentException("campo Id não informado");
        }
        Usuario usuario = UsuarioRepository.findById(usuarioDTO.getId())
        .orElseThrow(() ->
                        new IllegalArgumentException("Usuário não encontrado"));

        usuario = converterUsuarioDTOParaUsuario(usuarioDTO);
        usuario = UsuarioRepository.save(usuario);

        return converterUsuarioParaUsuarioDTO(usuario);
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}


