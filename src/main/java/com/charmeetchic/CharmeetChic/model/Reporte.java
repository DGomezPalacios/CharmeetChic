package com.charmeetchic.CharmeetChic.model;

import jakarta.persistence.*;

@Entity
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;       // Por ejemplo: "ventas", "inventario", "clientes"
    private String contenido;  // Resumen o JSON generado
    private String generadoPor;
    private String fecha;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
    public String getGeneradoPor() { return generadoPor; }
    public void setGeneradoPor(String generadoPor) { this.generadoPor = generadoPor; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}