package com.charmeetchic.CharmeetChic.controller;

// Importamos el modelo de Reporte
import com.charmeetchic.CharmeetChic.model.Reporte;

// Importamos el servicio asociado a Reporte
import com.charmeetchic.CharmeetChic.service.ReporteService;

// Importamos anotaciones necesarias de Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; // Importamos la clase List para manejar listas de reportes

// Indicamos que esta clase es un controlador REST
@RestController

// Definimos la ruta base para todas las peticiones HTTP relacionadas con reportes
@RequestMapping("/api/reportes")
public class ReporteController {

    // Inyectamos el servicio de reportes para usar sus métodos dentro del controlador
    @Autowired
    private ReporteService reporteService;

    // ==================== MÉTODOS DEL CRUD ====================

    // Método para obtener todos los reportes existentes
    @GetMapping
    public List<Reporte> listarReportes() {
        return reporteService.obtenerTodos(); // Llama al servicio para traer todos los reportes
    }

    // Método para crear un nuevo reporte
    @PostMapping
    public Reporte crearReporte(@RequestBody Reporte reporte) {
        return reporteService.guardar(reporte); // Guarda el reporte recibido en el cuerpo de la solicitud
    }

    // Método para actualizar un reporte existente
    @PutMapping("/{id}")
    public Reporte actualizarReporte(@PathVariable Long id, @RequestBody Reporte reporte) {
        reporte.setId(id); // Establece el ID al objeto que se va a actualizar
        return reporteService.guardar(reporte); // Llama al servicio para guardar la modificación
    }

    // Método para eliminar un reporte por su ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        reporteService.eliminar(id); // Llama al servicio para eliminar el reporte
    }
}
