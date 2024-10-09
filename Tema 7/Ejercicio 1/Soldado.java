import java.util.*;
class Soldado {
    private String nombre;
    private int nivelVida;
    private char columna;
    private int fila;

    // Constructor
    public Soldado(String nombre, char columna, int fila) {
        this.nombre = nombre;
        this.columna = columna;
        this.fila = fila;
        this.nivelVida = generarNivelVida();
    }

    // Método para generar nivel de vida aleatorio entre 1 y 5
    private int generarNivelVida() {
        Random random = new Random();
        return random.nextInt(5) + 1;
    }

    // Método toString para mostrar los datos en el formato requerido
    @Override
    public String toString() {
        return nombre + ", " + nivelVida + " => " + columna + fila;
    }
}