// LABORATORIO N° 14
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES
// TIEMPO: 132 MINUTOS
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

    public static void inicializarReinos(ArrayList<ArrayList<Soldado>> r1, ArrayList<ArrayList<Soldado>> r2) {
        int numEjercitosR1 = (int) (Math.random() * 11);
        int numEjercitosR2 = (int) (Math.random() * 11);
    
        // Inicializar los ejércitos de cada reino
        inicializarEjercitosReino(r1, numEjercitosReino1);  // Para el reino 1
        inicializarEjercitosReino(r2, numEjercitosReino2);  // Para el reino 2
    }

    public static void inicializarEjercitosReino(ArrayList<ArrayList<Soldado>> reino, int numEjercitos) {
        for (int i = 0; i < numEjercitos; i++) {
            // Inicializamos cada ejército como un arreglo de soldados
            ArrayList<Soldado> ejercito = new ArrayList<>();
            
            // Luego inicializamos soldados dentro de este ejército
            inicializarEjercitos(ejercito);  // Método que ya tienes, que asigna soldados a un ejército
            
            // Finalmente, agregamos este ejército al reino
            reino.add(ejercito);
        }
    }

    public static void inicializarEjercitos(ArrayList<Soldado> e1, ArrayList<Soldado> e2) {
        Set<String> posicionesOcupadas = new HashSet<>();
        for (int i = 0; i < 2; i++) {
            int n = (int) (Math.random() * Soldado.MAX_SOLDADOS_POR_EJERCITO) + 1;
            for (int j = 0; j < n; j++) {
                String nombre = "Soldado" + (i + 1) + "X" + (j + 1);
                int puntosVida = (int) (Math.random() * 5) + 1;
                int puntosAtaque = (int) (Math.random() * 5) + 1;
                int puntosDefensa = (int) (Math.random() * 5) + 1;
                
                int fila, columna;

                do {
                    fila = (int) (Math.random() * 10);
                    columna = (int) (Math.random() * 10);
                } while (posicionesOcupadas.contains(fila + "," + columna));

                posicionesOcupadas.add(fila + "," + columna);

                Soldado soldado = new Soldado(nombre, puntosVida, 1 + fila, (char) ('A' + columna), puntosAtaque, puntosDefensa, i + 1);

                if (i == 0) {
                    e1.add(soldado);
                    Soldado.soldadosEjercito1++;
                } else {
                    e2.add(soldado);
                    Soldado.soldadosEjercito2++;
                }
            }
        }
    }

    public static void colocarEjercitosEnTablero(ArrayList<Soldado> e1, ArrayList<Soldado> e2,
                                                ArrayList<ArrayList<Soldado>> tablero) {
        for (Soldado soldado : e1) {
            int fila = soldado.getFila() - 1; 
            int columna = soldado.getColumna() - 'A';

            tablero.get(fila).set(columna, soldado);
        }

        for (Soldado soldado : e2) {
            int fila = soldado.getFila() - 1;
            int columna = soldado.getColumna() - 'A';

            tablero.get(fila).set(columna, soldado);
        }
    }

    public static void mostrarTablero(ArrayList<ArrayList<Soldado>> tablero, ArrayList<Soldado> e1, 
                                        ArrayList<Soldado> e2) {
        System.out.println("\nTablero de la batalla:"
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
        System.out.println();

        while (!(Soldado.soldadosEjercito1 == 0) && !(Soldado.soldadosEjercito2 == 0)) {
            System.out.println("Cantidad de soldados restantes en el Ejército 1: " + Soldado.soldadosEjercito1);
            System.out.println("Cantidad de soldados restantes en el Ejército 2: " + Soldado.soldadosEjercito2);
            System.out.println(turnoE1 ? "\nTurno del Ejército 1 ---> [x]" : "\nTurno del Ejército 2 ---> <x>");
            System.out.println("Escriba 'CANCELAR' en cualquier momento para salir al menú de opciones.");

            System.out.print("Ingrese la coordenada del soldado a mover (Ej. C5): ");
            String coord = sc.nextLine().toUpperCase();
            if (coord.equals("CANCELAR")) {
                System.out.println("\nJuego cancelado. ¿Qué desea hacer?");
                System.out.println("1. Iniciar un nuevo juego rápido");
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
        Soldado.soldadosEjercito1 = 0;
        Soldado.soldadosEjercito2 = 0;
        Soldado.totalSoldadosCreados = 0;
        return false;
    }

    public static Soldado buscarSoldado(ArrayList<ArrayList<Soldado>> tablero, String coord) {
        int columna = coord.charAt(0) - 'A';
        
        // Este paso se hizo para poder verificar el caso de que hayan dos cifras numéricas para la posición
        int fila;
        if (coord.length() == 3) 
            // Aqui son dos dígitos, por ejemplo "H10"
            fila = Integer.parseInt(coord.substring(1, 3)) - 1;
        else 
            // Y este de solo un dígito, por ejemplo "A5"
            fila = Character.getNumericValue(coord.charAt(1)) - 1;
    
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
    
        if (!verificarMovimientoValido(fila, columna, tablero))
            return false;
    
        Soldado soldadoEnemigo = tablero.get(fila).get(columna);
    
        // En caso de que la posición contiene un enemigo, se inicia la batalla
        if (soldadoEnemigo != null && ejercitoEnemigo.contains(soldadoEnemigo)) {
            batalla(soldado, soldadoEnemigo, ejercitoAliado, ejercitoEnemigo, tablero);
        } else if (soldadoEnemigo == null) { // Si no hay enemigo, se va a mover a esa posición
            tablero.get(soldado.getFila() - 1).set(soldado.getColumna() - 'A', null);
            tablero.get(fila).set(columna, soldado);
            soldado.setFila(fila + 1);
            soldado.setColumna((char) ('A' + columna));
        } else {
            return false;
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
    
        System.out.println("\noooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
        System.out.println("\nBatalla entre " + s1.getNombre() + " y " + s2.getNombre());
        System.out.println("Las probabilidades de victoria son | " + s1.getNombre() +" : " + df.format(probS1) + "% | y | " 
                                                                    + s2.getNombre() + " : " + df.format(probS2) + "% |");
        System.out.println("\nEnfrentando soldados......\n");
        if (resultado < probS1) {
            System.out.println(s1.getNombre() + " ha ganado la batalla contra " + s2.getNombre() + " y ha sumado 1 punto de vida!");
            ejercitoEnemigo.remove(s2);
            s1.setPuntosVida(s1.getPuntosVida() + 1);

            tablero.get(s2.getFila() - 1).set(s2.getColumna() - 'A', s1);

            tablero.get(s1.getFila() - 1).set(s1.getColumna() - 'A', null);
            s1.setFila(s2.getFila());
            s1.setColumna(s2.getColumna());
            
            if (s2.getEjercito() == 1) {
                Soldado.soldadosEjercito1--;
            } else {
                Soldado.soldadosEjercito2--;
            }
        } else {
            System.out.println(s2.getNombre() + " ha ganado la batalla contra " + s1.getNombre() + " y ha sumado 1 punto de vida!");
            ejercitoAliado.remove(s1);
            s2.setPuntosVida(s2.getPuntosVida() + 1);

            tablero.get(s1.getFila() - 1).set(s1.getColumna() - 'A', null);

            if (s1.getEjercito() == 1) {
                Soldado.soldadosEjercito1--;
            } else {
                Soldado.soldadosEjercito2--;
            }
        }
        System.out.println("\noooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\n");
    }

    public static void juegoRapido() {
        Scanner sc = new Scanner(System.in);
        boolean jugarDeNuevo;
    
        do {
            ArrayList<ArrayList<Soldado>> tablero = new ArrayList<>();
            ArrayList<Soldado> e1 = new ArrayList<>();
            ArrayList<Soldado> e2 = new ArrayList<>();
    
            inicializarTablero(tablero);
            inicializarEjercitos(e1, e2);
            colocarEjercitosEnTablero(e1, e2, tablero);

            System.out.println();
            mostrarCantidadDeSoldados();
    
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

                Soldado.soldadosEjercito1 = 0;
                Soldado.soldadosEjercito2 = 0;
                Soldado.totalSoldadosCreados = 0;
            } else {
                jugarDeNuevo = false;

            }
        } while (jugarDeNuevo);
    }

    public static void juegoPersonalizado() {
        System.out.println("\n¡Bienvenido a la sección de juego personalizado!");
        ArrayList<ArrayList<Soldado>> tablero = new ArrayList<>();
        ArrayList<Soldado> e1 = new ArrayList<>();
        ArrayList<Soldado> e2 = new ArrayList<>();
        
        inicializarTablero(tablero);
        inicializarEjercitos(e1, e2);

        System.out.println("Se han inicializado los ejércitos, puedes verlos a continuación:");

        System.out.println("\nDatos del ejército 1:");
        mostrarDatosEjercito(e1);
        System.out.println("\nDatos del ejército 2:");
        mostrarDatosEjercito(e2);
        
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
    
        while (!exit) {
            System.out.println("\n========= GESTION DE EJÉRCITOS =========");
            System.out.println("1. Ejército 1");
            System.out.println("2. Ejército 2");
            System.out.print("3. Volver al menú principal");
            System.out.print("Seleccione un ejército para gestionar: ");
            int seleccionEjercito = sc.nextInt();

            ArrayList<Soldado> ejercito = seleccionEjercito == 1 ? e1 : e2;
            int ejercitoNum = seleccionEjercito == 1 ? 1 : 2;
    
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
                System.out.print("Selecciona una opción: ");
    
                int opcion = sc.nextInt();
    
                switch (opcion) {
                    case 1: crearSoldado(ejercito, tablero, ejercitoNum); break;
                    case 2: eliminarSoldado(ejercito, tablero, ejercitoNum); break;
                    case 3: clonarSoldado(ejercito, tablero, ejercitoNum); break;
                    case 4: modificarSoldado(ejercito); break;
                    case 5: compararSoldados(ejercito); break;
                    case 6: intercambiarSoldados(ejercito); break;
                    case 7: verSoldado(ejercito); break;
                    case 8: verEjercito(ejercito); break;
                    case 9: sumarNiveles(ejercito); break;
                    case 10:
                        mostrarCantidadDeSoldados();
                        System.out.println("\n¡Inicia la batalla!");
                        colocarEjercitosEnTablero(e1, e2, tablero);
                        mostrarTablero(tablero, e1, e2);
                        juego(tablero, e1, e2); volver = true; break;

                    case 11: volver = true; break;
                    default: System.out.println("Opción inválida. Intente nuevamente.");
                }
            }
        }
    }

    public static void crearSoldado(ArrayList<Soldado> ejercito, ArrayList<ArrayList<Soldado>> tablero, int ejercitoNum) {
        if (ejercito.size() >= Soldado.MAX_SOLDADOS_POR_EJERCITO) {
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
    
        int fila, columna;
        Set<String> posicionesOcupadas = new HashSet<>();
        for (ArrayList<Soldado> filaTablero : tablero) {
            for (Soldado soldado : filaTablero) {
                if (soldado != null) {
                    posicionesOcupadas.add(soldado.getFila() - 1 + "," + (soldado.getColumna() - 'A'));
                }
            }
        }
        do {
            fila = (int) (Math.random() * 10);
            columna = (int) (Math.random() * 10);
        } while (posicionesOcupadas.contains(fila + "," + columna));

        Soldado nuevoSoldado = new Soldado(nombre, puntosVida, fila + 1, (char) ('A' + columna), nivelAtaque, nivelDefensa, ejercitoNum);

        ejercito.add(nuevoSoldado);
        System.out.println("Soldado creado y añadido al ejército " + ejercitoNum + " en la posición " + (char) ('A' + columna) + (fila + 1));

        if (ejercitoNum == 1)
            Soldado.soldadosEjercito1++;
        else
            Soldado.soldadosEjercito2++;
        Soldado.totalSoldadosCreados++;
    }

    public static void eliminarSoldado(ArrayList<Soldado> ejercito, ArrayList<ArrayList<Soldado>> tablero, int ejercitoNum) {
        if (ejercito.size() == 1) {
            System.out.println("No se puede eliminar, el ejército necesita al menos un soldado para poder continuar en el campo de batalla.");
            return;
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del soldado a eliminar: ");
        String nombre = sc.nextLine();

        Soldado soldadoAEliminar = null;
        for (Soldado s : ejercito) {
            if (s.getNombre().equalsIgnoreCase(nombre)) {
                soldadoAEliminar = s;
                break;
            }
        }

        if (soldadoAEliminar == null) {
            System.out.println("No se ha encontrado un soldado con ese nombre, verifica que sea del ejército que buscas.");
            return;
        }

        ejercito.remove(soldadoAEliminar);

        int fila = soldadoAEliminar.getFila() - 1;
        int columna = soldadoAEliminar.getColumna() - 'A';
        tablero.get(fila).set(columna, null);

        System.out.println("El soldado " + soldadoAEliminar.getNombre() + " ha sido eliminado.");

        if (ejercitoNum == 1)
            Soldado.soldadosEjercito1--;
        else
            Soldado.soldadosEjercito2--;
    }

    public static void clonarSoldado(ArrayList<Soldado> ejercito, ArrayList<ArrayList<Soldado>> tablero, int ejercitoNum) {
        if (ejercito.size() >= Soldado.MAX_SOLDADOS_POR_EJERCITO) {
            System.out.println("El ejército ya tiene 10 soldados. No se pueden añadir más.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del soldado a clonar: ");
        String nombre = sc.nextLine();

        Soldado soldadoAClonar = null;
        for (Soldado s : ejercito) {
            if (s.getNombre().equalsIgnoreCase(nombre)) {
                soldadoAClonar = s;
                break;
            }
        }

        if (soldadoAClonar == null) {
            System.out.println("No se ha encontrado un soldado con ese nombre, verifica que sea del ejército que buscas.");
            return;
        }

        String nombreClon = soldadoAClonar.getNombre() + "_Clon";
        int vida = soldadoAClonar.getPuntosVida();
        int ataque = soldadoAClonar.getNivelAtaque();
        int defensa = soldadoAClonar.getNivelDefensa();

        // Generar nueva posición para el clon (sin solapar con otros soldados)
        int fila, columna;
        Set<String> posicionesOcupadas = new HashSet<>();
        for (Soldado s : ejercito) {
            posicionesOcupadas.add((s.getFila() - 1) + "," + (s.getColumna() - 'A'));
        }

        do {
            fila = (int) (Math.random() * 10);
            columna = (int) (Math.random() * 10);
        } while (posicionesOcupadas.contains(fila + "," + columna));

        Soldado clon = new Soldado(nombreClon, vida, fila + 1, (char) ('A' + columna), ataque, defensa, ejercitoNum);

        ejercito.add(clon);
        tablero.get(fila).set(columna, clon);

        System.out.println("Soldado clonado correctamente: " + clon.getNombre() + " en la posición " + (char) ('A' + columna) + (fila + 1));

        if (ejercitoNum == 1)
            Soldado.soldadosEjercito1++;
        else
            Soldado.soldadosEjercito2++;
        Soldado.totalSoldadosCreados++;
    }

    public static void modificarSoldado(ArrayList<Soldado> ejercito) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del soldado que desea modificar: ");
        String nombreSoldado = sc.nextLine();

        Soldado soldadoAModificar = null;
        for (Soldado s : ejercito) {
            if (s.getNombre().equalsIgnoreCase(nombreSoldado)) {
                soldadoAModificar = s;
                break;
            }
        }

        if (soldadoAModificar == null) {
            System.out.println("No se ha encontrado un soldado con ese nombre, verifica que sea del ejército que buscas.");
            return;
        }

        // Submenú para modificar atributos
        boolean salir = false;
        while (!salir) {
            System.out.println("\n¿Qué atributo desea modificar de " + soldadoAModificar.getNombre() + "?");
            System.out.println("1. Modificar puntos de vida");
            System.out.println("2. Modificar nivel de ataque");
            System.out.println("3. Modificar nivel de defensa");
            System.out.println("4. Volver al menú principal");

            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nuevo valor para los puntos de vida: ");
                    int nuevaVida = sc.nextInt();
                    soldadoAModificar.setPuntosVida(nuevaVida);
                    System.out.println("Puntos de vida actualizados a " + nuevaVida);
                    break;

                case 2:
                    System.out.print("Ingrese el nuevo valor para el nivel de ataque: ");
                    int nuevoAtaque = sc.nextInt();
                    soldadoAModificar.setNivelAtaque(nuevoAtaque);
                    System.out.println("Nivel de ataque actualizado a " + nuevoAtaque);
                    break;

                case 3:
                    System.out.print("Ingrese el nuevo valor para el nivel de defensa: ");
                    int nuevoDefensa = sc.nextInt();
                    soldadoAModificar.setNivelDefensa(nuevoDefensa);
                    System.out.println("Nivel de defensa actualizado a " + nuevoDefensa);
                    break;

                case 4:
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
    
    public static void compararSoldados(ArrayList<Soldado> ejercito) {
        if (ejercito.size() < 2) {
            System.out.println("No hay suficientes soldados para comparar.");
            return;
        }
    
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del primer soldado: ");
        String nombreS1 = sc.nextLine();
    
        // Buscar el primer soldado
        Soldado soldado1 = null;
        for (Soldado s : ejercito) {
            if (s.getNombre().equalsIgnoreCase(nombreS1)) {
                soldado1 = s;
                break;
            }
        }
    
        if (soldado1 == null) {
            System.out.println("No se ha encontrado un soldado con ese nombre.");
            return;
        }
    
        System.out.print("Ingrese el nombre del segundo soldado: ");
        String nombreS2 = sc.nextLine();
    
        // Buscar el segundo soldado
        Soldado soldado2 = null;
        for (Soldado s : ejercito) {
            if (s.getNombre().equalsIgnoreCase(nombreS2)) {
                soldado2 = s;
                break;
            }
        }
    
        if (soldado2 == null) {
            System.out.println("No se ha encontrado un soldado con ese nombre.");
            return;
        }
    
        // Comparar los soldados
        boolean sonIguales = compararAtributos(soldado1, soldado2);
    
        if (sonIguales) {
            System.out.println("Los soldados " + soldado1.getNombre() + " y " + soldado2.getNombre() + " son IGUALES.");
        } else {
            System.out.println("Los soldados " + soldado1.getNombre() + " y " + soldado2.getNombre() + " NO son iguales.");
        }
    }

    public static boolean compararAtributos(Soldado s1, Soldado s2) {
        // Aqui hago la comparación de los nombres ignorando el sufijo "_Clon"
        String nombre1 = s1.getNombre().replace("_Clon", "");
        String nombre2 = s2.getNombre().replace("_Clon", "");
        if (!nombre1.equalsIgnoreCase(nombre2)) {
            return false;
        }
    
        // Comparo los demás atributos
        if (s1.getNivelAtaque() != s2.getNivelAtaque()) 
            return false;
        if (s1.getNivelDefensa() != s2.getNivelDefensa()) 
            return false;
        if (s1.getPuntosVida() != s2.getPuntosVida()) 
            return false;
        return true;
    }

    public static void intercambiarSoldados(ArrayList<Soldado> ejercito) {
        if (ejercito.size() < 2) {
            System.out.println("No hay suficientes soldados para comparar.");
            return;
        }
    
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del primer soldado: ");
        String nombreS1 = sc.nextLine();
    
        // Buscar el primer soldado
        Soldado soldado1 = null;
        for (Soldado s : ejercito) {
            if (s.getNombre().equalsIgnoreCase(nombreS1)) {
                soldado1 = s;
                break;
            }
        }
    
        if (soldado1 == null) {
            System.out.println("No se ha encontrado un soldado con ese nombre.");
            return;
        }
    
        System.out.print("Ingrese el nombre del segundo soldado: ");
        String nombreS2 = sc.nextLine();
    
        // Buscar el segundo soldado
        Soldado soldado2 = null;
        for (Soldado s : ejercito) {
            if (s.getNombre().equalsIgnoreCase(nombreS2)) {
                soldado2 = s;
                break;
            }
        }
    
        if (soldado2 == null) {
            System.out.println("No se ha encontrado un soldado con ese nombre.");
            return;
        }
    
        // Intercambiar posiciones
        intercambiarPosiciones(soldado1, soldado2);
    
        System.out.println("Las posiciones de " + soldado1.getNombre() + " y " + soldado2.getNombre() + " han sido intercambiadas.");
    }

    public static void intercambiarPosiciones(Soldado s1, Soldado s2) {
        int filaTemp = s1.getFila();
        char columnaTemp = s1.getColumna();
    
        s1.setFila(s2.getFila());
        s1.setColumna(s2.getColumna());
        s2.setFila(filaTemp);
        s2.setColumna(columnaTemp);
    }

    public static void verSoldado(ArrayList<Soldado> ejercito) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del soldado a ver: ");
        String nombre = sc.nextLine();
    
        Soldado soldado = null;
        for (Soldado s : ejercito) {
            if (s.getNombre().equalsIgnoreCase(nombre)) {
                soldado = s;
                break;
            }
        }
    
        if (soldado == null) {
            System.out.println("No se ha encontrado un soldado con ese nombre.");
            return;
        }
    
        System.out.println("Datos del Soldado seleccionado:");
        System.out.println(soldado);
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

    public static void mostrarCantidadDeSoldados() {
        System.out.println("Cantidad total de soldados creados para este juego: " + Soldado.totalSoldadosCreados);
        System.out.println("Cantidad de soldados en el Ejército 1: " + Soldado.soldadosEjercito1);
        System.out.println("Cantidad de soldados en el Ejército 2: " + Soldado.soldadosEjercito2);
    }
}