package com.coderhouse.clase_11.controller;

import com.coderhouse.clase_11.model.Categoria;
import com.coderhouse.clase_11.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
        if(categoriaRepository.existsById(id)){
            Categoria categoria = categoriaRepository.findById(id).get();
            return ResponseEntity.ok(categoria);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
