package com.charmeetchic.CharmeetChic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.charmeetchic.CharmeetChic.model.Categoria;
import com.charmeetchic.CharmeetChic.repository.CategoriaRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

//agregar categoria
    public Categoria agregarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
//listar categroais
    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }
}
