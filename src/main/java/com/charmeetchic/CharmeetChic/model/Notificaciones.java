package com.charmeetchic.CharmeetChic.model;

import jakarta.persistence.*; // Importa las anotaciones de JPA para persistencia

@Entity // Indica que esta clase representa una tabla en la base de datos
public class Notificaciones {
    @Id // Define el campo como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID
    private Long id; // Identificador único de la notificación

    private String destinatario; // Email u otro identificador del destinatario

    private String mensaje; // Contenido de la notificación

    private String tipo; // Tipo de notificación (ej: EMAIL, SMS)

    private boolean enviado; // Indica si la notificación ha sido enviada

    // Getters y setters para acceder y modificar los campos
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDestinatario() { return destinatario; }
    public void setDestinatario(String destinatario) { this.destinatario = destinatario; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public boolean isEnviado() { return enviado; }
    public void setEnviado(boolean enviado) { this.enviado = enviado; }
}
