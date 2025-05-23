package com.charmeetchic.CharmeetChic.service;

import com.charmeetchic.CharmeetChic.model.Inventario;
import com.charmeetchic.CharmeetChic.model.Notificaciones;
import com.charmeetchic.CharmeetChic.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired; // Para inyección de dependencias
import org.springframework.stereotype.Service; // Marca la clase como un servicio

import java.util.List; // Para manejar listas de objetos

@Service // Define la clase como un componente de servicio
public class InventarioService {
    @Autowired // Inyecta el repositorio de inventario
    private InventarioRepository inventarioRepository;

    @Autowired // Inyecta el servicio de notificaciones
    private NotificacionesService notificacionesService;

    // Devuelve todos los registros de inventario
    public List<Inventario> obtenerTodo() {
        return inventarioRepository.findAll();
    }

    // Guarda un nuevo inventario y verifica si hay que lanzar alerta de stock
    public Inventario guardar(Inventario inventario) {
        inventario.verificarAlerta(); // Verifica si se debe activar la alerta

        // Si hay alerta, crea y envía una notificación
        if (inventario.isAlerta()) {
            Notificaciones noti = new Notificaciones();
            noti.setDestinatario("admin@charmeetchic.com"); // Destinatario fijo para alertas
            noti.setMensaje("ALERTA: El producto con ID " + inventario.getProductoId()
                    + " tiene stock bajo (" + inventario.getStock() + " unidades)");
            noti.setTipo("EMAIL"); // Tipo de notificación
            noti.setEnviado(false); // Marca la notificación como no enviada
            notificacionesService.enviarNotificacion(noti); // Envía la notificación
        }

        return inventarioRepository.save(inventario); // Guarda en base de datos
    }

    // Elimina un inventario por ID
    public void eliminar(Long id) {
        inventarioRepository.deleteById(id);
    }

    // Actualiza un inventario existente
    public Inventario actualizar(Long id, Inventario nuevoInventario) {
        Inventario existente = inventarioRepository.findById(id).orElseThrow(); // Busca el inventario por ID
        // Actualiza campos
        existente.setProductoId(nuevoInventario.getProductoId());
        existente.setStock(nuevoInventario.getStock());
        existente.setStockMinimo(nuevoInventario.getStockMinimo());
        existente.verificarAlerta();

        // Si hay alerta, notifica
        if (existente.isAlerta()) {
            Notificaciones noti = new Notificaciones();
            noti.setDestinatario("admin@charmeetchic.com");
            noti.setMensaje("ALERTA: El producto con ID " + existente.getProductoId()
                    + " tiene stock bajo (" + existente.getStock() + " unidades)");
            noti.setTipo("EMAIL");
            noti.setEnviado(false);
            notificacionesService.enviarNotificacion(noti);
        }

        return inventarioRepository.save(existente); // Guarda cambios
    }
}
