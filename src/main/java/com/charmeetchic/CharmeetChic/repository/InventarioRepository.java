package com.charmeetchic.CharmeetChic.repository;

import com.charmeetchic.CharmeetChic.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository; // Importa JpaRepository para acceso a datos

// Interfaz que proporciona métodos CRUD para la entidad Inventario
public interface InventarioRepository extends JpaRepository<Inventario, Long> {}
