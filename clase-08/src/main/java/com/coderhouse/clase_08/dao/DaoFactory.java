package com.coderhouse.clase_08.dao;

import com.coderhouse.clase_08.models.Alumno;
import com.coderhouse.clase_08.models.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DaoFactory {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void persistirAlumno(Alumno alumno){
        em.persist(alumno);
    }

    @Transactional
    public void persistirCurso(Curso curso){
        em.persist(curso);
    }
}
