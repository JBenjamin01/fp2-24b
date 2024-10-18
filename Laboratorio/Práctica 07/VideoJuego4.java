// LABORATORIO N° 7 - EJERCICIO 1
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES
// TIEMPO: 81 MINUTOS
import java.util.*;
public class VideoJuego4 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Soldado>> tablero = new ArrayList<>();
        ArrayList<Soldado> ejercito1 = new ArrayList<>();
        ArrayList<Soldado> ejercito2 = new ArrayList<>();

        inicializarTablero(tablero);
        inicializarEjercitos(ejercito1, ejercito2, tablero);

        mostrarTablero(tablero, ejercito1, ejercito2);
        mostrarDatosEjercitos(ejercito1, ejercito2);

        Soldado soldadoMayorVidaE1 = obtenerSoldadoMayorVida(ejercito1);
        Soldado soldadoMayorVidaE2 = obtenerSoldadoMayorVida(ejercito2);
    
        System.out.println("\nSoldado con mayor vida del ejercito 1:");
        mostrarDatosSoldado(soldadoMayorVidaE1);
    
        System.out.println("\nSoldado con mayor vida del ejercito 2:");
        mostrarDatosSoldado(soldadoMayorVidaE2);

        ordenamientoInsertionSort(ejercito1);
        mostrarRanking(ejercito1, "1");

        ordenamientoBubbleSort(ejercito2);
        mostrarRanking(ejercito2, "2");

        String resultadoBatalla = determinarGanador(ejercito1, ejercito2);
        System.out.println("\nResultado de la batalla:");
        System.out.println(resultadoBatalla);
    }

    public static void inicializarTablero(ArrayList<ArrayList<Soldado>> tablero) {
        for (int i = 0; i < 10; i++) {
            ArrayList<Soldado> fila = new ArrayList<>();
            for (int j = 0; j < 10; j++) 
                fila.add(null);
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

    public static void mostrarTablero(ArrayList<ArrayList<Soldado>> tablero, ArrayList<Soldado> ejercito1, 
                                        ArrayList<Soldado> ejercito2) {
        System.out.println("Tablero de la batalla:"
                            + "\nLas unidades del ejercito 1 estaran con sus puntos de vida entre corchetes ([x])." 
                            + "\nLas del ejercito 2 con sus puntos de vida entre signos menor y mayor que (<x>):");
        System.out.println("\n           A     B     C     D     E     F     G     H     I     J");
        System.out.println();
        System.out.println("        -------------------------------------------------------------");

        for (int i = 0; i < tablero.size(); i++) {
            System.out.print(i + 1 + "\t| ");
            for (int j = 0; j < tablero.get(i).size(); j++) {
                Soldado soldado = tablero.get(i).get(j);
                if (soldado == null) {
                    System.out.print("    | ");
                } else {
                    if (ejercito1.contains(soldado)) {
                        System.out.print("[" + soldado.getPuntosVida() + "] | ");
                    } else if (ejercito2.contains(soldado)) {
                        System.out.print("<" + soldado.getPuntosVida() + "> | ");
                    } else {
                        System.out.print(soldado.getPuntosVida() + " | ");
                    }
                }
            }
            System.out.println();
            System.out.println("        -------------------------------------------------------------");
        }
    }

    public static void mostrarDatosEjercitos(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2) {
        System.out.println("\nDatos del ejército 1:");
        for (Soldado soldado : ejercito1)
            System.out.println("Nombre: " + soldado.getNombre() + " - Puntos de Vida: " + soldado.getPuntosVida() 
                                + " - Ubicacion: " + (soldado.getFila() + 1) + soldado.getColumna());

        System.out.println("\nDatos del ejército 2:");
        for (Soldado soldado : ejercito2)
            System.out.println("Nombre: " + soldado.getNombre() + " - Puntos de Vida: " + soldado.getPuntosVida() 
                                + " - Ubicacion: " + (soldado.getFila() + 1) + soldado.getColumna());
    }

    public static Soldado obtenerSoldadoMayorVida(ArrayList<Soldado> ejercito) {
        Soldado mayorVida = null;
        int maxPuntosVida = Integer.MIN_VALUE;
        for (Soldado soldado : ejercito) {
            if (soldado.getPuntosVida() > maxPuntosVida) {
                maxPuntosVida = soldado.getPuntosVida();
                mayorVida = soldado;
            }
        }
        return mayorVida;
    }

    public static void mostrarDatosSoldado(Soldado soldado) {
        if (soldado != null)
            System.out.println("- Nombre: " + soldado.getNombre() + "\n- Puntos de Vida: " + soldado.getPuntosVida() 
                                + "\n- Ubicacion: " + (soldado.getFila() + 1) + soldado.getColumna());
        else 
            System.out.println("No hay soldado.");
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
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (ejercito.get(j).getPuntosVida() < ejercito.get(j + 1).getPuntosVida()){
                    Soldado temp = ejercito.get(j);
                    ejercito.set(j, ejercito.get(j + 1));
                    ejercito.set(j + 1, temp);
                }
    }

    public static void mostrarRanking(ArrayList<Soldado> ejercito, String ejercitoNombre) {
        System.out.println("\nRanking Ejército " + ejercitoNombre + ":");
        for (int i = 0; i < ejercito.size(); i++)
            System.out.println((i + 1) + ". Nombre: " + ejercito.get(i).getNombre() + " - Puntos de Vida: "
                    + ejercito.get(i).getPuntosVida());
    }

    public static String determinarGanador(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2) {
        int puntosVidaEjercito1 = 0;
        int puntosVidaEjercito2 = 0;
    
        for (Soldado soldado : ejercito1)
            puntosVidaEjercito1 += soldado.getPuntosVida();
    
        for (Soldado soldado : ejercito2) 
            puntosVidaEjercito2 += soldado.getPuntosVida();
        
        if (puntosVidaEjercito1 > puntosVidaEjercito2) 
            return "El ejército 1 es el ganador con " + puntosVidaEjercito1 + " puntos de vida.";
        else if (puntosVidaEjercito2 > puntosVidaEjercito1) 
            return "El ejército 2 es el ganador con " + puntosVidaEjercito2 + " puntos de vida.";
        else 
            return "La batalla termina en empate, ambos ejércitos tienen " + puntosVidaEjercito1 + " puntos de vida.";
    }
}