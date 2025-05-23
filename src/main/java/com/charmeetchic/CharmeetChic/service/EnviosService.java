package com.charmeetchic.CharmeetChic.service;

import com.charmeetchic.CharmeetChic.model.Envios;
import com.charmeetchic.CharmeetChic.repository.EnviosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnviosService {
    @Autowired
    private EnviosRepository enviosRepository;

    public List<Envios> obtenerTodos() {
        return enviosRepository.findAll();
    }

    public Envios guardar(Envios envio) {
        return enviosRepository.save(envio);
    }

    public void eliminar(Long id) {
        enviosRepository.deleteById(id);
    }

    public Envios actualizarEstado(Long id, String nuevoEstado) {
        Envios envio = enviosRepository.findById(id).orElseThrow();
        envio.setEstado(nuevoEstado);
        return enviosRepository.save(envio);
    }
}