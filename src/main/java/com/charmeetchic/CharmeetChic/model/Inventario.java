package com.charmeetchic.CharmeetChic.model;

import jakarta.persistence.*; // Importa las anotaciones necesarias para JPA

@Entity // Indica que esta clase es una entidad de base de datos
public class Inventario {
    @Id // Indica que este campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La clave primaria se genera automáticamente
    private Long id; // Identificador único del inventario
    private Long productoId; // ID del producto relacionado con el inventario
    private int stock; // Cantidad actual de unidades disponibles
    private int stockMinimo; // Cantidad mínima requerida para evitar escasez
    private boolean alerta; // Bandera para indicar si el stock está por debajo del mínimo

    // Verifica si el stock actual está por debajo del mínimo y activa la alerta
    public void verificarAlerta() {
        this.alerta = this.stock < this.stockMinimo;
    }

    // Getters y Setters para acceder y modificar los campos
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public int getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(int stockMinimo) { this.stockMinimo = stockMinimo; }

    public boolean isAlerta() { return alerta; }
    public void setAlerta(boolean alerta) { this.alerta = alerta; }
}