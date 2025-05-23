package com.charmeetchic.CharmeetChic.service;

import com.charmeetchic.CharmeetChic.model.Inventario;
import com.charmeetchic.CharmeetChic.model.Notificaciones;
import com.charmeetchic.CharmeetChic.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private NotificacionesService notificacionesService;

    public List<Inventario> obtenerTodo() {
        return inventarioRepository.findAll();
    }

    public Inventario guardar(Inventario inventario) {
        inventario.verificarAlerta(); // Verifica si hay alerta

        if (inventario.isAlerta()) {
            Notificaciones noti = new Notificaciones();
            noti.setDestinatario("admin@charmeetchic.com"); // podría ser dinámico
            noti.setMensaje("ALERTA: El producto con ID " + inventario.getProductoId()
                    + " tiene stock bajo (" + inventario.getStock() + " unidades)");
            noti.setTipo("EMAIL");
            noti.setEnviado(false);
            notificacionesService.enviarNotificacion(noti);
        }

        return inventarioRepository.save(inventario);
    }

    public void eliminar(Long id) {
        inventarioRepository.deleteById(id);
    }
}