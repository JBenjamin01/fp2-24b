// FUNDAMENTOS DE LA PROGRAMACIÓN 2
// LABORATORIO N° 1 - ACTIVIDAD 2
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES

import java.util.*;
class Actividad2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Declaración de las variables
        String name1, name2, name3, name4, name5;
        String level1, level2, level3, level4, level5;

        // Ingreso de los nombres y niveles de juego de los jugadores
        System.out.println("Nombre y nivel de 5 jugadores:");
        
        // Jugador 1
        System.out.print("Nombre del jugador 1: ");
        name1 = sc.next();
        System.out.print("Nivel de juego (novato, profesional, veterano, estrella) del jugador 1: ");
        level1 = sc.next();

        // Jugador 2
        System.out.print("Nombre del jugador 2: ");
        name2 = sc.next();
        System.out.print("Nivel de juego (novato, profesional, veterano, estrella) del jugador 2: ");
        level2 = sc.next();

        // Jugador 3
        System.out.print("Nombre del jugador 3: ");
        name3 = sc.next();
        System.out.print("Nivel de juego (novato, profesional, veterano, estrella) del jugador 3: ");
        level3 = sc.next();

        // Jugador 4
        System.out.print("Nombre del jugador 4: ");
        name4 = sc.next();
        System.out.print("Nivel de juego (novato, profesional, veterano, estrella) del jugador 4: ");
        level4 = sc.next();

        // Jugador 5
        System.out.print("Nombre del jugador 5: ");
        name5 = sc.next();
        System.out.print("Nivel de juego (novato, profesional, veterano, estrella) del jugador 5: ");
        level5 = sc.next();

        // Salida de los nombres y niveles de juego en la consola
        System.out.println("Datos de los jugadores:\n" + "Nombres    |     Nivel");
        System.out.println(name1 + "    \t" + level1);
        System.out.println(name2 + "    \t" + level2);
        System.out.println(name3 + "    \t" + level3);
        System.out.println(name4 + "    \t" + level4);
        System.out.println(name5 + "    \t" + level5);
    }
}