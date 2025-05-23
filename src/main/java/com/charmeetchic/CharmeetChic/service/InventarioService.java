package com.charmeetchic.CharmeetChic.service;

import com.charmeetchic.CharmeetChic.model.Inventario;
import com.charmeetchic.CharmeetChic.repository.InventarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InventarioService {

    private final InventarioRepository inventarioRepository;

    public List<Inventario> obtenerTodos() {
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
