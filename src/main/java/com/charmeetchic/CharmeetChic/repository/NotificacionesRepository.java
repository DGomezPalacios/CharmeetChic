package com.charmeetchic.CharmeetChic.repository;

import com.charmeetchic.CharmeetChic.model.Notificaciones;
import org.springframework.data.jpa.repository.JpaRepository; // Interfaz para operaciones CRUD

// Interfaz para manejar persistencia de Notificaciones
public interface NotificacionesRepository extends JpaRepository<Notificaciones, Long> {}
