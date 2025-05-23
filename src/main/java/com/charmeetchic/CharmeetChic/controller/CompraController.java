package com.charmeetchic.CharmeetChic.controller;

import com.charmeetchic.CharmeetChic.service.CompraService;
import com.charmeetchic.CharmeetChic.model.Compra;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
@AllArgsConstructor
public class CompraController {

    private final CompraService compraService;

    @GetMapping
    public ResponseEntity<List<Compra>> listarCompras() {
        return ResponseEntity.ok(compraService.obtenerTodas());
    }

    @PostMapping
    public ResponseEntity<Compra> crearCompra(@RequestBody Compra compra) {
        return ResponseEntity.ok(compraService.guardar(compra));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> actualizarCompra(@PathVariable Long id, @RequestBody Compra compra) {
        compra.setId(id);
        return ResponseEntity.ok(compraService.guardar(compra));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCompra(@PathVariable Long id) {
        compraService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
