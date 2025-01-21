package com.coderhouse.clase_15.controller;

import com.coderhouse.clase_15.dto.InscripcionDTO;
import com.coderhouse.clase_15.model.Alumno;
import com.coderhouse.clase_15.service.AlumnoService;
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
@RequestMapping("/api/alumnos")
@Tag(name = "Gestión de alumnos", description = "Endpoints para gestionar Alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    @Operation(summary = "Obtener lista de Alumnos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de Alumnos obtenidos correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class))),
            @ApiResponse(responseCode = "404", description = "Error al obtener los Cursos",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<List<Alumno>> getAllAlumnos() {
        try {
            List<Alumno> alumnos = alumnoService.getAllAlumnos();
            return ResponseEntity.ok(alumnos);
        } catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un Alumno por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alumnos obtenido correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class))),
            @ApiResponse(responseCode = "404", description = "Error al obtener el Alumno",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {
        try {
            Alumno alumno = alumnoService.findById(id);
            return ResponseEntity.ok(alumno);
        } catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    @Operation(summary = "Crear un Alumno")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Alumno creado correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class))),
            @ApiResponse(responseCode = "400", description = "Error al intentar crear el Alumno",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno) {
        try {
            Alumno alumnoCreado = alumnoService.saveAlumno(alumno);
            return ResponseEntity.status(HttpStatus.CREATED).body(alumnoCreado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un Alumno por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alumno actualizado correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class))),
            @ApiResponse(responseCode = "404", description = "Error al intentar editar un Alumno",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<Alumno> updateAlumnoById(@PathVariable Long id, @RequestBody Alumno alumnoModificado){
        try {
            Alumno updateAlumno = alumnoService.updateAlumnoById(id, alumnoModificado);
            return ResponseEntity.ok(updateAlumno);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); //404
        } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Alumno por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Alumno eliminado correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class))),
            @ApiResponse(responseCode = "400", description = "Error al intentar eliminar un Alumno, alumno no existe",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<Void> deleteAlumnoById(@PathVariable Long id){
        try {
            alumnoService.deleteAlumnoById(id);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); //404
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/inscribir")
    @Operation(summary = "Inscribir un alumno a un curso usando DTO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alumno inscripto correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Alumno.class))),
            @ApiResponse(responseCode = "404", description = "Error al intentar inscribir un alumno",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<Alumno> inscribirAlumboACursos(@RequestBody InscripcionDTO inscripcionDTO){
        try {
            Alumno alumno = alumnoService.inscribirAlumnoACursos(inscripcionDTO);
            return ResponseEntity.ok(alumno);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }   catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
