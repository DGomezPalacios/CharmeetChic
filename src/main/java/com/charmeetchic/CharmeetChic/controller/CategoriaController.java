package com.charmeetchic.CharmeetChic.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charmeetchic.CharmeetChic.model.Categoria;
import com.charmeetchic.CharmeetChic.service.CategoriaService;

import lombok.AllArgsConstructor;

@RestController 
@RequestMapping("/api/categorias") 
@AllArgsConstructor 
public class CategoriaController {

    private final CategoriaService categoriaService;

    //crear una nueva categoria
    @PostMapping
    public ResponseEntity<Categoria> agregarCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.agregarCategoria(categoria));
    }

    //listar todas las categorias
    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }
}