package com.charmeetchic.CharmeetChic.model;

import jakarta.persistence.*; // Importa las anotaciones necesarias para JPA

@Entity // Indica que esta clase es una entidad de base de datos
public class Envios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La clave primaria se genera automáticamente
    private Long id;
    private Long ordenId;
    private String direccion;
    private String estado; // Ejemplo: "pendiente", "en camino", "entregado"

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getOrdenId() { return ordenId; }
    public void setOrdenId(Long ordenId) { this.ordenId = ordenId; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
