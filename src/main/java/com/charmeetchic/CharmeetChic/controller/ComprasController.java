package com.charmeetchic.CharmeetChic.controller;

import com.charmeetchic.CharmeetChic.model.Compras;
import com.charmeetchic.CharmeetChic.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class ComprasController {

    @Autowired
    private ComprasService comprasService;

    // Listar todas las compras
    @GetMapping
    public List<Compras> listarCompras() {
        return comprasService.obtenerCompras();
    }

    // Agregar una nueva compra
    @PostMapping
    public Compras agregarCompra(@RequestBody Compras compras) {
        return comprasService.guardarCompra(compras);
    }

    // Actualizar una compra existente
    @PutMapping("/{id}")
    public Compras actualizarCompra(@PathVariable Long id, @RequestBody Compras compras) {
        return comprasService.actualizarCompra(id, compras);
    }

    // Eliminar una compra
    @DeleteMapping("/{id}")
    public void eliminarCompra(@PathVariable Long id) {
        comprasService.eliminarCompra(id);
    }
}
