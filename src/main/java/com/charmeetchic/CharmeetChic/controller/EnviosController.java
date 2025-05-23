package com.charmeetchic.CharmeetChic.controller;

import com.charmeetchic.CharmeetChic.model.Envios;
import com.charmeetchic.CharmeetChic.service.EnviosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marca esta clase como un controlador REST
@RequestMapping("/api/envios") // Define la URL base para todas las rutas de este controlador
public class EnviosController {
    @Autowired // Inyecta el servicio de envíos
    private EnviosService enviosService;

    @GetMapping // Maneja solicitudes GET en "/api/envios"
    public List<Envios> listar() {
        return enviosService.obtenerTodos(); // Devuelve la lista de todos los envíos
    }

    @PostMapping // Maneja solicitudes POST en "/api/envios"
    public Envios crear(@RequestBody Envios envio) { // Recibe un objeto Envios desde el cuerpo de la petición
        return enviosService.guardar(envio); // Guarda el nuevo envío
    }

    @PutMapping("/{id}/estado") // Maneja solicitudes PUT para actualizar el estado del envío con el ID especificado
    public Envios actualizarEstado(@PathVariable Long id, @RequestBody String nuevoEstado) { // Recibe el nuevo estado en el cuerpo
        return enviosService.actualizarEstado(id, nuevoEstado); // Llama al servicio para actualizar el estado
    }

    @DeleteMapping("/{id}") // Maneja solicitudes DELETE para eliminar un envío por ID
    public void eliminar(@PathVariable Long id) {
        enviosService.eliminar(id); // Elimina el envío
    }
}
