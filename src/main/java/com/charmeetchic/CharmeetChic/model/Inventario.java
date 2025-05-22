package com.charmeetchic.CharmeetChic.model;

import jakarta.persistence.*;

@Entity
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int productoId;
    private int stock;
    private int stockMinimo;
    private boolean alerta;

    public void verificarAlerta() {
        this.alerta = this.stock <= this.stockMinimo;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getProductoId() { return productoId; }
    public void setProductoId(int productoId) { this.productoId = productoId; }
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
