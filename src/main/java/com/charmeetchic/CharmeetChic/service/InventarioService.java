package com.charmeetchic.CharmeetChic.service;

import com.charmeetchic.CharmeetChic.model.Inventario;
import com.charmeetchic.CharmeetChic.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> obtenerTodo() {
        return inventarioRepository.findAll();
    }

    public Inventario guardar(Inventario inventario) {
        inventario.verificarAlerta();
        return inventarioRepository.save(inventario);
    }

    public void eliminar(Long id) {
        inventarioRepository.deleteById(id);
    }
}