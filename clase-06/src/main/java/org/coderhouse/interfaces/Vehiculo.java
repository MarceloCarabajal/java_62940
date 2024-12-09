package org.coderhouse.interfaces;

public abstract class Vehiculo {

    protected String marca;
    protected String modelo;
    protected String color;
    protected int ruedas;

    protected abstract void encender();
    protected abstract void apagar();
    protected abstract void mover();

    public void mostrarCantRuedas(){
        System.out.println("Mi vehiculo marca " + getMarca() + " tiene " + getRuedas() + " ruedas." );
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }
}
