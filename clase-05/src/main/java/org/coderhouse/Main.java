package org.coderhouse;

import org.coderhouse.excepciones.PerroException;
import org.coderhouse.mascotas.Mascota;
import org.coderhouse.mascotas.Perro;

public class Main {
    public static void main(String[] args) throws Exception {

        Perro unPerro = new Perro();


        unPerro.setNombre("Firulais");
        unPerro.setColor("beige");
        unPerro.setTamanio("pequeño");
        try {
            unPerro.setEdad(25);
        } catch (PerroException e) {
           // throw new RuntimeException(e);
            System.err.println("Error, "+ e.getMessage());
        }

        unPerro.setRaza("caniche");

        unPerro.caminar();

        Mascota unaMascota = new Mascota();
        unaMascota.setNombre("Simon");
        unaMascota.comer();
        unPerro.ladrar();
        unaMascota.caminar();
        unaMascota.comer();

        System.out.println(unPerro);
    }
}