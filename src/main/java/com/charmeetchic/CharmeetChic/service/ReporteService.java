package com.charmeetchic.CharmeetChic.service;

// Importamos las clases
import com.charmeetchic.CharmeetChic.model.Inventario;
import com.charmeetchic.CharmeetChic.model.Reporte;
import com.charmeetchic.CharmeetChic.repository.ReporteRepository;

// Importamos anotaciones de Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List; // Importamos List para manejar listas de objetos

// Indicamos que esta clase es un servicio de Spring
@Service
public class ReporteService {

    // Inyectamos el repositorio de Reporte para acceder a la base de datos
    @Autowired
    private ReporteRepository reporteRepository;

    // ==================== MÉTODOS CRUD ====================

    // Método para obtener todos los reportes guardados
    public List<Reporte> obtenerTodos() {
        return reporteRepository.findAll(); // Devuelve todos los reportes almacenados
    }

    // Método para guardar (crear o actualizar) un reporte
    public Reporte guardar(Reporte reporte) {
        return reporteRepository.save(reporte); // Guarda el objeto reporte en la base de datos
    }

    // Método para eliminar un reporte por su ID
    public void eliminar(Long id) {
        reporteRepository.deleteById(id); // Elimina el reporte con el ID especificado
    }

    // Método para generar un reporte específico de inventario bajo
    public Reporte generarReporteInventarioBajo(List<Inventario> inventarioBajo) {

        // Creamos el contenido del reporte en formato de texto
        StringBuilder contenido = new StringBuilder("Productos con stock bajo:\n");

        // Recorremos la lista de inventario bajo y añadimos la información al contenido
        for (Inventario i : inventarioBajo) {
            contenido.append("Producto ID: ")
                     .append(i.getProductoId())
                     .append(" - Stock: ")
                     .append(i.getStock())
                     .append("\n");
        }

        // Creamos un nuevo objeto Reporte y seteamos sus campos
        Reporte reporte = new Reporte();
        reporte.setTipo("inventario_bajo"); // Tipo de reporte
        reporte.setContenido(contenido.toString()); // Contenido generado
        reporte.setGeneradoPor("sistema"); // Generador del reporte
        reporte.setFecha(java.time.LocalDate.now().toString()); // Fecha del día actual

        // Guardamos el reporte en la base de datos y lo devolvemos
        return reporteRepository.save(reporte);
    }
}
