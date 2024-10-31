// LABORATORIO N° 10
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES
// TIEMPO: 94 MINUTOS
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

        System.out.println("\nPromedio de puntos de vida del ejército 1: " + String.format("%.3f", promedioVidaE1));
        System.out.println("Promedio de puntos de vida del ejército 2: " + String.format("%.3f", promedioVidaE2));

        // Aqui hago unas copias de los ejercitos para el ranking para evitar modificar los originales
        List<Soldado> r1 = new ArrayList<>(e1);
        List<Soldado> r2 = new ArrayList<>(e2);

        ordenamientoInsertionSort(r1);
        System.out.println("\nRanking de soldados del ejército 1 (ordenado por puntos de vida de forma decreciente):");
        mostrarRanking(r1);

        ordenamientoBubbleSort(r2);
        System.out.println("\nRanking de soldados del ejército 2 (ordenado por puntos de vida de forma decreciente):");
        mostrarRanking(r2);


        // Inicia el ciclo de juego
        System.out.println("\n¡Inicia la batalla!");
        juego(tablero, e1, e2);
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
                            + "\nLas unidades del ejército 1 están con sus puntos de vida entre corchetes ([x])." 
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

    public static void ordenamientoInsertionSort(List<Soldado> ejercito) {
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
    public static void ordenamientoBubbleSort(List<Soldado> ejercito) {
        int n = ejercito.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (ejercito.get(j).getPuntosVida() < ejercito.get(j + 1).getPuntosVida()){
                    Soldado temp = ejercito.get(j);
                    ejercito.set(j, ejercito.get(j + 1));
                    ejercito.set(j + 1, temp);
                }
    }
    public static void mostrarRanking(List<Soldado> ejercito) {
        for (int i = 0; i < ejercito.size(); i++) {
            Soldado soldado = ejercito.get(i);
            System.out.println((i + 1) + ".- " +  soldado);
        }
    }

    public static void juego(ArrayList<ArrayList<Soldado>> tablero, ArrayList<Soldado> e1, ArrayList<Soldado> e2) {
        Scanner sc = new Scanner(System.in);
        boolean turnoEjercito1 = true;
        while (!e1.isEmpty() && !e2.isEmpty()) {
            System.out.println(turnoEjercito1 ? "\nTurno del Ejército 1 ---> [x]" : "\nTurno del Ejército 2 ---> <x>");
    
            // Paso 1: Ingresar coordenada y verificarla antes de solicitar la dirección
            System.out.print("Ingrese coordenada del soldado a mover (Ej. C5): ");
            String coordenada = sc.nextLine().toUpperCase();
    
            // Buscar el soldado en la coordenada ingresada
            Soldado soldadoSeleccionado = buscarSoldado(tablero, coordenada);
            if (soldadoSeleccionado == null || (turnoEjercito1 ? !e1.contains(soldadoSeleccionado) : !e2.contains(soldadoSeleccionado))) {
                System.out.println("Movimiento inválido. No hay soldado en la posición o es del ejército contrario.");
                continue;  // El continue deja volver al inicio del ciclo sin solicitar la dirección de movimiento
            }
    
            // Paso 2: Solicitar la dirección si la coordenada es válida
            System.out.print("Ingrese dirección de movimiento (W para arriba, S para abajo, A para izquierda, D para derecha): ");
            char direccion = sc.next().toUpperCase().charAt(0);
            sc.nextLine();
    
            boolean movimientoExitoso = moverSoldado(soldadoSeleccionado, direccion, 
                                                    tablero, turnoEjercito1 ? e1 : e2, turnoEjercito1 ? e2 : e1);
            if (!movimientoExitoso) {
                System.out.println("Movimiento no válido, intente nuevamente.");
                continue;
            }
    
            mostrarTablero(tablero, e1, e2);
            turnoEjercito1 = !turnoEjercito1; // Cambios de turno
        }
    
        System.out.println(e1.isEmpty() ? "¡El Ejército 2 ha ganado!" : "¡El Ejército 1 ha ganado!");
        sc.close();
    }

    public static Soldado buscarSoldado(ArrayList<ArrayList<Soldado>> tablero, String coordenada) {
        int columna = coordenada.charAt(0) - 'A';
        
        // Este paso se hizo para poder verificar el caso de que hayan dos cifras
        int fila;
        if (coordenada.length() == 3) {
            // Aqui son dos dígitos, por ejemplo "H10"
            fila = Integer.parseInt(coordenada.substring(1, 3)) - 1;
        } else {
            // Y este de solo un dígito, por ejemplo "A5"
            fila = Character.getNumericValue(coordenada.charAt(1)) - 1;
        }
    
        if (fila >= 0 && fila < 10 && columna >= 0 && columna < 10) 
            return tablero.get(fila).get(columna);
    
        return null;
    }

    public static boolean moverSoldado(Soldado soldado, char direccion, ArrayList<ArrayList<Soldado>> tablero,
                                                ArrayList<Soldado> ejercito, ArrayList<Soldado> ejercitoEnemigo) {
        int fila = soldado.getFila() - 1;
        int columna = soldado.getColumna() - 'A';
    
        switch (direccion) {
            case 'W': fila--; break; // Arriba
            case 'S': fila++; break; // Abajo
            case 'A': columna--; break; // Izquierda
            case 'D': columna++; break; // Derecha
            default: return false;
        }
    
        // Primero verifico si el movimiento está dentro de los límites del tablero
        if (!verificarMovimientoValido(fila, columna, tablero))
            return false;
    
        Soldado soldadoEnemigo = tablero.get(fila).get(columna);
    
        // En caso de que la posición contiene un enemigo, se inicia la batalla
        if (soldadoEnemigo != null && ejercitoEnemigo.contains(soldadoEnemigo)) {
            batalla(soldado, soldadoEnemigo, ejercitoEnemigo, tablero);
        } else if (soldadoEnemigo == null) { // Si no hay enemigo, se va a mover el soldado a la posición
            tablero.get(soldado.getFila() - 1).set(soldado.getColumna() - 'A', null);
            tablero.get(fila).set(columna, soldado);
            soldado.setFila(fila + 1);
            soldado.setColumna((char) ('A' + columna));
        } else {
            return false; // Aqui simplemente sería por un movimiento inválido
        }
    
        return true;
    }

    public static boolean verificarMovimientoValido(int fila, int columna, ArrayList<ArrayList<Soldado>> tablero) {
        return fila >= 0 && fila < 10 && columna >= 0 && columna < 10;
    }

    public static void batalla(Soldado soldado, Soldado soldadoEnemigo, ArrayList<Soldado> ejercitoEnemigo, 
                                                                        ArrayList<ArrayList<Soldado>> tablero) {
        if (soldado.getPuntosVida() > soldadoEnemigo.getPuntosVida()) {
            System.out.println(soldado.getNombre() + " ha derrotado a " + soldadoEnemigo.getNombre() + "\n");
            ejercitoEnemigo.remove(soldadoEnemigo);
    
            // Quita al soldado derrotado
            tablero.get(soldadoEnemigo.getFila() - 1).set(soldadoEnemigo.getColumna() - 'A', soldado);
    
            // Actualiza la posición del soldado que ganó
            tablero.get(soldado.getFila() - 1).set(soldado.getColumna() - 'A', null);
            soldado.setFila(soldadoEnemigo.getFila());
            soldado.setColumna(soldadoEnemigo.getColumna());
    
        } else {
            System.out.println(soldadoEnemigo.getNombre() + " ha derrotado a " + soldado.getNombre() + "\n");
            ejercitoEnemigo.remove(soldado);
    
            // Saca al soldado derrotado
            tablero.get(soldado.getFila() - 1).set(soldado.getColumna() - 'A', soldadoEnemigo);
    
            // Actualiza la posición
            tablero.get(soldadoEnemigo.getFila() - 1).set(soldadoEnemigo.getColumna() - 'A', null);
            soldadoEnemigo.setFila(soldado.getFila());
            soldadoEnemigo.setColumna(soldado.getColumna());
        }
    }
}