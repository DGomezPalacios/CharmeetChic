package com.charmeetchic.CharmeetChic.repository;

import java.util.Optional;

import com.charmeetchic.CharmeetChic.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository; 

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    Optional<Inventario> findByProductoId(Long productoId);
}
