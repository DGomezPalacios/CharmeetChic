package com.charmeetchic.CharmeetChic.repository;

import com.charmeetchic.CharmeetChic.model.Envios;
import org.springframework.data.jpa.repository.JpaRepository; // Importa JpaRepository para acceso a datos

// Interfaz que permite realizar operaciones CRUD sobre la entidad Envios
public interface EnviosRepository extends JpaRepository<Envios, Long> {}
