// LABORATORIO N° 12
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES
// TIEMPO: 81 MINUTOS
import java.text.DecimalFormat;
import java.util.*;
public class VideoJuego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n========= MENU PRINCIPAL =========");
            System.out.println("1. Juego rápido");
            System.out.println("2. Juego personalizado");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    juegoRapido();
                    break;
                case 2:
                    System.out.println("Juego personalizado:");
                    System.out.println("Se han inicializado los ejércitos, puedes verlos a continuación:");
                    juegoPersonalizado();
                    break;
                case 3:
                    System.out.println("Saliendo del juego. ¡Hasta luego!");
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
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

    public static boolean juego(ArrayList<ArrayList<Soldado>> tablero, ArrayList<Soldado> e1, ArrayList<Soldado> e2) {
        Scanner sc = new Scanner(System.in);
        boolean turnoE1 = true;
        
        while (!e1.isEmpty() && !e2.isEmpty()) {
            System.out.println(turnoE1 ? "\nTurno del Ejército 1 ---> [x]" : "\nTurno del Ejército 2 ---> <x>");
            System.out.println("Escriba 'CANCELAR' en cualquier momento para salir al menú de opciones.");

            System.out.print("Ingrese la coordenada del soldado a mover (Ej. C5): ");
            String coord = sc.nextLine().toUpperCase();
            if (coord.equals("CANCELAR")) {
                System.out.println("\nJuego cancelado. ¿Qué desea hacer?");
                System.out.println("1. Iniciar nuevo juego rápido");
                System.out.println("2. Volver al menú principal");
                System.out.print("Seleccione una opción: ");
                int opcionCancelar = sc.nextInt();

                if (opcionCancelar == 1) {
                    juegoRapido();
                } else {
                    System.out.println("Regresando al menú principal...");
                }
                return true;
            }

            Soldado soldadoSeleccionado = buscarSoldado(tablero, coord);
            if (soldadoSeleccionado == null || (turnoE1 ? !e1.contains(soldadoSeleccionado) : !e2.contains(soldadoSeleccionado))) {
                System.out.println("Movimiento inválido. No hay soldado en la posición o es del ejército contrario.");
                continue;
            }

            System.out.print("Ingrese dirección de movimiento (W para arriba, S para abajo, A para izquierda, D para derecha): ");
            char direccion = sc.next().toUpperCase().charAt(0);
            sc.nextLine();

            boolean movimientoExitoso = moverSoldado(soldadoSeleccionado, direccion, 
                                                    tablero, turnoE1 ? e1 : e2, turnoE1 ? e2 : e1);
            if (!movimientoExitoso) {
                System.out.println("Movimiento no válido, intente nuevamente.");
                continue;
            }

            mostrarTablero(tablero, e1, e2);
            turnoE1 = !turnoE1;
        }

        System.out.println(e1.isEmpty() ? "¡El Ejército 2 ha ganado!" : "¡El Ejército 1 ha ganado!");
        return false;
    }

    public static Soldado buscarSoldado(ArrayList<ArrayList<Soldado>> tablero, String coord) {
        int columna = coord.charAt(0) - 'A';
        
        // Este paso se hizo para poder verificar el caso de que hayan dos cifras
        int fila;
        if (coord.length() == 3) {
            // Aqui son dos dígitos, por ejemplo "H10"
            fila = Integer.parseInt(coord.substring(1, 3)) - 1;
        } else {
            // Y este de solo un dígito, por ejemplo "A5"
            fila = Character.getNumericValue(coord.charAt(1)) - 1;
        }
    
        if (fila >= 0 && fila < 10 && columna >= 0 && columna < 10) 
            return tablero.get(fila).get(columna);
    
        return null;
    }

    public static boolean moverSoldado(Soldado soldado, char direccion, ArrayList<ArrayList<Soldado>> tablero,
                                                ArrayList<Soldado> ejercitoAliado, ArrayList<Soldado> ejercitoEnemigo) {
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
            batalla(soldado, soldadoEnemigo, ejercitoAliado, ejercitoEnemigo, tablero);
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

    public static void batalla(Soldado s1, Soldado s2, ArrayList<Soldado> ejercitoAliado,  
                                ArrayList<Soldado> ejercitoEnemigo, ArrayList<ArrayList<Soldado>> tablero) {
        int vidaTotal = s1.getPuntosVida() + s2.getPuntosVida();
        double probS1 = (double) s1.getPuntosVida() * 100 / vidaTotal;
        double probS2 = (double) s2.getPuntosVida() * 100 / vidaTotal;

        DecimalFormat df = new DecimalFormat(".##");
    
        Random r = new Random();
        double resultado = r.nextDouble() * 100;
    
        System.out.println("\nBatalla entre " + s1.getNombre() + " y " + s2.getNombre());
        System.out.println("Las probabilidades de victoria son | " + s1.getNombre() +" : " + df.format(probS1) + "% | y | " 
                                                                    + s2.getNombre() + " : " + df.format(probS2) + "% |");
        if (resultado < probS1) {
            System.out.println(s1.getNombre() + " ha ganado la batalla contra " + s2.getNombre() + " y ha sumado 1 punto de vida.");
            ejercitoEnemigo.remove(s2);
            s1.setPuntosVida(s1.getPuntosVida() + 1);

            tablero.get(s2.getFila() - 1).set(s2.getColumna() - 'A', s1);

            tablero.get(s1.getFila() - 1).set(s1.getColumna() - 'A', null);
            s1.setFila(s2.getFila());
            s1.setColumna(s2.getColumna());
        } else {
            System.out.println(s2.getNombre() + " ha ganado la batalla contra " + s1.getNombre() + " y ha sumado 1 punto de vida.");
            ejercitoAliado.remove(s1);
            s2.setPuntosVida(s2.getPuntosVida() + 1);

            tablero.get(s1.getFila() - 1).set(s1.getColumna() - 'A', null);
        }
    }

    public static void juegoRapido() {
        Scanner sc = new Scanner(System.in);
        boolean jugarDeNuevo;
    
        do {
            ArrayList<ArrayList<Soldado>> tablero = new ArrayList<>();
            ArrayList<Soldado> e1 = new ArrayList<>();
            ArrayList<Soldado> e2 = new ArrayList<>();
    
            inicializarTablero(tablero);
            inicializarEjercitos(e1, e2, tablero);
    
            System.out.println("\n¡Inicia la batalla!");
            mostrarTablero(tablero, e1, e2);
    
            // Llama al método juego y revisa si fue cancelado
            boolean cancelado = juego(tablero, e1, e2);
    
            // Muestra opciones de finalización solo si el juego no fue cancelado
            if (!cancelado) {
                System.out.println("\nEl juego ha finalizado. ¿Qué desea hacer?");
                System.out.println("1 --> Volver a jugar un juego nuevo");
                System.out.println("2 --> Volver al menú principal");
                System.out.print("Seleccione una opción: ");
                int opcion = sc.nextInt();
                jugarDeNuevo = (opcion == 1);
            } else {
                jugarDeNuevo = false;
            }
        } while (jugarDeNuevo);
    }

    public static void juegoPersonalizado() {
        ArrayList<ArrayList<Soldado>> t = new ArrayList<>();
        ArrayList<Soldado> e1 = new ArrayList<>();
        ArrayList<Soldado> e2 = new ArrayList<>();
        
        inicializarTablero(t);
        inicializarEjercitos(e1, e2, t);

        System.out.println("\nDatos del ejército 1:");
        mostrarDatosEjercito(e1);
        System.out.println("\nDatos del ejército 2:");
        mostrarDatosEjercito(e2);
        
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
    
        while (!exit) {
            System.out.println("\n========= GESTION DE EJÉRCITOS =========");
            System.out.println("Seleccione un ejército para gestionar:");
            System.out.println("1. Ejército 1");
            System.out.println("2. Ejército 2");
            System.out.println("3. Volver al menú principal");
            
            int seleccionEjercito = sc.nextInt();
            ArrayList<Soldado> ejercito = seleccionEjercito == 1 ? e1 : e2;
    
            if (seleccionEjercito == 3) {
                exit = true;
                continue;
            }
    
            boolean volver = false;
            while (!volver) {
                System.out.println("\n===== OPCIONES DE GESTION DE SOLDADOS =====");
                System.out.println("1. Crear Soldado");
                System.out.println("2. Eliminar Soldado");
                System.out.println("3. Clonar Soldado");
                System.out.println("4. Modificar Soldado");
                System.out.println("5. Comparar Soldados");
                System.out.println("6. Intercambiar Soldados");
                System.out.println("7. Ver Soldado");
                System.out.println("8. Ver Ejército");
                System.out.println("9. Sumar Niveles");
                System.out.println("10. Jugar");
                System.out.println("11. Volver a selección de ejército");
                System.out.print("Selecciona una opción:");
    
                int opcion = sc.nextInt();
    
                switch (opcion) {
                    case 1: crearSoldado(ejercito); break;
                    case 2: eliminarSoldado(ejercito); break;
                    case 3: clonarSoldado(ejercito); break;
                    case 4: modificarSoldado(ejercito); break;
                    case 5: compararSoldados(ejercito); break;
                    case 6: intercambiarSoldados(ejercito); break;
                    case 7: verSoldado(ejercito); break;
                    case 8: verEjercito(ejercito); break;
                    case 9: sumarNiveles(ejercito); break;
                    case 10: 
                        System.out.println("\n¡Inicia la batalla!");
                        mostrarTablero(t, e1, e2);
                        juego(t, e1, e2); volver = true; break;
                    case 11: volver = true; break;
                    default: System.out.println("Opción inválida. Intente nuevamente.");
                }
            }
        }
    }

    public static void crearSoldado(ArrayList<Soldado> ejercito) {
        if (ejercito.size() >= 10) {
            System.out.println("El ejército ya tiene 10 soldados. No se pueden añadir más.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese nombre del soldado: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese puntos de vida: ");
        int puntosVida = sc.nextInt();
        System.out.print("Ingrese nivel de ataque: ");
        int nivelAtaque = sc.nextInt();
        System.out.print("Ingrese nivel de defensa: ");
        int nivelDefensa = sc.nextInt();
    
        Soldado nuevoSoldado = new Soldado(nombre, puntosVida, 0, 'A', nivelAtaque, nivelDefensa);
        ejercito.add(nuevoSoldado);
        System.out.println("Soldado creado y añadido al ejército.");
    }

    public static void eliminarSoldado(ArrayList<Soldado> ejercito) {
        if (ejercito.size() <= 1) {
            System.out.println("No se puede eliminar, el ejército no puede quedarse sin soldados.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el índice del soldado a eliminar (1-" + ejercito.size() + "): ");
        int index = sc.nextInt() - 1;
    
        if (index >= 0 && index < ejercito.size()) {
            ejercito.remove(index);
            System.out.println("Soldado eliminado del ejército.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void clonarSoldado(ArrayList<Soldado> ejercito) {
        if (ejercito.size() >= 10) {
            System.out.println("El ejército ya tiene 10 soldados. No se pueden añadir más.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el índice del soldado a clonar (1-" + ejercito.size() + "): ");
        int index = sc.nextInt() - 1;
    
        if (index >= 0 && index < ejercito.size()) {
            Soldado clon = new Soldado(ejercito.get(index).getNombre(), ejercito.get(index).getPuntosVida(),
                    ejercito.get(index).getFila(), ejercito.get(index).getColumna(),
                    ejercito.get(index).getNivelAtaque(), ejercito.get(index).getNivelDefensa());
            ejercito.add(clon);
            System.out.println("Soldado clonado y añadido al ejército.");
        } else {
            System.out.println("Índice inválido.");
        }
    }
    

    public static void modificarSoldado(ArrayList<Soldado> ejercito) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el índice del soldado a modificar (1-" + ejercito.size() + "): ");
        int index = sc.nextInt() - 1;
    
        if (index >= 0 && index < ejercito.size()) {
            Soldado soldado = ejercito.get(index);
            System.out.println("Modificando al soldado: " + soldado.getNombre());

            System.out.print("Ingrese nueva vida actual: ");
            soldado.setPuntosVida(sc.nextInt());
    
            System.out.println("Soldado modificado exitosamente.");
        } else {
            System.out.println("Índice inválido.");
        }
    }
    

    public boolean compararSoldados(Soldado soldado1, Soldado soldado2) {
        return soldado1.getNombre().equals(soldado2.getNombre()) &&
                soldado1.getNivelAtaque() == soldado2.getNivelAtaque() &&
                soldado1.getNivelDefensa() == soldado2.getNivelDefensa() &&
                soldado1.getPuntosVida() == soldado2.getPuntosVida();
    }

    public static void intercambiarSoldados(ArrayList<Soldado> ejercito) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el índice del primer soldado a intercambiar (1-" + ejercito.size() + "): ");
        int index1 = sc.nextInt() - 1;
        System.out.print("Ingrese el índice del segundo soldado a intercambiar (1-" + ejercito.size() + "): ");
        int index2 = sc.nextInt() - 1;
    
        // Validar los índices
        if (index1 >= 0 && index1 < ejercito.size() && index2 >= 0 && index2 < ejercito.size()) {
            // Intercambiar soldados
            Soldado temp = ejercito.get(index1);
            ejercito.set(index1, ejercito.get(index2));
            ejercito.set(index2, temp);
            System.out.println("Soldados intercambiados exitosamente.");
        } else {
            System.out.println("Índices inválidos.");
        }
    }

    public static void verSoldado(ArrayList<Soldado> ejercito) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el índice del soldado a ver (1-" + ejercito.size() + "): ");
        int index = sc.nextInt() - 1;
    
        if (index >= 0 && index < ejercito.size()) {
            Soldado soldado = ejercito.get(index);
            System.out.println("Datos del Soldado:");
            System.out.println(soldado);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void verEjercito(ArrayList<Soldado> ejercito) {
        System.out.println("Datos del Ejército:");
        for (int i = 0; i < ejercito.size(); i++) {
            System.out.println((i + 1) + ". " + ejercito.get(i));
        }
    }

    public static void sumarNiveles(ArrayList<Soldado> ejercito) {
        int totalVida = 0;
        int totalAtaque = 0;
        int totalDefensa = 0;
    
        for (Soldado soldado : ejercito) {
            totalVida += soldado.getPuntosVida();
            totalAtaque += soldado.getNivelAtaque();
            totalDefensa += soldado.getNivelDefensa();
        }
    
        System.out.println("Puntaje combinado del ejército:");
        System.out.println("Puntos totales de vida: " + totalVida);
        System.out.println("Nivel total de ataque: " + totalAtaque);
        System.out.println("Nivel total de defensa: " + totalDefensa);
    }

    public static void compararSoldados(ArrayList<Soldado> ejercito) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el índice del primer soldado a comparar (1-" + ejercito.size() + "): ");
        int index1 = sc.nextInt() - 1;
        System.out.print("Ingrese el índice del segundo soldado a comparar (1-" + ejercito.size() + "): ");
        int index2 = sc.nextInt() - 1;
    
        if (index1 >= 0 && index1 < ejercito.size() && index2 >= 0 && index2 < ejercito.size()) {
            Soldado soldado1 = ejercito.get(index1);
            Soldado soldado2 = ejercito.get(index2);
            if (soldado1.equals(soldado2)) {
                System.out.println("Los soldados son iguales.");
            } else {
                System.out.println("Los soldados son diferentes.");
            }
        } else {
            System.out.println("Índices inválidos.");
        }
    }
}