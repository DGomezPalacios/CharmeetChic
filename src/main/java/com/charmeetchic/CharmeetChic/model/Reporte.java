package com.charmeetchic.CharmeetChic.model;

import jakarta.persistence.*; // Importa las anotaciones para la persistencia JPA

// Anotamos esta clase como una entidad para que JPA la maneje como una tabla en la base de datos
@Entity
public class Reporte {

    // ID principal generado automáticamente para cada reporte
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo; // Tipo del reporte, como "ventas", "inventario", etc.
    private String contenido; // Contenido del reporte (puede ser resumen o formato JSON)
    private String generadoPor; // Nombre del usuario o sistema que generó el reporte
    private String fecha; // Fecha en que se generó el reporte (puede usarse un string para simplificar)
    

    // Getters y Setters
    public Long getId() { return id; } // Devuelve el ID del reporte
    public void setId(Long id) { this.id = id; } // Establece el ID del reporte
    public String getTipo() { return tipo; } // Devuelve el tipo de reporte
    public void setTipo(String tipo) { this.tipo = tipo; } // Establece el tipo de reporte
    public String getContenido() { return contenido; } // Devuelve el contenido del reporte
    public void setContenido(String contenido) { this.contenido = contenido; } // Establece el contenido del reporte
    public String getGeneradoPor() { return generadoPor; } // Devuelve el nombre de quien generó el reporte
    public void setGeneradoPor(String generadoPor) { this.generadoPor = generadoPor; } // Establece el nombre de quien generó el reporte
    public String getFecha() { return fecha; } // Devuelve la fecha del reporte
    public void setFecha(String fecha) { this.fecha = fecha; } // Establece la fecha del reporte
}