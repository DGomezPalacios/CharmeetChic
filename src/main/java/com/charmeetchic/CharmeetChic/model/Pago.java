package com.charmeetchic.CharmeetChic.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private Long pedidoId;       // ID del pedido al que pertenece el pago

    private Double monto;        // Monto total del pago

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;      // Fecha y hora del pago

    private String metodoPago;   // Método de pago (ej: "Transferencia", "Tarjeta", etc.)

    private String estado;  

}
