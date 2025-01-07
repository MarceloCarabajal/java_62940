package com.coderhouse.clase_11.service;

import com.coderhouse.clase_11.model.Alumno;
import com.coderhouse.clase_11.repository.AlumnoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> getAllAlumnos(){
        return alumnoRepository.findAll();
    }

    public Alumno findById(Long id) {
        return alumnoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
    }

    @Transactional
    public Alumno saveAlumno(Alumno alumno){
        return alumnoRepository.save(alumno);
    }

    @Transactional
    public Alumno updateAlumnoById(Long id, Alumno alumnoDetails) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
                alumno.setNombre(alumno.getNombre());
                alumno.setApellido(alumnoDetails.getApellido());

                if(alumnoDetails.getDni() != 0) {
                    alumno.setDni(alumnoDetails.getDni());
                }

                if(alumnoDetails.getLegajo() != null && !alumnoDetails.getLegajo().isEmpty()) {
                    alumno.setLegajo(alumnoDetails.getLegajo());
                }
                return alumnoRepository.save(alumno);
    }

    public void deleteAlumnoById(Long id) {
        if(!alumnoRepository.existsById(id)) {
            throw new IllegalArgumentException("Alumno no encontrado");
        }

        alumnoRepository.deleteById(id);
    }
}