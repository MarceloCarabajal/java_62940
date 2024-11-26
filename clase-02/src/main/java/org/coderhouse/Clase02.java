package org.coderhouse;

public class Clase02 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        
        //Datos aleatorios
        double randomNumber = 0.0d;
        
        randomNumber = Math.random();

        System.out.println("randomNumber = " + randomNumber);

        int random = 0;
        int minimo = 1;
        int maximo = 100;

        int rango = maximo - minimo + 1;
        random = (int) (Math.random() * rango) + minimo;
        System.out.println("random = " + random);

        final double PI =  Math.PI;
        System.out.println("PI = " + String.format("%.2f", PI));
    }
}