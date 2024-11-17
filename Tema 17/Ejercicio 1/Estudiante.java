import java.util.*;

public abstract class Estudiante {
    protected String nombre;
    protected int[] notas;
    protected double notaFinal;

    // Constructor
    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.notas = new int[3];
        generarNotasAleatorias();
    }

    // Método para generar notas aleatorias entre 0 y 20
    private void generarNotasAleatorias() {
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            this.notas[i] = rand.nextInt(21); // Nota aleatoria entre 0 y 20
        }
    }

    // Método abstracto para calcular la nota final
    public abstract void calcularNotaFinal();

    // Obtener la nota final
    public double obtenerNotaFinal() {
        return this.notaFinal;
    }

    // Obtener el nombre del estudiante
    public String obtenerNombre() {
        return this.nombre;
    }

    // Obtener las notas
    public int[] obtenerNotas() {
        return this.notas;
    }

    // Método para mostrar los detalles del estudiante
    public void mostrarDetalles() {
        System.out.printf("Nombre: %s\n", nombre);
        System.out.printf("Notas: %d, %d, %d\n", notas[0], notas[1], notas[2]);
        System.out.printf("Nota Final: %.2f\n", notaFinal);
    }
}
