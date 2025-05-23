package com.charmeetchic.CharmeetChic.repository;

import com.charmeetchic.CharmeetChic.model.Compras;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositorio para gestionar operaciones CRUD con Compras
public interface ComprasRepository extends JpaRepository<Compras, Long> {}