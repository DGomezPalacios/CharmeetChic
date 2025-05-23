package com.charmeetchic.CharmeetChic.service;

import com.charmeetchic.CharmeetChic.model.Envios;
import com.charmeetchic.CharmeetChic.repository.EnviosRepository;
import org.springframework.beans.factory.annotation.Autowired; // Para inyección de dependencias
import org.springframework.stereotype.Service; // Marca esta clase como un servicio de Spring

import java.util.List;

@Service // Define esta clase como un servicio de la lógica del negocio
public class EnviosService {
    @Autowired // Inyecta automáticamente una instancia del repositorio
    private EnviosRepository enviosRepository;

    // Devuelve todos los registros de envíos en la base de datos
    public List<Envios> obtenerTodos() {
        return enviosRepository.findAll();
    }

    // Guarda un nuevo envío o actualiza uno existente
    public Envios guardar(Envios envio) {
        return enviosRepository.save(envio);
    }

    // Elimina un envío por su ID
    public void eliminar(Long id) {
        enviosRepository.deleteById(id);
    }

    // Actualiza el estado de un envío específico
    public Envios actualizarEstado(Long id, String nuevoEstado) {
        Envios envio = enviosRepository.findById(id).orElseThrow(); // Obtiene el envío por ID o lanza excepción
        envio.setEstado(nuevoEstado); // Establece el nuevo estado
        return enviosRepository.save(envio); // Guarda los cambios
    }
}
