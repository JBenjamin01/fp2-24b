import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class VideoJuego {
    private static final String[] REINOS = {"Inglaterra", "Francia", "Sacro Imperio Germánico", "Castilla – Aragón", "Moros"};
    private static final int TAM_TABLERO = 10;
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Generar tablero inicial con los ejércitos de dos reinos
        String reino1 = REINOS[random.nextInt(REINOS.length)];
        String reino2 = REINOS[random.nextInt(REINOS.length)];
        while (reino2.equals(reino1)) { // Asegurar que los reinos sean diferentes
            reino2 = REINOS[random.nextInt(REINOS.length)];
        }

        ArrayList<Soldado> ejercitoReino1 = generarEjercitos(reino1);
        ArrayList<Soldado> ejercitoReino2 = generarEjercitos(reino2);
        ArrayList<ArrayList<Soldado>> tablero = generarTablero(ejercitoReino1, ejercitoReino2);

        System.out.println("=== INICIO DEL JUEGO ===");
        System.out.println("Reino 1: " + reino1 + " | Reino 2: " + reino2);
        mostrarTablero(tablero);

        // Movimiento y lógica del juego
        while (true) {
            System.out.println("\nTurno del Reino 1");
            moverEjercito(tablero, ejercitoReino1, reino1, reino2);

            System.out.println("\nTurno del Reino 2");
            moverEjercito(tablero, ejercitoReino2, reino2, reino1);

            // Revisar si hay un ganador
            if (ejercitoReino1.isEmpty() || ejercitoReino2.isEmpty()) {
                String ganador = ejercitoReino1.isEmpty() ? reino2 : reino1;
                System.out.println("¡El ganador es: " + ganador + "!");
                break;
            }
        }
    }

    // Generar soldados para un reino
    public static ArrayList<Soldado> generarEjercitos(String reino) {
        ArrayList<Soldado> ejercito = new ArrayList<>();
        int numSoldados = random.nextInt(10) + 1; // Generar entre 1 y 10 soldados
        for (int i = 0; i < numSoldados; i++) {
            Soldado soldado = new Soldado(reino);
            ejercito.add(soldado);
        }
        return ejercito;
    }

    // Generar el tablero inicial
    public static ArrayList<ArrayList<Soldado>> generarTablero(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2) {
        ArrayList<ArrayList<Soldado>> tablero = new ArrayList<>();
        for (int i = 0; i < TAM_TABLERO; i++) {
            ArrayList<Soldado> fila = new ArrayList<>();
            for (int j = 0; j < TAM_TABLERO; j++) {
                fila.add(null); // Casillas vacías inicialmente
            }
            tablero.add(fila);
        }

        // Colocar soldados de Reino 1
        colocarSoldadosEnTablero(tablero, ejercito1);

        // Colocar soldados de Reino 2
        colocarSoldadosEnTablero(tablero, ejercito2);

        return tablero;
    }

    // Colocar los soldados en el tablero
    public static void colocarSoldadosEnTablero(ArrayList<ArrayList<Soldado>> tablero, ArrayList<Soldado> ejercito) {
        for (Soldado soldado : ejercito) {
            while (true) {
                int fila = random.nextInt(TAM_TABLERO);
                int columna = random.nextInt(TAM_TABLERO);
                if (tablero.get(fila).get(columna) == null) {
                    tablero.get(fila).set(columna, soldado);
                    break;
                }
            }
        }
    }

    // Mostrar tablero
    public static void mostrarTablero(ArrayList<ArrayList<Soldado>> tablero) {
        System.out.println("Tablero:");
        for (int i = 0; i < tablero.size(); i++) {
            for (int j = 0; j < tablero.get(i).size(); j++) {
                Soldado soldado = tablero.get(i).get(j);
                if (soldado == null) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" " + soldado.getReino().charAt(0) + " "); // Mostrar la inicial del reino
                }
            }
            System.out.println();
        }
    }

    // Mover ejército
    public static void moverEjercito(ArrayList<ArrayList<Soldado>> tablero, ArrayList<Soldado> ejercito, String reino, String reinoEnemigo) {
        mostrarTablero(tablero);
        System.out.println("Seleccione la posición del soldado a mover (fila columna):");
        int fila = scanner.nextInt();
        int columna = scanner.nextInt();

        // Verificar si hay un soldado en la posición seleccionada
        Soldado soldado = tablero.get(fila).get(columna);
        if (soldado == null || !soldado.getReino().equals(reino)) {
            System.out.println("Posición inválida. Intente de nuevo.");
            return;
        }

        System.out.println("Seleccione la nueva posición (fila columna):");
        int nuevaFila = scanner.nextInt();
        int nuevaColumna = scanner.nextInt();

        // Mover soldado
        tablero.get(fila).set(columna, null);
        tablero.get(nuevaFila).set(nuevaColumna, soldado);

        // Verificar si hay una batalla
        Soldado soldadoEnemigo = tablero.get(nuevaFila).get(nuevaColumna);
        if (soldadoEnemigo != null && !soldadoEnemigo.getReino().equals(reino)) {
            System.out.println("¡Batalla entre " + reino + " y " + reinoEnemigo + "!");
            iniciarBatalla(soldado, soldadoEnemigo);
        }
    }

    // Iniciar batalla
    public static void iniciarBatalla(Soldado soldado1, Soldado soldado2) {
        System.out.println("Opción 1: Batalla automática\nOpción 2: Batalla manual");
        int opcion = scanner.nextInt();
        if (opcion == 1) {
            // Resolución automática (comparar puntos de vida)
            if (soldado1.getPuntosVida() > soldado2.getPuntosVida()) {
                System.out.println("¡" + soldado1.getReino() + " gana la batalla!");
            } else if (soldado1.getPuntosVida() < soldado2.getPuntosVida()) {
                System.out.println("¡" + soldado2.getReino() + " gana la batalla!");
            } else {
                System.out.println("¡Empate en la batalla!");
            }
        } else {
            // Resolución manual (a implementar si es necesario)
            System.out.println("¡Resolución manual no implementada!");
        }
    }
}