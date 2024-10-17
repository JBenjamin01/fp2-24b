// LABORATORIO N° 6 - EJERCICIO 1
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES
// TIEMPO: 74 MINUTOS
import java.util.*;
public class VideoJuego3 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Soldado>> tablero = new ArrayList<>();
        ArrayList<Soldado> ejercito1 = new ArrayList<>();
        ArrayList<Soldado> ejercito2 = new ArrayList<>();

        inicializarTablero(tablero);
        inicializarEjercitos(ejercito1, ejercito2, tablero);

        mostrarTablero(tablero);
        mostrarDatosEjercitos(ejercito1, ejercito2);

        ordenamientoInsertionSort(ejercito1);
        mostrarRanking(ejercito1, "1");

        ordenamientoBubbleSort(ejercito2);
        mostrarRanking(ejercito2, "2");
    }

    public static void inicializarTablero(ArrayList<ArrayList<Soldado>> tablero) {
        for (int i = 0; i < 10; i++) {
            ArrayList<Soldado> fila = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                fila.add(null);
            }
            tablero.add(fila);
        }
    }

    public static void inicializarEjercitos(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2,
            ArrayList<ArrayList<Soldado>> tablero) {

        for (int i = 0; i < 2; i++) {
            int n = (int) (Math.random() * 10) + 1;
            for (int j = 0; j < n; j++) {
                int fila, columna;
                do {
                    fila = (int) (Math.random() * 10);
                    columna = (int) (Math.random() * 10);
                } while (tablero.get(fila).get(columna) != null); 

                String nombre = "Soldado" + (i + 1) + "X" + (j + 1);
                int puntosVida = (int) (Math.random() * 5) + 1;
                Soldado soldado = new Soldado(nombre, puntosVida, fila, (char) ('A' + columna));

                if (i == 0) {
                    ejercito1.add(soldado);
                    tablero.get(fila).set(columna, soldado);
                } else {
                    ejercito2.add(soldado);
                    tablero.get(fila).set(columna, soldado);
                }
            }
        }
    }

    public static void mostrarTablero(ArrayList<ArrayList<Soldado>> tablero) {
        System.out.println("Tablero:");
        for (ArrayList<Soldado> fila : tablero) {
            for (Soldado soldado : fila) {
                if (soldado == null)
                    System.out.print("____________\t");
                else
                    System.out.print(soldado.getNombre() + "(" + soldado.getPuntosVida() + ")\t");
            }
            System.out.println();
        }
    }

    public static void mostrarDatosEjercitos(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2) {
        System.out.println("\nDatos del ejército 1:");
        for (Soldado soldado : ejercito1) {
            System.out.println("Nombre: " + soldado.getNombre() + " - Puntos de Vida: " + soldado.getPuntosVida());
        }

        System.out.println("\nDatos del ejército 2:");
        for (Soldado soldado : ejercito2) {
            System.out.println("Nombre: " + soldado.getNombre() + " - Puntos de Vida: " + soldado.getPuntosVida());
        }
    }
    public static void ordenamientoInsertionSort(ArrayList<Soldado> ejercito) {
        int n = ejercito.size();
        for (int i = 1; i < n; ++i) {
            Soldado key = ejercito.get(i);
            int j = i - 1;

            while (j >= 0 && ejercito.get(j).getPuntosVida() < key.getPuntosVida()) {
                ejercito.set(j + 1, ejercito.get(j));
                j = j - 1;
            }
            ejercito.set(j + 1, key);
        }
    }

    public static void ordenamientoBubbleSort(ArrayList<Soldado> ejercito) {
        int n = ejercito.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ejercito.get(j).getPuntosVida() < ejercito.get(j + 1).getPuntosVida()) {
                    Soldado temp = ejercito.get(j);
                    ejercito.set(j, ejercito.get(j + 1));
                    ejercito.set(j + 1, temp);
                }
            }
        }
    }

    public static void mostrarRanking(ArrayList<Soldado> ejercito, String ejercitoNombre) {
        System.out.println("\nRanking Ejército " + ejercitoNombre + ":");
        for (int i = 0; i < ejercito.size(); i++) {
            System.out.println((i + 1) + ". Nombre: " + ejercito.get(i).getNombre() + " - Puntos de Vida: "
                    + ejercito.get(i).getPuntosVida());
        }
    }
}