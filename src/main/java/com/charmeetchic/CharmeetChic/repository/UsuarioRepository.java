package com.charmeetchic.CharmeetChic.repository;

import java.util.Optional;

import com.charmeetchic.CharmeetChic.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findbyCorreo(String correo);

}
