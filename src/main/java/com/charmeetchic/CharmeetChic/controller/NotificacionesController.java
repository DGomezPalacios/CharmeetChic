package com.charmeetchic.CharmeetChic.controller;

import com.charmeetchic.CharmeetChic.model.Notificaciones;
import com.charmeetchic.CharmeetChic.service.NotificacionesService;
import org.springframework.beans.factory.annotation.Autowired; // Inyección de dependencias
import org.springframework.web.bind.annotation.*; // Anotaciones REST de Spring

import java.util.List; // Manejo de listas

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api/notificaciones") // URL base para este microservicio
public class NotificacionesController {
    @Autowired // Inyecta el servicio de notificaciones
    private NotificacionesService notificacionesService;

    @GetMapping // Maneja solicitudes GET para listar notificaciones
    public List<Notificaciones> listarNotificaciones() {
        return notificacionesService.obtenerTodas();
    }

    @PostMapping // Maneja solicitudes POST para enviar una nueva notificación
    public Notificaciones enviar(@RequestBody Notificaciones notificacion) {
        return notificacionesService.enviarNotificacion(notificacion);
    }

    @PutMapping("/{id}") // Maneja solicitudes PUT para actualizar una notificación por ID
    public Notificaciones actualizar(@PathVariable Long id, @RequestBody Notificaciones notificacion) {
        return notificacionesService.actualizar(id, notificacion);
    }

    @DeleteMapping("/{id}") // Maneja solicitudes DELETE para eliminar una notificación
    public void eliminar(@PathVariable Long id) {
        notificacionesService.eliminar(id);
    }
}
