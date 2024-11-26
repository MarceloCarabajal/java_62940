package org.coderhouse.arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arrays {
    public static void main(String[] args) {

        List<String> listaNombres = new ArrayList<>();
        List<String> listaNombres2 = new ArrayList<>();

        listaNombres.add("Marcelo");
        listaNombres.add("Martin");
        listaNombres.add("Jorge");
        listaNombres.add("Mercedes");

        listaNombres2.add("Nala");
        listaNombres2.add("Simon");
        listaNombres2.add("Zeus");

        System.out.println("listaNombres.size() = " + listaNombres.size());

        listaNombres.addAll(listaNombres2);

        System.out.println("listaNombres.size() = " + listaNombres.size());
        System.out.println("listaNombres2.containsAll(listaNombres2) = " + listaNombres2.containsAll(listaNombres2));

        listaNombres.remove(4);
        System.out.println("listaNombres2.containsAll(listaNombres2) = " + listaNombres2.containsAll(listaNombres2));
        
        for (String nombre : listaNombres){
            System.out.println("nombre = " + nombre);
        }

        System.out.println("------------------");

        for (int i = 0; i < listaNombres.size(); i++) {
            System.out.println("listaNombres = " + listaNombres.get(i));
        }

        System.out.println("listaNombres.isEmpty() = " + listaNombres.isEmpty());

        System.out.println("forEach:");
        listaNombres2.forEach(nombre -> {
            System.out.println("Nombre: " + nombre);
        });

        listaNombres.removeAll(listaNombres);
        //listaNombres.clear(); // para este caso, es mejor opcion el clear
        System.out.println("listaNombres.isEmpty() = " + listaNombres.isEmpty());

        System.out.println("Iterators:");
        Iterator<String> iterator = listaNombres2.iterator();
        // Ciclos por condicion
        while (iterator.hasNext()){
            String nombre = iterator.next();
            System.out.println("Nombre: " + nombre);
            iterator.remove();
        }



    }
}