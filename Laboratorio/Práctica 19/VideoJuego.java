// LABORATORIO N° 19
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES
// TIEMPO: 62 MINUTOS
import java.text.DecimalFormat;
import java.util.*;

public class VideoJuego {
    public static void main(String[] args) {
        Ejercito ej1 = new Ejercito(1);
        Ejercito ej2 = new Ejercito(2);
        Mapa m = new Mapa(ej1, ej2);

        juego(m, ej1, ej2);
    }

    public static boolean juego(Mapa m, Ejercito ej1, Ejercito ej2) {
        Scanner sc = new Scanner(System.in);
        boolean turnoEj1 = true;

        System.out.println("════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                 B I E N V E N I D O S   A   L A   B A T A L L A");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════");
        System.out.println(" En este juego, dos ejércitos lucharán por la victoria. ¡Que gane el mejor!\n");
        System.out.println(" Instrucciones:");
        System.out.println(" 1. Cada jugador controlará un ejército por turnos.");
        System.out.println(" 2. Podrás mover tus soldados en el tablero y atacar a los enemigos.");
        System.out.println(" 3. El objetivo es derrotar a todos los soldados enemigos.\n");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════");
        System.out.println();

        System.out.println("                        ╔═════════════════════════════════╗\n" 
                        + "                        ║       ¡INICIA LA BATALLA!       ║\n"
                        + "                        ╚═════════════════════════════════╝");
        m.mostrarMapa();
        System.out.println();

        while (!(ej1.isEmpty()) && !(ej2.isEmpty())) {
            System.out.println("\n════════════════════════════════════════════════════════════════════════════════════");
            System.out.println(turnoEj1 ? "                                TURNO DEL EJÉRCITO 1" 
                                        : "                                TURNO DEL EJÉRCITO 2");
            System.out.println("════════════════════════════════════════════════════════════════════════════════════");

            System.out.print("Ingrese la coordenada del soldado a mover (Ej. C5): ");
            String coord = sc.nextLine().toUpperCase();

            Soldado soldadoSeleccionado = buscarSoldado(m, coord);
            if (soldadoSeleccionado == null || (turnoEj1 ? !ej1.contains(soldadoSeleccionado) : !ej2.contains(soldadoSeleccionado))) {
                System.out.println("[ERROR] Movimiento inválido: No hay soldado en la posición o es del ejército contrario.");
                System.out.println("Observa el mapa y vuelve a escribir la posición del soldado.");
                continue;
            }

            System.out.print("Ingrese dirección de movimiento (W para arriba, S para abajo, A para izquierda, D para derecha): ");
            char direccion = sc.next().toUpperCase().charAt(0);
            sc.nextLine();

            boolean movimientoExitoso = moverSoldado(soldadoSeleccionado, direccion, m, turnoEj1 ? ej1 : ej2, turnoEj1 ? ej2 : ej1);
            if (!movimientoExitoso) {
                System.out.println("[ERROR]Movimiento no válido, intente nuevamente.");
                continue;
            }

            m.actualizarMapa(ej1, ej2);
            m.mostrarMapa();
            turnoEj1 = !turnoEj1;

            try {
                Thread.sleep(1000); // Pausa entre turnos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        if (ej2.isEmpty()) {
            System.out.println("════════════════════════════════════════════════════════════════════════════════════");
            System.out.println("                                 ¡EJÉRCITO 1 GANA!");
            System.out.println("════════════════════════════════════════════════════════════════════════════════════");
            System.out.println(" El Ejército 1 ha eliminado a todos los enemigos. Enhorabuena!");
        } else {
            System.out.println("════════════════════════════════════════════════════════════════════════════════════");
            System.out.println("                                 ¡EJÉRCITO 2 GANA!");
            System.out.println("════════════════════════════════════════════════════════════════════════════════════");
            System.out.println(" El Ejército 2 ha derrotado al ejército enemigo. ¡Honor a los valientes!");
        }
        System.out.println("════════════════════════════════════════════════════════════════════════════════════");
        
        return false;
    }

    public static Soldado buscarSoldado(Mapa m, String coord) {
        int columna = coord.charAt(0) - 'A';
        int fila;

        if (coord.length() == 3) 
            fila = Integer.parseInt(coord.substring(1, 3)) - 1;
        else 
            fila = Character.getNumericValue(coord.charAt(1)) - 1;
    
        if (fila >= 0 && fila < 10 && columna >= 0 && columna < 10) 
            return m.getSoldado(fila + 1, (char) ('A' + columna));
    
        return null;
    }

    public static boolean moverSoldado(Soldado s, char direccion, Mapa m, Ejercito ejAliado, Ejercito ejEnemigo) {
        int fila = s.getFila() - 1;
        int columna = s.getColumna() - 'A';
    
        switch (direccion) {
            case 'W': fila--; break;
            case 'S': fila++; break;
            case 'A': columna--; break;
            case 'D': columna++; break;
            default: return false;
        }
    
        if (!verificarMovimientoValido(fila, columna))
            return false;

        if (ejAliado.contains(m.getSoldado(fila + 1, (char) ('A' + columna))))
            return false;
    
        Soldado sEnemigo = m.getSoldado(fila + 1, (char) ('A' + columna));
    
        if (sEnemigo != null && ejEnemigo.contains(sEnemigo))
            batalla(s, sEnemigo, ejAliado, ejEnemigo, m);
        else if (sEnemigo == null) {
            s.setFila(fila + 1);
            s.setColumna((char) ('A' + columna));
        } else 
            return false;
        
        return true;
    }

    public static boolean verificarMovimientoValido(int fila, int columna) {
        return fila >= 0 && fila < 10 && columna >= 0 && columna < 10;        
    }

    public static void batalla(Soldado s, Soldado sEnemigo, Ejercito ejAliado, Ejercito ejEnemigo, Mapa m) {
        int vidaTotal = s.getNivelVida() + sEnemigo.getNivelVida();
        double probS = (double) s.getNivelVida() * 100 / vidaTotal;
        double probsEnemigo = (double) sEnemigo.getNivelVida() * 100 / vidaTotal;

        DecimalFormat df = new DecimalFormat(".##");
    
        Random r = new Random();
        double resultado = r.nextDouble() * 100;
    
        System.out.println("════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                            ¡ENFRENTAMIENTO INICIADO!   ");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════");
        System.out.println(" Soldado 1: " + s.getNombre() + " [Vida: " + s.getNivelVida() + "]");
        System.out.println(" Soldado 2: " + sEnemigo.getNombre() + " [Vida: " + sEnemigo.getNivelVida() + "]");
        System.out.println(" Probabilidades de victoria:");
        System.out.println("   - " + s.getNombre() + ": " + df.format(probS) + "%");
        System.out.println("   - " + sEnemigo.getNombre() + ": " + df.format(probsEnemigo) + "%");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                            Resolviendo la batalla...   ");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════");

        try {
            Thread.sleep(1000);
            System.out.println("Pam! Clash! Boom!\n");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (resultado < probS) {
            System.out.println(s.getNombre() + " ha ganado la batalla contra " + sEnemigo.getNombre() + " y ha sumado 1 punto de vida!");
            ejEnemigo.eliminarSoldado(sEnemigo);
            s.setNivelVida(s.getNivelVida() + 1);

            s.setFila(sEnemigo.getFila());
            s.setColumna(sEnemigo.getColumna());

        } else {
            System.out.println(sEnemigo.getNombre() + " ha ganado la batalla contra " + s.getNombre() + " y ha sumado 1 punto de vida!");
            ejAliado.eliminarSoldado(s);
            sEnemigo.setNivelVida(sEnemigo.getNivelVida() + 1);
        }
        
        System.out.println("════════════════════════════════════════════════════════════════════════════════════");
    }
}