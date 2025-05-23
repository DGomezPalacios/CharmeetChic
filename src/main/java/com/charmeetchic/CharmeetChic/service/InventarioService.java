package com.charmeetchic.CharmeetChic.service;

import com.charmeetchic.CharmeetChic.model.Inventario;
import com.charmeetchic.CharmeetChic.model.Notificaciones;
import com.charmeetchic.CharmeetChic.model.Reporte;
import com.charmeetchic.CharmeetChic.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private NotificacionesService notificacionesService;

    @Autowired
    private ReporteService reporteService;

    public List<Inventario> obtenerTodo() {
        return inventarioRepository.findAll();
    }

    public Inventario guardar(Inventario inventario) {
        inventario.verificarAlerta(); // Verifica si hay alerta

        if (inventario.isAlerta()) {
            // Generar notificación por stock bajo
            Notificaciones noti = new Notificaciones();
            noti.setDestinatario("admin@charmeetchic.com");
            noti.setMensaje("ALERTA: El producto con ID " + inventario.getProductoId()
                    + " tiene stock bajo (" + inventario.getStock() + " unidades)");
            noti.setTipo("EMAIL");
            noti.setEnviado(false);
            notificacionesService.enviarNotificacion(noti);

            // Generar reporte de inventario bajo
            Reporte reporte = new Reporte();
            reporte.setTipo("inventario_bajo");
            reporte.setContenido("Producto ID: " + inventario.getProductoId()
                    + " tiene stock bajo. Stock actual: " + inventario.getStock()
                    + ", mínimo requerido: " + inventario.getStockMinimo());
            reporte.setGeneradoPor("InventarioService");
            reporte.setFecha(LocalDate.now().toString());

            reporteService.guardar(reporte);
        }

        return inventarioRepository.save(inventario);
    }

    public void eliminar(Long id) {
        inventarioRepository.deleteById(id);
    }
}