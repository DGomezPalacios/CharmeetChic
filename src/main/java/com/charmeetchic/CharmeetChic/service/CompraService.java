package com.charmeetchic.CharmeetChic.service;

import com.charmeetchic.CharmeetChic.model.Compra;
import com.charmeetchic.CharmeetChic.model.Compra.DetalleCompra;
import com.charmeetchic.CharmeetChic.repository.CompraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompraService {

    private final CompraRepository compraRepository;

    // Obtener todas las compras
    public List<Compra> obtenerTodas() {
        return compraRepository.findAll();
    }

    // Guardar nueva compra o actualizar una existente
    public Compra guardar(Compra compra) {
        double total = 0;
        for (DetalleCompra detalle : compra.getDetalles()) {
            detalle.setSubtotal(detalle.getCantidad() * detalle.getPrecioUnitario());
            total += detalle.getSubtotal();
        }
        compra.setTotal(total);
        return compraRepository.save(compra);
    }

    // Eliminar compra por ID
    public void eliminar(Long id) {
        compraRepository.deleteById(id);
    }
}