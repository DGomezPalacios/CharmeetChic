package com.charmeetchic.CharmeetChic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.charmeetchic.CharmeetChic.model.Producto;
import com.charmeetchic.CharmeetChic.repository.ProductoRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor

public class ProductoService {
    private ProductoRepository productoRepository;

    //crear un nuevo producto
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    //editar un producto 
    public Producto modificarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    //eliminar un producto por su id
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    //buscar productos por nombre
    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    //buscar un producto por ID
    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }

    //listar productos
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }


}
