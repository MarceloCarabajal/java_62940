package com.coderhouse.finalEcommerce.controller;

import com.coderhouse.finalEcommerce.dao.AsignacionCatetoriaProductoDTO;
import com.coderhouse.finalEcommerce.entity.Producto;
import com.coderhouse.finalEcommerce.service.CategoriaService;
import com.coderhouse.finalEcommerce.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos(){
        try {
            List<Producto> productos = productoService.getAllProductos();
            return ResponseEntity.ok(productos);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id){
        try {
            Producto producto = productoService.getProductoById(id);
            return ResponseEntity.ok(producto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto){
        try {
            Producto createdProducto = productoService.saveProducto(producto);
            return ResponseEntity.ok(createdProducto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProductoById(@PathVariable Long id, @RequestBody Producto productoDetails){
        try {
            Producto producto = productoService.updateProducto(id, productoDetails);
            return ResponseEntity.ok(producto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductoById(@PathVariable Long id){
        try {
            productoService.deleteProductoById(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/asignar-categoria")
    public ResponseEntity<Producto> asignarProductoACliente(@RequestBody AsignacionCatetoriaProductoDTO asignacionCatetoriaProductoDTO){
        try {
            Producto updatedProducto = productoService.asignarCategoriaAProducto(
                    asignacionCatetoriaProductoDTO.getProductoId(),
                    asignacionCatetoriaProductoDTO.getCategoriaId()
                    );
            return ResponseEntity.ok(updatedProducto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
