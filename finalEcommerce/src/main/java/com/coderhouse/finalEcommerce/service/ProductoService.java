package com.coderhouse.finalEcommerce.service;

import com.coderhouse.finalEcommerce.entity.Categoria;
import com.coderhouse.finalEcommerce.entity.Producto;
import com.coderhouse.finalEcommerce.error.AsignacionCategoriaException;
import com.coderhouse.finalEcommerce.repository.CategoriaRepository;
import com.coderhouse.finalEcommerce.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }

    public Producto getProductoById(Long id){
        return productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encuentra producto con ID: " + id));
    }

    @Transactional
    public Producto saveProducto(Producto producto){
        return productoRepository.save(producto);
    }

    @Transactional
    public Producto createProducto(Producto producto){
        return productoRepository.save(producto);
    }

    @Transactional
    public Producto updateProducto(Long id, Producto productoDetails){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encuentra producto con ID: " + id));

        producto.setTitulo(productoDetails.getTitulo());
        producto.setDescripcion(productoDetails.getDescripcion());
        producto.setPrecio(productoDetails.getPrecio());
        producto.setStock(productoDetails.getStock());
        producto.setClientes(productoDetails.getClientes());
        producto.setCategoria(productoDetails.getCategoria());

        return productoRepository.save(producto);
    }

    public void deleteProductoById(Long id){
        if(productoRepository.existsById(id)){
            productoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No se encuentra producto con ID: " + id);
        }
    }

    @Transactional
    public Producto addCategoryToProduct(Long productoId, Long categoriaId) throws AsignacionCategoriaException {
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new AsignacionCategoriaException("No se encuentra categoria con ID: " + categoriaId));
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new AsignacionCategoriaException("No se encuentra producto con ID: " + productoId));

        producto.setCategoria(categoria);

        return productoRepository.save(producto);
    }
}
