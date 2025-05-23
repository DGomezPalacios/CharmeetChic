package com.charmeetchic.CharmeetChic.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charmeetchic.CharmeetChic.model.Producto;
import com.charmeetchic.CharmeetChic.service.ProductoService;

import lombok.AllArgsConstructor;

@RestController 
@RequestMapping("/api/productos") // Ruta base para todos los endpoints
@AllArgsConstructor // Inyección de dependencias mediante constructor automático
public class ProductoController {

    private final ProductoService productoService;

    // Endpoint para crear un nuevo producto (POST)
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.crearProducto(producto));
    }

    // Endpoint para modificar un producto existente (PUT)
    @PutMapping
    public ResponseEntity<Producto> modificarProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.modificarProducto(producto));
    }

    // Endpoint para eliminar un producto por ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para buscar productos por nombre parcial (GET con query param)
    @GetMapping("/buscar")
    public ResponseEntity<List<Producto>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(productoService.buscarPorNombre(nombre));
    }

    // Endpoint para buscar un producto por ID (GET con path variable)
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable Long id) {
        return productoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para listar todos los productos (GET)
    @GetMapping
    public ResponseEntity<List<Producto>> listarTodos() {
        return ResponseEntity.ok(productoService.listarTodos());
    }
}