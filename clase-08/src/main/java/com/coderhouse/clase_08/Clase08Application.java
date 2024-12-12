package com.coderhouse.clase_08;

import com.coderhouse.clase_08.dao.DaoFactory;
import com.coderhouse.clase_08.models.Alumno;
import com.coderhouse.clase_08.models.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Clase08Application implements CommandLineRunner {

	@Autowired
	DaoFactory dao;

	public static void main(String[] args) {
		SpringApplication.run(Clase08Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try{

			Curso curso1 = new Curso("Java");
			Curso curso2 = new Curso("ReactJS");
			Curso curso3 = new Curso("JavaScript");
			Curso curso4 = new Curso("C++");

			Alumno alumno1 = new Alumno("Marcelo", "Carabajal", 11111111, "1000");
			Alumno alumno2 = new Alumno("Dario", "Lencina", 22222222, "1001");
			Alumno alumno3 = new Alumno("Sebastian", "Quesada", 33333333, "1002");
			Alumno alumno4 = new Alumno("Martin", "Carabajal", 44444444, "1003");

			dao.persistirAlumno(alumno1);
			dao.persistirAlumno(alumno2);
			dao.persistirAlumno(alumno3);
			dao.persistirAlumno(alumno4);

			dao.persistirCurso(curso1);
			dao.persistirCurso(curso2);
			dao.persistirCurso(curso3);
			dao.persistirCurso(curso4);



		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
}
