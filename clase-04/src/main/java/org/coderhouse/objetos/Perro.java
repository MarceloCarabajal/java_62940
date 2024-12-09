package org.coderhouse.objetos;

public class Perro {

    // Definimos una constante o VAriable de clase
    private static final int EDAD_MAXIMA = 20;

    String mensajeDeError = "El perro no vivie mas de " + EDAD_MAXIMA + " años de edad.";

    // Variables de instancia o Atributos del objeto
    private String nombre, raza, color, tamanio;
    private int edad;

    // Metodos
    public void ladrar(){
        System.out.println("Soy un perro y estoy ladrando");
    }
    public void comer(){
        System.out.println("Soy un perro y estoy comiendo");
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return this.raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTamanio() {
        return this.tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) throws Exception {
        if (edad > EDAD_MAXIMA){
            throw new Exception(mensajeDeError);
        } else {
            this.edad = edad;
        }
    }

    @Override
    public String toString() {
        return "Perro{" +
                "nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", color='" + color + '\'' +
                ", tamanio='" + tamanio + '\'' +
                ", edad=" + edad +
                '}';
    }
}
