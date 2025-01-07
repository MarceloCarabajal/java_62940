package com.coderhouse.finalEcommerce.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "compradores")
public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental
    private Long Id;

    private String nombre;

    private String apellido;

    private int edad;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String dni;

    @Column(name = "num_comprador")
    private int numComprador;

    @ManyToMany(mappedBy = "compradores", fetch = FetchType.EAGER)
    private List<Producto> productos = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime createdAt;

    public Comprador() {
    }

    public Comprador(String nombre, String apellido, int edad, String email, String dni, int numComprador) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
        this.dni = dni;
        this.numComprador = numComprador;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getNumComprador() {
        return numComprador;
    }

    public void setNumComprador(int numComprador) {
        this.numComprador = numComprador;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Comprador{" +
                "Id=" + Id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", email='" + email + '\'' +
                ", dni='" + dni + '\'' +
                ", numComprador='" + numComprador + '\'' +
                ", productos=" + productos +
                ", createdAt=" + createdAt +
                '}';
    }
}
