package com.charmeetchic.CharmeetChic.service;

import com.charmeetchic.CharmeetChic.model.Compras;
import com.charmeetchic.CharmeetChic.repository.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ComprasService {

    @Autowired
    private ComprasRepository comprasRepository;

    // Obtener todas las compras
    public List<Compras> obtenerCompras() {
        return comprasRepository.findAll();
    }

    // Guardar una nueva compra
    public Compras guardarCompra(Compras compras) {
        return comprasRepository.save(compras);
    }

    // Actualizar una compra existente por su ID
    public Compras actualizarCompra(Long id, Compras nuevaCompra) {
        Optional<Compras> optionalCompra = comprasRepository.findById(id);
        if (optionalCompra.isPresent()) {
            Compras compraExistente = optionalCompra.get();
            compraExistente.setUsuarioId(nuevaCompra.getUsuarioId());
            compraExistente.setProductoIds(nuevaCompra.getProductoIds());
            compraExistente.setTotalCarrito(nuevaCompra.getTotalCarrito());
            compraExistente.setEstadoPedido(nuevaCompra.getEstadoPedido());
            compraExistente.setDetallesPedido(nuevaCompra.getDetallesPedido());
            return comprasRepository.save(compraExistente);
        } else {
            return null; // o lanzar una excepción personalizada si se desea
        }
    }

    // Eliminar una compra por su ID
    public void eliminarCompra(Long id) {
        comprasRepository.deleteById(id);
    }
}
