package com.charmeetchic.CharmeetChic.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.charmeetchic.CharmeetChic.model.Usuario;
import com.charmeetchic.CharmeetChic.repository.UsuarioRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public Usuario registrar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> login(String correo, String contrasena) {
        Optional<Usuario> user = usuarioRepository.findbyCorreo(correo);
        if (user.isPresent() && user.get().getContrasenia().equals(contrasena)) {
            return user; // login exitoso
        }
        return Optional.empty(); //credenciales incorectas
    }

    public Usuario actualizarPerfil(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    

}
