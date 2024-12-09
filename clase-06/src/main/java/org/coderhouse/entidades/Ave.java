package org.coderhouse.entidades;

import org.coderhouse.interfaces.SerVivoInterface;

public class Ave implements SerVivoInterface {

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void emitirSonido() {
        System.out.println(getNombre() + " esta emitiendo un sonido");
    }

    @Override
    public void moverse() {
        System.out.println(getNombre() + " esta volando.");

    }

    @Override
    public void comer() {
        System.out.println(getNombre() + " esta comiendo.");
    }

    @Override
    public boolean estaVivo() {
        return true;
    }
}
