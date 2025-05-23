package com.charmeetchic.CharmeetChic.controller;

import com.charmeetchic.CharmeetChic.model.Envios;
import com.charmeetchic.CharmeetChic.service.EnviosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/envios")
public class EnviosController {
    @Autowired
    private EnviosService enviosService;

    @GetMapping
    public List<Envios> listar() {
        return enviosService.obtenerTodos();
    }

    @PostMapping
    public Envios crear(@RequestBody Envios envio) {
        return enviosService.guardar(envio);
    }

    @PutMapping("/{id}/estado")
    public Envios actualizarEstado(@PathVariable Long id, @RequestBody String nuevoEstado) {
        return enviosService.actualizarEstado(id, nuevoEstado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        enviosService.eliminar(id);
    }
}
