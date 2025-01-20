package com.coderhouse.clase_14.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Alumnos")
@Schema(description = "Modelo de Alumno", title = "Modelo de Alumno")
public class Alumno {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    @Schema(description = "ID del Alumno", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Column(name = "nombre_alumno")
    @Schema(description = "Nombre del Alumno", requiredMode = Schema.RequiredMode.REQUIRED, example = "Marcelo")
    private String nombre;

    @Schema(description = "Apellido del Alumno", requiredMode = Schema.RequiredMode.REQUIRED, example = "Carabajal")
    private String apellido;

    @Column(unique = true, nullable = false) // unico y no nulo
    @Schema(description = "DNI del Alumno", requiredMode = Schema.RequiredMode.REQUIRED, example = "33888777")
    private int dni;

    @Column(unique = true, nullable = false) // unico y no nulo
    @Schema(description = "Legajo del Alumno", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private String legajo;

    @ManyToMany(mappedBy = "alumnos", fetch = FetchType.EAGER)
    @Schema(description = "Listado de Cursos en los que se inscribio el Alumno")
    private List<Curso> cursos = new ArrayList<>();

    @CreationTimestamp
    @Column(updatable = false)
    @Schema(description = "Fecha de alta de alumno", example = "2025/01/15")
    private LocalDateTime createdAt;
}
