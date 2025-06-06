package com.charmeetchic.CharmeetChic.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charmeetchic.CharmeetChic.model.Pago;
import com.charmeetchic.CharmeetChic.service.PagoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping
@AllArgsConstructor
public class PagoController {
    private PagoService pagoService;

    //procesar pagos
    @PostMapping
    public ResponseEntity<Pago> procesarPago(@RequestBody Pago pago) {
        return ResponseEntity.ok(pagoService.procesarPago(pago));
    }

    //buscar pagos de un pedido
    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<List<Pago>> buscarPorPedido(@PathVariable Long pedidoId) {
        return ResponseEntity.ok(pagoService.buscarPorPedido(pedidoId));
    }

    //pago por id
    @GetMapping("/{id}")
    public ResponseEntity<Pago> buscarPorId(@PathVariable Long id) {
        return pagoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //listar pagos
    @GetMapping
    public ResponseEntity<List<Pago>> listarTodos() {
        return ResponseEntity.ok(pagoService.listarTodos());
    }

}
