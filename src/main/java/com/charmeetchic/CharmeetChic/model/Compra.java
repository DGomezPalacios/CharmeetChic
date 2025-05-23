package com.charmeetchic.CharmeetChic.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data // Lombok genera automáticamente getters, setters, toString, equals y hashCode
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID de la compra

    private Long usuarioId; // ID del usuario que realiza la compra

    private String estado; // Estado de la compra: EN_CARRITO, PAGADO, ENVIADO, etc.

    private Double total; // Monto total de la compra

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "compra_id")
    private List<DetalleCompra> detalles; // Lista de productos y cantidades

    // Subclase embebida para los detalles
    @Entity
    @Data
    public static class DetalleCompra {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id; // ID del detalle

        private Long productoId; // ID del producto

        private int cantidad; // Cantidad comprada del producto

        private Double precioUnitario; // Precio unitario del producto en ese momento

        private Double subtotal; // precioUnitario * cantidad
    }
}
