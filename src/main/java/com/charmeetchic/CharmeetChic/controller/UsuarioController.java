package com.charmeetchic.CharmeetChic.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charmeetchic.CharmeetChic.model.Usuario;
import com.charmeetchic.CharmeetChic.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.registrar(usuario)); //llama al servicio)
    }

    @PostMapping ("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        Optional<Usuario> autenticado = usuarioService.login(usuario.getCorreo(), usuario.getContrasenia());
        
        //si se encuentra y la contraseña coincide devuev 200
        return autenticado.isPresent()
        ? ResponseEntity.ok(autenticado.get())
        : ResponseEntity.status(401).body("Credenciales incomrrectas");
    }

    @PutMapping ("/actualizar")
    public ResponseEntity<Usuario> actualizar(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.actualizarPerfil(usuario));
    }

}
