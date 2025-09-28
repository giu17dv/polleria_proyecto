package com.sise.polleria_proyecto.Usuario.Domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sise.polleria_proyecto.Usuario.Domain.Model.Usuario;
import com.sise.polleria_proyecto.Usuario.Domain.repository.UsuarioRepository;


@Service
public class UsuarioDomainService {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public Usuario insertarUsuario(Usuario usuario) {
        Usuario newUsuario = usuarioRepository.save(usuario);
        return usuarioRepository.findById(newUsuario.getIdUsuario()).orElse(null);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    

    // Editar Usuario
    public Usuario editarUsuario(Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getIdUsuario())) {
            usuarioRepository.save(usuario);
            return usuarioRepository.findById(usuario.getIdUsuario()).orElse(null);
        } else {
            return null;
        }
    }

    // Eliminar Usuario
    public Usuario eliminarUsuario(Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getIdUsuario())) {
            usuarioRepository.deleteById(usuario.getIdUsuario());
            return usuario;
        } else {
            return null;
        }
    }

}
