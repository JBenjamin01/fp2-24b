import java.io.*;

public class Alumno implements Serializable {
    private String cui;
    private String nombre;
    private int edad;

    public Alumno(String cui, String nombre, int edad) {
        this.cui = cui;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getCui() {
        return cui;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "CUI: " + cui + ", Nombre: " + nombre + ", Edad: " + edad;
    }
}
