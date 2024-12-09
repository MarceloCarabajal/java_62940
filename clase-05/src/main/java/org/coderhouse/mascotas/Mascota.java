package org.coderhouse.mascotas;

import org.coderhouse.excepciones.PerroException;

public class Mascota {

    private static final int EDAD_MAXIMA = 15;

    String mensajeDeError = "El Perro no vive más de " + EDAD_MAXIMA + " años de edad.!";

    // Variables de instancia o Atributos del Objeto
    private String nombre;
    private String color;
    private String tamanio;
    private Integer edad;

    //Constructor

    public Mascota() {
    }

    public Mascota(String mensajeDeError, String nombre, String color, String tamanio, Integer edad) {
        this.mensajeDeError = mensajeDeError;
        this.nombre = nombre;
        this.color = color;
        this.tamanio = tamanio;
        this.edad = edad;
    }

    public void caminar() {
        System.out.println("La mascota " + getNombre() + " esta Caminando.!");
    }

    public void comer() {
        System.out.println("La mascota " + getNombre() + " esta Comiendo.!");
    }

    public String getMensajeDeError() {
        return this.mensajeDeError;
    }

    public void setMensajeDeError(String mensajeDeError) {
        this.mensajeDeError = mensajeDeError;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTamanio() {
        return this.tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public Integer getEdad() {
        return this.edad;
    }

    public void setEdad(Integer edad) throws PerroException {
        if(edad > EDAD_MAXIMA){
            throw new PerroException(mensajeDeError);
        }
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "mensajeDeError='" + mensajeDeError + '\'' +
                ", nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                ", tamanio='" + tamanio + '\'' +
                ", edad=" + edad +
                '}';
    }
}
