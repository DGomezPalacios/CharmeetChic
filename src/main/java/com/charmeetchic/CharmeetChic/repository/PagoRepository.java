package com.charmeetchic.CharmeetChic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charmeetchic.CharmeetChic.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    // Puedes agregar métodos como:
    List<Pago> findByPedidoId(Long pedidoId);
}