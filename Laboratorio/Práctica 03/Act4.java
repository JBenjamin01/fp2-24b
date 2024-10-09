// FUNDAMENTOS DE LA PROGRAMACIÓN 2
// LABORATORIO N° 1 - ACTIVIDAD 4
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES
import java.util.*;

import java.util.*;

class Jugador {
    String nombre;
    String nivel;

    // Constructor para inicializar los atributos del jugador
    Jugador(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
}

public class Act4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Arreglo de objetos Jugador para almacenar la información de los jugadores
        Jugador[] jugadores = new Jugador[5];

        // Ingreso de los nombres y niveles de juego de los jugadores
        System.out.println("Ingrese el nombre y nivel de juego de 5 jugadores:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Nombre del jugador " + (i + 1) + ": ");
            String nombre = sc.nextLine();

            System.out.print("Nivel de juego del jugador " + (i + 1) + " (novato, profesional, veterano, estrella): ");
            String nivel = sc.nextLine();

            // Crear un nuevo objeto Jugador y almacenarlo en el arreglo
            jugadores[i] = new Jugador(nombre, nivel);
        }

        // Mostrar los datos de los jugadores
        System.out.println("\nDatos de los jugadores:");
        System.out.println("Nombres\t\tNivel de juego");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.nombre + "\t\t" + jugador.nivel);
        }
    }
}