package com.charmeetchic.CharmeetChic.service;

import com.charmeetchic.CharmeetChic.model.Inventario;
import com.charmeetchic.CharmeetChic.model.Reporte;
import com.charmeetchic.CharmeetChic.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    public List<Reporte> obtenerTodos() {
        return reporteRepository.findAll();
    }

    public Reporte guardar(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    public void eliminar(Long id) {
        reporteRepository.deleteById(id);
    }

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
    reporte.setFecha(java.time.LocalDate.now().toString());

    return reporteRepository.save(reporte);
    }
}