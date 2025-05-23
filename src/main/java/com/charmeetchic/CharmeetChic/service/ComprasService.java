package com.charmeetchic.CharmeetChic.service;

import com.charmeetchic.CharmeetChic.model.Compras;
import com.charmeetchic.CharmeetChic.model.Compras.DetalleCompra;
import com.charmeetchic.CharmeetChic.repository.ComprasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComprasService {

    private final ComprasRepository comprasRepository;

    public List<Compras> obtenerTodas() {
        return comprasRepository.findAll();
    }

    public Compras guardar(Compras compras) {
        double total = 0;
        for (DetalleCompra detalle : compras.getDetalles()) {
            detalle.setSubtotal(detalle.getCantidad() * detalle.getPrecioUnitario());
            total += detalle.getSubtotal();
        }
        compras.setTotal(total);
        return comprasRepository.save(compras);
    }

    public void eliminar(Long id) {
        comprasRepository.deleteById(id);
    }
}
