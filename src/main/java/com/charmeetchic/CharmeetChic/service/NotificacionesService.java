package com.charmeetchic.CharmeetChic.service;

import com.charmeetchic.CharmeetChic.model.Notificaciones;
import com.charmeetchic.CharmeetChic.repository.NotificacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionesService {
    @Autowired
    private NotificacionesRepository notificacionesRepository;

    public List<Notificaciones> obtenerTodas() {
        return notificacionesRepository.findAll();
    }

    public Notificaciones enviarNotificacion(Notificaciones notificacion) {
        notificacion.setEnviado(true); // Simula el envío
        return notificacionesRepository.save(notificacion);
    }

    public void eliminar(Long id) {
        notificacionesRepository.deleteById(id);
    }
}