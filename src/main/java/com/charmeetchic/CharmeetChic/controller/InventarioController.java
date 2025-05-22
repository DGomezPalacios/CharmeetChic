package com.charmeetchic.CharmeetChic.controller;

import com.charmeetchic.CharmeetChic.model.Inventario;
import com.charmeetchic.CharmeetChic.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public List<Inventario> listarInventario() {
        return inventarioService.obtenerTodo();
    }

    @PostMapping
    public Inventario agregarInventario(@RequestBody Inventario inventario) {
        return inventarioService.guardar(inventario);
    }

    @PutMapping("/{id}")
    public Inventario actualizarInventario(@PathVariable Long id, @RequestBody Inventario inventario) {
        inventario.setId(id); // Asigna el ID recibido en la URL
        return inventarioService.guardar(inventario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        inventarioService.eliminar(id);
    }
}