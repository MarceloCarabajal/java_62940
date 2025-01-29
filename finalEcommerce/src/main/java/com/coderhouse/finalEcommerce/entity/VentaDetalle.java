package com.coderhouse.finalEcommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

/**
 * Representa un detalle de una venta, incluyendo el producto y la cantidad vendida.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "venta_detalles")
@Schema(description = "Modelo de Venta-Detalle", title = "Modelo de Venta-Detalle")
public class VentaDetalle {

    /**
     * Identificador único del detalle de la venta.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private int cantidad;
}
