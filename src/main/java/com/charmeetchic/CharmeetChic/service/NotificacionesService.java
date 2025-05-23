package com.charmeetchic.CharmeetChic.service;

import com.charmeetchic.CharmeetChic.model.Notificaciones;
import com.charmeetchic.CharmeetChic.repository.NotificacionesRepository;
import org.springframework.beans.factory.annotation.Autowired; // Inyección de dependencias
import org.springframework.stereotype.Service; // Marca la clase como un servicio

import java.util.List; // Para manejar listas

@Service // Marca esta clase como un componente de servicio
public class NotificacionesService {
    @Autowired // Inyecta el repositorio de notificaciones
    private NotificacionesRepository notificacionesRepository;

    // Devuelve todas las notificaciones registradas
    public List<Notificaciones> obtenerTodas() {
        return notificacionesRepository.findAll();
    }

    // Guarda y simula el envío de una notificación
    public Notificaciones enviarNotificacion(Notificaciones notificacion) {
        notificacion.setEnviado(true); // Marca como enviada
        return notificacionesRepository.save(notificacion); // Guarda en base de datos
    }

    // Elimina una notificación por su ID
    public void eliminar(Long id) {
        notificacionesRepository.deleteById(id);
    }

    // Actualiza una notificación existente
    public Notificaciones actualizar(Long id, Notificaciones nuevaNotificacion) {
        Notificaciones existente = notificacionesRepository.findById(id).orElseThrow(); // Busca la notificación

        // Actualiza los campos necesarios
        existente.setDestinatario(nuevaNotificacion.getDestinatario());
        existente.setMensaje(nuevaNotificacion.getMensaje());
        existente.setTipo(nuevaNotificacion.getTipo());
        existente.setEnviado(nuevaNotificacion.isEnviado());

        return notificacionesRepository.save(existente); // Guarda cambios
    }
}
