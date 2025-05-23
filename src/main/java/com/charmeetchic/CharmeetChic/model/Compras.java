package com.charmeetchic.CharmeetChic.model;

import jakarta.persistence.*;
import java.util.List;

// Entidad principal que representa tanto el carrito como la orden de compra
@Entity
public class Compras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único de la compra

    private Long usuarioId; // Identificador del usuario que realiza la compra

   
    // SECCIÓN: CARRITO
    @ElementCollection
    private List<Long> productoIds; // IDs de productos agregados al carrito

    private Double totalCarrito; // Monto total de los productos en el carrito

    // SECCIÓN: PEDIDO
    private Double totalPedido; // Total final del pedido una vez confirmado
    private String estadoPedido; // Estado del pedido: PAGADO, ENVIADO, ENTREGADO

    @OneToMany(mappedBy = "compras", cascade = CascadeType.ALL)
    private List<DetallePedido> detallesPedido; // Lista de productos detallados en el pedido

    // MÉTODOS GET Y SET
    public Long getId() { return id; } // Obtener ID de la compra
    public void setId(Long id) { this.id = id; } // Establecer ID de la compra

    public Long getUsuarioId() { return usuarioId; } // Obtener ID del usuario
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; } // Establecer ID del usuario

    public List<Long> getProductoIds() { return productoIds; } // Obtener lista de productos en el carrito
    public void setProductoIds(List<Long> productoIds) { this.productoIds = productoIds; } // Establecer productos del carrito

    public Double getTotalCarrito() { return totalCarrito; } // Obtener total del carrito
    public void setTotalCarrito(Double totalCarrito) { this.totalCarrito = totalCarrito; } // Establecer total del carrito

    public Double getTotalPedido() { return totalPedido; } // Obtener total del pedido
    public void setTotalPedido(Double totalPedido) { this.totalPedido = totalPedido; } // Establecer total del pedido

    public String getEstadoPedido() { return estadoPedido; } // Obtener estado del pedido
    public void setEstadoPedido(String estadoPedido) { this.estadoPedido = estadoPedido; } // Establecer estado del pedido

    public List<DetallePedido> getDetallesPedido() { return detallesPedido; } // Obtener detalles del pedido
    public void setDetallesPedido(List<DetallePedido> detallesPedido) {
        this.detallesPedido = detallesPedido; // Establecer lista de detalles

        // Calcular el total del pedido sumando (precio x cantidad) de cada producto
        double total = 0.0;
        for (DetallePedido detalle : detallesPedido) {
            total += detalle.getPrecioUnitario() * detalle.getCantidad();
        }
        this.totalPedido = total; // Actualizar el total del pedido
    }
}

@Entity
class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID del detalle individual del pedido

    private Long productoId; // ID del producto comprado
    private Integer cantidad; // Cantidad del producto comprado
    private Double precioUnitario; // Precio por unidad en el momento de la compra

    @ManyToOne
    @JoinColumn(name = "compras_id")
    private Compras compras; // Referencia a la compra general a la que pertenece este detalle

    public Long getId() { return id; } // Obtener ID del detalle
    public void setId(Long id) { this.id = id; } // Establecer ID del detalle

    public Long getProductoId() { return productoId; } // Obtener ID del producto
    public void setProductoId(Long productoId) { this.productoId = productoId; } // Establecer ID del producto

    public Integer getCantidad() { return cantidad; } // Obtener cantidad del producto
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; } // Establecer cantidad

    public Double getPrecioUnitario() { return precioUnitario; } // Obtener precio por unidad
    public void setPrecioUnitario(Double precioUnitario) { this.precioUnitario = precioUnitario; } // Establecer precio por unidad

    public Compras getCompras() { return compras; } // Obtener la compra asociada
    public void setCompras(Compras compras) { this.compras = compras; } // Establecer compra asociada
}
