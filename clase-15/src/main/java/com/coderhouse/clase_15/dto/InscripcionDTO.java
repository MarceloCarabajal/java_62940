package com.coderhouse.clase_15.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Schema(description = "Modelo de inscripción de Alumnos DTO", title = "Inscripciones DTO")
public class InscripcionDTO {

    @Schema(description = "Alumno ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long alumnoId;

    @Schema(description = "Listdo de IDs de Cursos", requiredMode = Schema.RequiredMode.REQUIRED, example = "['1', '2', '3']")
    private List<Long> cursosId;
}
