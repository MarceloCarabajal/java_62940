package com.coderhouse.finalEcommerce.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental
    private Long Id;

    private String nombre;

    private String apellido;

    private int edad;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private int dni;

    @Column(name = "num_cliente")
    private String numCliente;

    @ManyToMany(mappedBy = "clientes", fetch = FetchType.EAGER)
    private List<Producto> productos = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime createdAt;

}
