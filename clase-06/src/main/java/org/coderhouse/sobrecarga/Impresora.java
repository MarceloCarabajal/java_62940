package org.coderhouse.sobrecarga;

public class Impresora {

    public void imprimir(){
        System.out.println("imprimiendo el numero 1: " + numero1);
    }

    public void imprimir(int numero1, int numero2){
        System.out.println("imprimiendo el numero 1: " + numero1 + " y el numero 2: " + numero2);
    }

    public void imprimir(String palabra){
        System.out.println("imprimiendo palabra: " + palabra);
    }

    public void imprimir(int[] numeros){
        System.out.println("imprimiendo array de numeros");
        for(int numero : numeros){
            System.out.println("Numero " + numero + "\n");
        }
    }
}
