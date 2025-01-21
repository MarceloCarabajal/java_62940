package com.coderhouse.clase_15.controller;

import com.coderhouse.clase_15.dto.TimeResponseDTO;
import com.coderhouse.clase_15.service.FechaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fecha")
public class FechaController {

    @Autowired
    private FechaService fechaService;

    private int contadorDeInvocaciones = 0;

    private String ultimaFechaMostrada = "N/A";

    @GetMapping
    public ResponseEntity<String> obtenerFechaActual(){
        contadorDeInvocaciones++;

        TimeResponseDTO fechaActual = fechaService.obtenerFechaActual();

        if (fechaActual != null) {
            String mensaje = String.format(
                    "Fecha Actual: %s %s %d, %d\nHora: %s\nNúmero de invocaciones: %d\nÚltima fecha mostrada: %s",
                    fechaActual.getDayOfWeek(),
                    fechaActual.getMonth(),
                    fechaActual.getDay(),
                    fechaActual.getYear(),
                    fechaActual.getTime(),
                    contadorDeInvocaciones,
                    ultimaFechaMostrada
            );

                    ultimaFechaMostrada = String.format("%s %s %d, %d %s",
                            fechaActual.getDayOfWeek(),
                            fechaActual.getMonth(),
                            fechaActual.getDay(),
                            fechaActual.getYear(),
                            fechaActual.getTime()
                            );
                    return ResponseEntity.ok(mensaje);
        } else {
            return ResponseEntity.badRequest().body("No se pudo obtener la fecha actual");
        }
    }

}
