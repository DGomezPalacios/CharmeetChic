package com.charmeetchic.CharmeetChic.controller;

import com.charmeetchic.CharmeetChic.model.Inventario;
import com.charmeetchic.CharmeetChic.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired; // Para inyección de dependencias
import org.springframework.web.bind.annotation.*; // Anotaciones de Spring para controladores REST

import java.util.List; // Para manejar listas de objetos

@RestController // Define esta clase como un controlador REST
@RequestMapping("/api/inventario") // URL base para todas las rutas de inventario
public class InventarioController {
    @Autowired // Inyecta el servicio de inventario
    private InventarioService inventarioService;

    @GetMapping // Maneja solicitudes GET para listar todo el inventario
    public List<Inventario> listarInventario() {
        return inventarioService.obtenerTodo();
    }

    @PostMapping // Maneja solicitudes POST para agregar un nuevo inventario
    public Inventario agregarInventario(@RequestBody Inventario inventario) {
        return inventarioService.guardar(inventario);
    }

    @PutMapping("/{id}") // Maneja solicitudes PUT para actualizar inventario por ID
    public Inventario actualizarInventario(@PathVariable Long id, @RequestBody Inventario inventario) {
        return inventarioService.actualizar(id, inventario); // Llama al método del servicio para actualizar
    }

    @DeleteMapping("/{id}") // Maneja solicitudes DELETE para eliminar inventario por ID
    public void eliminar(@PathVariable Long id) {
        inventarioService.eliminar(id);
    }
}
