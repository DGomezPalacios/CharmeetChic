package com.charmeetchic.CharmeetChic.model;

import jakarta.persistence.*;

@Entity
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productoId;
    private int stock;
    private int stockMinimo;
    private boolean alerta;

    public void verificarAlerta() {
        this.alerta = this.stock <= this.stockMinimo;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }
    public int getStock() { return stock; }
    public void setStock(int stock) {
        this.stock = stock;
        verificarAlerta();
    }

    public int getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
        verificarAlerta();
    }

    public boolean isAlerta() { return alerta; }
    public void setAlerta(boolean alerta) { this.alerta = alerta; }
}