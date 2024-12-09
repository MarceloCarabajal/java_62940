package org.coderhouse.entidades;

import org.coderhouse.interfaces.Vehiculo;

public class Auto extends Vehiculo {
    @Override
    protected void encender() {

    }

    @Override
    protected void apagar() {

    }

    @Override
    protected void mover() {

    }

    @Override
    public String toString() {
        return "Auto{" +
                "marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", color='" + getColor() + '\'' +
                ", ruedas='" + getRuedas() + '\'' +
                '}';
    }
}
