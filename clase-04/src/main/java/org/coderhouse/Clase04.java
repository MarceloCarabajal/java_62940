package org.coderhouse;

import org.coderhouse.objetos.Perro;

public class Clase04 {
    public static void main(String[] args) throws Exception {

        Perro perro1 = new Perro();

        perro1.setNombre("Simon");
        perro1.setColor("Blanco");
        perro1.setRaza("Caniche");
        perro1.setTamanio("Mediano");
        perro1.setEdad(55);

        System.out.println(perro1);
    }
}