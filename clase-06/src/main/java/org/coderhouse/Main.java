package org.coderhouse;

import org.coderhouse.entidades.Auto;
import org.coderhouse.entidades.Ave;
import org.coderhouse.entidades.Gato;
import org.coderhouse.entidades.Perro;
import org.coderhouse.interfaces.SerVivoInterface;
import org.coderhouse.sobrecarga.Impresora;

public class Main {
    public static void main(String[] args) {

        Perro miPerro = new Perro();

        miPerro.setNombre("Zeus");
        miPerro.setEdad(5);
        miPerro.setRaza("Caniche");
        miPerro.setVivo(true);

        miPerro.comer();
        miPerro.emitirSonido();
        miPerro.estaVivo();
        miPerro.dormir();
        miPerro.jugar();

        System.out.println("Mi perro " + miPerro.getNombre() + " esta vivo?: " + miPerro.estaVivo());
        System.out.println("La ubicacion de " + miPerro.getNombre() + " es en " + SerVivoInterface.UBICACION);

        Gato miGata = new Gato();

        miGata.setNombre("Nala");
        miGata.comer();
        miGata.emitirSonido();
        miGata.estaVivo();
        miGata.dormir();
        miGata.jugar();

        Ave miAve = new Ave();
        miAve.setNombre("Tweety");
        miAve.moverse();
        miAve.emitirSonido();
        miAve.estaVivo();

        Auto miAuto = new Auto();

        miAuto.setMarca("Peugeot");
        miAuto.setModelo("208");
        miAuto.setRuedas(4);
        miAuto.setColor("blanco");
        System.out.println(miAuto);

        Impresora miImpresora = new Impresora();
        miImpresora.imprimir();
        miImpresora.imprimir(3, 30);
        miImpresora.imprimir("River Plate");

        int[] enteros = {1, 2, 3, 4, 5, 6};
        miImpresora.imprimir(enteros);

    }
}