package com.charmeetchic.CharmeetChic.service;

import com.charmeetchic.CharmeetChic.model.Notificaciones;
import com.charmeetchic.CharmeetChic.repository.NotificacionesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotificacionesService {

    private final NotificacionesRepository notificacionesRepository;

    public List<Notificaciones> obtenerTodas() {
        return notificacionesRepository.findAll();
    }

    public Notificaciones guardar(Notificaciones notificacion) {
        return notificacionesRepository.save(notificacion);
    }

    public void eliminar(Long id) {
        notificacionesRepository.deleteById(id);
    }
}
