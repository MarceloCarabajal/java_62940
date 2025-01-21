package com.coderhouse.clase_15.repository;

import com.coderhouse.clase_15.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
