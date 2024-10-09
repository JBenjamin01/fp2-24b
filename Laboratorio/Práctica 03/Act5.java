// FUNDAMENTOS DE LA PROGRAMACIÓN 2
// LABORATORIO N° 1 - ACTIVIDAD 5
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES
import java.util.*;
public class Act5 {
    static Jugador[] team1 = new Jugador[21];
    static Jugador[] team2 = new Jugador[21];
    static Random random = new Random();

    public static void main(String[] args) {
        crearEquipos();
        System.out.println("Datos de los jugadores del equipo 1:");
        mostrarEquipo(team1);
        System.out.println("\nDatos de los jugadores del equipo 2:");
        mostrarEquipo(team2);

        // Selecciona los titulares para los dos equipos
        Jugador[] titularesE1 = selectTitulares(team1);
        Jugador[] titularesE2 = selectTitulares(team2);

        // Mostrar los titulares de ambos equipos
        System.out.println("\nTitulares del Equipo 1:");
        mostrarEquipo(titularesE1);
        System.out.println("\nTitulares del Equipo 2:");
        mostrarEquipo(titularesE2);

        // Generar el número aleatorio de goles para los dos equipos
        int golesE1 = goles();
        int golesE2 = goles();
        System.out.println("\nGoles del Equipo 1: " + golesE1);
        System.out.println("Goles del Equipo 2: " + golesE2);

        // Definir al ganador o si hubo un empate
        determinarGanador(golesE1, golesE2);
    }

    // Método que genera los nombres de la forma JugadorX para los dos equipos de 21 jugadores
    static void crearEquipos() {
        for (int i = 0; i < 21; i++) {
            team1[i] = new Jugador("Jugador" + (i + 1));
            team2[i] = new Jugador("Jugador" + (i + 22));
        }
    }

    // Método para mostrar a los jugadores dentro del arreglo
    static void mostrarEquipo(Jugador[] team) {
        for (int i = 0; i < 11; i++) {
            System.out.println("Jugador " + (i + 1) + ": " + team[i].getNombre());
        }
    }

    // Método para seleccionar a los titulares de cada equipo
    static Jugador[] selectTitulares(Jugador[] team) {
        Jugador[] titulares = new Jugador[11];  // Arreglo para almacenar los titulares seleccionados
        boolean[] selected = new boolean[21];   // Arreglo para rastrear los jugadores ya seleccionados
        int count = 0;

        while (count < 11) {
            // Genera un índice aleatorio entre 0 y 20
            int index = random.nextInt(21);

            // Verifica que el jugador no haya sido seleccionado previamente y lo agrega al arreglo de titulares
            if (!selected[index]) {
                titulares[count] = team[index];
                selected[index] = true;
                count++;
            }
        }
        return titulares;
    }

    // Genera un número aleatorio de goles entre 0 y 5
    static int goles() {
        return random.nextInt(6);
    }

    // Compara los goles y determina el ganador del encuentro (o empate)
    static void determinarGanador(int golesE1, int golesE2) {
        if (golesE1 > golesE2) {
            System.out.println("\nEl Equipo 1 ha ganado el partido!");
        } else if (golesE1 < golesE2) {
            System.out.println("\nEl Equipo 2 ha ganado el partido!");
        } else {
            System.out.println("\n¡Hubo un empate!");
        }
    }
}