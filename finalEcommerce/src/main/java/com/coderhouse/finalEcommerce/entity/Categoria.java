package com.coderhouse.finalEcommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una categoría de productos en el sistema de e-commerce.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categorias")
@Schema(description = "Modelo de Categoria", title = "Modelo de Categoria")
public class Categoria {
    /**
     * Identificador único de la categoría.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de la categoría. Debe ser único y no puede ser nulo.
     */
    @Column(unique = true, nullable = false)
    private String nombre;

    /**
     * Lista de productos que pertenecen a esta categoría.
     */
    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Producto> productos = new ArrayList<>();

}
