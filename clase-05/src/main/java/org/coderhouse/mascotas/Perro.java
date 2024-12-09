package org.coderhouse.mascotas;

public class Perro extends Mascota{

    private String raza;

    public void ladrar(){
        System.out.println("El perro " + getNombre() + " esta ladrando.");
    }

    @Override
    public void caminar() {
        System.out.println("El perro " + getNombre() + " esta Caminando.!");
    }

    public String getRaza() {
        return this.raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "raza='" + raza + '\'' +
                '}';
    }
}
