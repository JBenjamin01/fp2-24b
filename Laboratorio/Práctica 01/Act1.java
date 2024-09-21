// FUNDAMENTOS DE LA PROGRAMACIÓN 2
// LABORATORIO N° 1 - ACTIVIDAD 1
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES

import java.util.*;
class Act1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Declaración de las variables
        String name1, name2, name3, name4, name5;

        // Ingreso de los nombres de los jugadores
        System.out.println("Ingrese el nombre del primer jugador:");
        name1 = sc.nextLine();
        System.out.println("Ingrese el nombre del segundo jugador:");
        name2 = sc.nextLine();
        System.out.println("Ingrese el nombre del tercer jugador:");
        name3 = sc.nextLine();
        System.out.println("Ingrese el nombre del cuarto jugador:");
        name4 = sc.nextLine();
        System.out.println("Ingrese el nombre del quinto jugador:");
        name5 = sc.nextLine();

        // Salida de los nombres en la consola
        System.out.println("Los jugadores son:");
        System.out.print("- " + name1 
                        + "\n- " + name2 
                        + "\n- " + name3 
                        + "\n- " + name4 
                        + "\n- " + name5);
    }
}