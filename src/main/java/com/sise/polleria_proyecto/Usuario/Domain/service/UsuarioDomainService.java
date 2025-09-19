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

}
