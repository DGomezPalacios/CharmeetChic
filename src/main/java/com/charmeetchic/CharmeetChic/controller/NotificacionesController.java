package com.charmeetchic.CharmeetChic.controller;

import com.charmeetchic.CharmeetChic.model.Notificaciones;
import com.charmeetchic.CharmeetChic.service.NotificacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionesController {
    @Autowired
    private NotificacionesService notificacionesService;

    @GetMapping
    public List<Notificaciones> listarNotificaciones() {
        return notificacionesService.obtenerTodas();
    }

    @PostMapping
    public Notificaciones enviar(@RequestBody Notificaciones notificacion) {
        return notificacionesService.enviarNotificacion(notificacion);
    }

    @PutMapping("/{id}")
    public Notificaciones actualizar(@PathVariable Long id, @RequestBody Notificaciones notificacion) {
        notificacion.setId(id); // Asegura que se actualice el objeto correcto
        return notificacionesService.enviarNotificacion(notificacion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        notificacionesService.eliminar(id);
    }
}