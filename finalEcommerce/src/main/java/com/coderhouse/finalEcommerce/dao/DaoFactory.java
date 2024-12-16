package com.coderhouse.finalEcommerce.dao;

import com.coderhouse.finalEcommerce.models.Comprador;
import com.coderhouse.finalEcommerce.models.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DaoFactory {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void persisirComprador(Comprador comprador){
        em.persist(comprador);
    }

    @Transactional
    public void persisirProducto(Producto producto){
        em.persist(producto);
    }
}
