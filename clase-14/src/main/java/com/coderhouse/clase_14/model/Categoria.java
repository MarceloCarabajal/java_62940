package com.coderhouse.clase_14.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "categorias")
@Schema(description = "Modelo de Categoria", title = "Modelo de Categoria")
public class Categoria {

    @Id // Primary Key
    @Schema(description = "ID de Categoria", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    private Long id;

    @Column(unique = true, nullable = true)
    @Schema(description = "Nombre de Categoria", requiredMode = Schema.RequiredMode.REQUIRED, example = "Backend")
    private String nombre;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @JsonIgnore
    @Schema(description = "Nombre de Categoria", requiredMode = Schema.RequiredMode.REQUIRED, example = "Backend")
    private List<Curso> cursos = new ArrayList<>();
}
