package com.charmeetchic.CharmeetChic.service;

import com.charmeetchic.CharmeetChic.model.Inventario;
import com.charmeetchic.CharmeetChic.model.Reporte;
import com.charmeetchic.CharmeetChic.repository.ReporteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ReporteService {

    private final ReporteRepository reporteRepository;

    // Obtener todos los reportes
    public List<Reporte> obtenerTodos() {
        return reporteRepository.findAll();
    }

    // Guardar o actualizar un reporte
    public Reporte guardar(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    // Eliminar un reporte por ID
    public void eliminar(Long id) {
        reporteRepository.deleteById(id);
    }

    // Generar reporte de inventario
    public Reporte generarReporteInventarioBajo(List<Inventario> inventarioBajo) {
        StringBuilder contenido = new StringBuilder("Productos con stock bajo:\n");

        for (Inventario i : inventarioBajo) {
            contenido.append("Producto ID: ")
                     .append(i.getProductoId())
                     .append(" - Stock: ")
                     .append(i.getStock())
                     .append("\n");
        }

        Reporte reporte = new Reporte();
        reporte.setTipo("inventario_bajo");
        reporte.setContenido(contenido.toString());
        reporte.setGeneradoPor("sistema");
        reporte.setFecha(LocalDate.now().toString());

        return reporteRepository.save(reporte);
    }
}

