// LABORATORIO N° 9
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES
// TIEMPO: 79 MINUTOS
import java.util.*;
public class VideoJuego {
    public static void main(String[] args) {
        ArrayList<ArrayList<Soldado>> tablero = new ArrayList<>();
        ArrayList<Soldado> e1 = new ArrayList<>();
        ArrayList<Soldado> e2 = new ArrayList<>();

        inicializarTablero(tablero);
        inicializarEjercitos(e1, e2, tablero);

        mostrarTablero(tablero, e1, e2);

        System.out.println("\nDatos del ejército 1:");
        mostrarDatosEjercito(e1);
        System.out.println("\nDatos del ejército 2:");
        mostrarDatosEjercito(e2);

        Soldado soldadoMayorVidaE1 = obtenerSoldadoMayorVida(e1);
        Soldado soldadoMayorVidaE2 = obtenerSoldadoMayorVida(e2);
    
        System.out.println("\nSoldado con mayor vida del ejército 1:\n" + soldadoMayorVidaE1);
        System.out.println("\nSoldado con mayor vida del ejército 2:\n" + soldadoMayorVidaE2);

        double promedioVidaE1 = calcularPromedioVida(e1);
        double promedioVidaE2 = calcularPromedioVida(e2);

        System.out.println("\nPromedio de puntos de vida del ejército 1: " + promedioVidaE1);
        System.out.println("Promedio de puntos de vida del ejército 2: " + promedioVidaE2);

        ordenamientoInsertionSort(e1);
        System.out.println("\nRanking de soldados del ejército 1 (ordenado por puntos de vida de forma decreciente):");
        mostrarDatosEjercito(e1);


        ordenamientoBubbleSort(e2);
        System.out.println("\nRanking de soldados del ejército 2 (ordenado por puntos de vida de forma decreciente):");
        mostrarDatosEjercito(e2);


        String resultadoBatalla = determinarGanador(e1, e2);
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

    public static void inicializarEjercitos(ArrayList<Soldado> e1, ArrayList<Soldado> e2,
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
                Soldado soldado = new Soldado(nombre, puntosVida, fila + 1, (char) ('A' + columna));

                if (i == 0) {
                    e1.add(soldado);
                    tablero.get(fila).set(columna, soldado);
                } else {
                    e2.add(soldado);
                    tablero.get(fila).set(columna, soldado);
                }
            }
        }
    }

    public static void mostrarTablero(ArrayList<ArrayList<Soldado>> tablero, ArrayList<Soldado> e1, 
                                        ArrayList<Soldado> e2) {
        System.out.println("Tablero de la batalla:"
                            + "\nLas unidades del ejército 1 estarán con sus puntos de vida entre corchetes ([x])." 
                            + "\nLas del ejército 2 con sus puntos de vida entre signos menor y mayor que (<x>):");
        System.out.println("\n           A     B     C     D     E     F     G     H     I     J");
        System.out.println();
        System.out.println("        -------------------------------------------------------------");

        for (int i = 0; i < tablero.size(); i++) {
            System.out.print(i + 1 + "\t| ");
            for (int j = 0; j < tablero.get(i).size(); j++) {
                Soldado soldado = tablero.get(i).get(j);
                if (soldado == null)
                    System.out.print("    | ");
                else 
                    if (e1.contains(soldado)) 
                        System.out.print("[" + soldado.getPuntosVida() + "] | ");
                    else if (e2.contains(soldado)) 
                        System.out.print("<" + soldado.getPuntosVida() + "> | ");
                    else 
                        System.out.print(soldado.getPuntosVida() + " | ");
                
            }
            System.out.println();
            System.out.println("        -------------------------------------------------------------");
        }
    }

    public static void mostrarDatosEjercito(ArrayList<Soldado> ejercito) {
        for (Soldado s : ejercito)
            System.out.println(s);
    }

    public static Soldado obtenerSoldadoMayorVida(ArrayList<Soldado> ejercito) {
        Soldado mayorVida = null;
        int maxPuntosVida = Integer.MIN_VALUE;
        for (Soldado soldado : ejercito) 
            if (soldado.getPuntosVida() > maxPuntosVida) {
                maxPuntosVida = soldado.getPuntosVida();
                mayorVida = soldado;
            }
        return mayorVida;
    }

    public static double calcularPromedioVida(ArrayList<Soldado> ejercito) {
        double total = 0;
        for (Soldado soldado : ejercito) 
            total += soldado.getPuntosVida();
        return total / ejercito.size();
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

    public static String determinarGanador(ArrayList<Soldado> e1, ArrayList<Soldado> e2) {
        int puntosE1 = 0;
        int puntosE2 = 0;
    
        for (Soldado soldado : e1)
            puntosE1 += soldado.getPuntosVida();
    
        for (Soldado soldado : e2) 
            puntosE2 += soldado.getPuntosVida();
        
        if (puntosE1 > puntosE2) 
            return "El ejército 1 ha ganado la batalla. La suma total de sus puntos de vida es " + puntosE1 
                    + " superando en " + (puntosE1 - puntosE2) + " puntos al ejército 2.";
        else if (puntosE2 > puntosE1) 
            return "El ejército 2 ha ganado la batalla. La suma total de sus puntos de vida es " + puntosE2 
                    + " superando en " + (puntosE2 - puntosE1) + " puntos al ejército 1.";
        else 
            return "La batalla ha terminado en empate. Ambos ejércitos tienen " + puntosE1 + " puntos de vida en total.";
    }
}