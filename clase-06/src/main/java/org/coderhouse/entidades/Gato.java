package org.coderhouse.entidades;

public class Gato extends AnimalTerrestre{
    @Override
    public void emitirSonido() {
        System.out.println(getNombre() + " esta maullando.");
    }

    @Override
    public void moverse() {
        System.out.println(getNombre() + " se esta moviendo.");
    }

    @Override
    public void comer() {
        System.out.println(getNombre() + " esta comiendo.");

    }

    @Override
    public boolean estaVivo() {
        return true;
    }

    @Override
    public void dormir() {
        System.out.println(getNombre() + " esta durmiendo.");

    }

    @Override
    public void respirar() {
        System.out.println(getNombre() + " esta respirando.");
    }

    @Override
    public void jugar() {
        System.out.println(getNombre() + " esta jugando.");
    }
}
