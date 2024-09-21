// FUNDAMENTOS DE LA PROGRAMACIÓN 2
// LABORATORIO N° 1 - ACTIVIDAD 4
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES
import java.util.*;

class Act4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Declaración de los arreglos para almacenar los nombres y niveles de juego de los jugadores
        String[] nombres = new String[5];
        String[] niveles = new String[5];

        // Ingreso de los nombres y niveles de juego de los jugadores
        System.out.println("Ingrese el nombre y nivel de juego de 5 jugadores:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Nombre del jugador " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();

            System.out.print("Nivel de juego del jugador " + (i + 1) + " (novato, profesional, veterano, estrella): ");
            niveles[i] = sc.nextLine();
        }

        // Mostrar los datos de los jugadores
        System.out.println("\nDatos de los jugadores:");
        System.out.println("Nombres\t\tNivel de juego");
        for (int i = 0; i < 5; i++) {
            System.out.println(nombres[i] + "\t\t" + niveles[i]);
        }
    }
}