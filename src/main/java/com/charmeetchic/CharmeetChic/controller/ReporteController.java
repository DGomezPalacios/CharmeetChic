package com.charmeetchic.CharmeetChic.controller;

import com.charmeetchic.CharmeetChic.model.Reporte;
import com.charmeetchic.CharmeetChic.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public List<Reporte> listarReportes() {
        return reporteService.obtenerTodos();
    }

    @PostMapping
    public Reporte crearReporte(@RequestBody Reporte reporte) {
        return reporteService.guardar(reporte);
    }

    @PutMapping("/{id}")
    public Reporte actualizarReporte(@PathVariable Long id, @RequestBody Reporte reporte) {
        reporte.setId(id);
        return reporteService.guardar(reporte);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        reporteService.eliminar(id);
    }
}