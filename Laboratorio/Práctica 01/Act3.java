// FUNDAMENTOS DE LA PROGRAMACIÓN 2
// LABORATORIO N° 1 - ACTIVIDAD 3
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES
import java.util.*;
class Actividad3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Declaración del arreglo para almacenar los nombres
        String [] jugadores = new String[5];

        // Ingreso de los nombres de los soldados
        System.out.println("Ingrese el nombre de los 5 soldados:");
        for (int i = 0; i < 5; i++){
            System.out.print("Jugador " + (i + 1) + ": ");
            jugadores[i] = sc.next();
        }
        // Salida de los nombres de los soldados en la consola
        System.out.println("Los jugadores ingresados son:");
        for (int j = 0; j < 5; j++)
            System.out.println("- " + jugadores[j]);
    }
}