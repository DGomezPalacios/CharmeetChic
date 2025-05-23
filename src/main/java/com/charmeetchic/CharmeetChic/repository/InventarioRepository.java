package com.charmeetchic.CharmeetChic.repository;

import java.util.List;

import com.charmeetchic.CharmeetChic.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository; 

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    List<Inventario> findByProductoId(Long productoId);
}
