import java.util.*;
public class SistemaAcademico {
    public static void main(String[] args) {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        Random rand = new Random();
        
        int numEstudiantes = rand.nextInt(31) + 20;  // 20 a 50 estudiantes

        // Contadores de cada tipo de estudiante
        int contadorPregrado = 0;
        int contadorPostgrado = 0;

        double promedioPregrado = 0;
        double promedioPostgrado = 0;

        // Crear estudiantes aleatorios
        for (int i = 0; i < numEstudiantes; i++) {
            String nombre = "Estudiante N°" + (i + 1);  // Nombre genérico para cada estudiante
            Estudiante estudiante;
            
            if (rand.nextBoolean()) {
                estudiante = new EstudiantePregrado(nombre);
                contadorPregrado++;
            } else {
                estudiante = new EstudiantePostgrado(nombre);
                contadorPostgrado++;
            }
            
            estudiante.calcularNotaFinal();
            estudiantes.add(estudiante);
        }

        // Mostrar los detalles de todos los estudiantes
        for (Estudiante est : estudiantes) {
            est.mostrarDetalles();
        }

        // Calcular los promedios
        for (Estudiante est : estudiantes) {
            if (est instanceof EstudiantePregrado) {
                promedioPregrado += est.obtenerNotaFinal();
            } else if (est instanceof EstudiantePostgrado) {
                promedioPostgrado += est.obtenerNotaFinal();
            }
        }

        promedioPregrado /= contadorPregrado;
        promedioPostgrado /= contadorPostgrado;

        // Mostrar resultados finales
        System.out.println("\nCantidad de Estudiantes Pregrado: " + contadorPregrado);
        System.out.println("Promedio Final Pregrado: " + promedioPregrado);

        System.out.println("\nCantidad de Estudiantes Postgrado: " + contadorPostgrado);
        System.out.println("Promedio Final Postgrado: " + promedioPostgrado);

        // Comparar cuál tipo de estudiante fue mejor
        if (promedioPregrado > promedioPostgrado) {
            System.out.println("\nLos estudiantes de Pregrado fueron mejores.");
        } else if (promedioPostgrado > promedioPregrado) {
            System.out.println("\nLos estudiantes de Postgrado fueron mejores.");
        } else {
            System.out.println("\nAmbos tipos de estudiantes tuvieron el mismo promedio.");
        }
    }
}