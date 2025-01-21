package com.coderhouse.clase_15.controller;

import com.coderhouse.clase_15.dto.AsignacionCategoriaCursoDTO;
import com.coderhouse.clase_15.model.Curso;
import com.coderhouse.clase_15.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@Tag(name = "Gestion de Cursos", description = "Endpoints para gestionar Cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    @Operation(summary = "Obtener lista de Cursos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de Cursos obtenida correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Curso.class))),
            @ApiResponse(responseCode = "404", description = "Error al obtener los Cursos",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<List<Curso>> getAllCursos() {
        try {
            List<Curso> cursos = cursoService.getAllCursos();
            return ResponseEntity.ok(cursos);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un Curso por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso obtenido correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Curso.class))),
            @ApiResponse(responseCode = "404", description = "Error al obtener el Curso por ID",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        try {
            Curso curso = cursoService.getCursoById(id);
            return ResponseEntity.ok(curso);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    @Operation(summary = "Crear un Curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Curso creado correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Curso.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
        try {
            Curso createdCurso = cursoService.createCurso(curso);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCurso);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un Curso por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso actualizado correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Curso.class))),
            @ApiResponse(responseCode = "400", description = "Error al obtener el Curso por ID",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso cursoDetails) {
        try {
            Curso updatedCurso = cursoService.updateCurso(id, cursoDetails);
            return ResponseEntity.ok(updatedCurso);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un Curso por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Curso eliminado correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Curso.class))),
            @ApiResponse(responseCode = "404", description = "Error al obtener el Curso por ID",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        try {
            cursoService.deleteCursoById(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/asignar-categoria")
    @Operation(summary = "Asignar Categoría a un Curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoría asignada correctamente",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Curso.class))}),
            @ApiResponse(responseCode = "404", description = "Error al intentar obtener el Curso o Categoría",
                    content =  @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<Curso> asignarCategoriaACurso(@RequestBody AsignacionCategoriaCursoDTO asignacionCategoriaCursoDTO) {
        try {
            Curso cursoActualizado = cursoService.asignarCategoriaACurso(
                    asignacionCategoriaCursoDTO.getCursoId(),
                    asignacionCategoriaCursoDTO.getCategoriaId()
            );
            return ResponseEntity.ok(cursoActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

