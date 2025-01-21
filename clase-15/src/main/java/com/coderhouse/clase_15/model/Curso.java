package com.coderhouse.clase_15.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cursos")
@Schema(description = "Modelo de Curso", title = "Modelo de Curso")
public class Curso {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    @Schema(description = "ID de Curso", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Nombre de Curso", requiredMode = Schema.RequiredMode.REQUIRED, example = "Java")
    @Column(nullable = false)
    private String nombre;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "curso_alumno",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "alumno_id")
    )
    @JsonIgnore
    private List<Alumno> alumnos = new ArrayList<>();

    @Schema(description = "Categoria de curso", requiredMode = Schema.RequiredMode.REQUIRED, example = "Backend")
    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;
}

