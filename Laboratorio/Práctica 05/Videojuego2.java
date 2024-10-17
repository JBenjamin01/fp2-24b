// LABORATORIO N° 5 - EJERCICIO 1
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES
// TIEMPO: 34 MINUTOS
import java.util.*;
public class Videojuego2 {
    public static void main(String [] args){
        int n = (int) (Math.random() * 10) + 1;
        Soldado [] ejercito = new Soldado[n];
        Scanner sc = new Scanner(System.in);
        String nomb, col, nombre;
        int fil, punt;
        // Aun no se configuro nada aleatorio
        for (int i = 0; i < ejercito.length; i++) {
            nomb = "Soldado " + i;
            System.out.print("Fila (Entre 1 y 10): ");
            do
                fil = sc.nextInt();
            while (fil > 10 || fil < 1);
            System.out.print("Columna (De la A a la J): ");
            String abc = "ABCDEFGHIJ";
            do 
                col = sc.next().toUpperCase();
            while (abc.indexOf(col) == -1);
            // La columna y fila para ubicar al soldado son posibles presentaciones del sistema cartesiano
            System.out.print("Puntos de vida: ");
            punt = sc.nextInt();
            ejercito[i] = new Soldado();
            ejercito[i].setNombre(nomb);
            ejercito[i].setFila(fil);
            ejercito[i].setColumna(col);
            ejercito[i].setVida(punt);
        }
        System.out.println("\nGenerando soldados...");
        System.out.println("\nSoldados: ");
        mostrarSoldados(ejercito);
        System.out.print("\nPuntos de vida por ejercito: ");
        mostrarPorPuntos(ejercito);
        System.out.println("\nEn el campo de batalla, el soldado con mayor puntos de vida es: ");
        mostrarMayorVida(ejercito);
    }
    public static void mostrarSoldados(Soldado [] ejercito){
        for (int i = 0; i < ejercito.length; i++){
            System.out.println("\nSoldado" + i + ": " + ejercito[i].getNombre());
            System.out.println("Ubicacion: " + ejercito[i].getColumna() + "-" + ejercito[i].getFila());
            System.out.println("Puntos de vida: " + ejercito[i].getVida());
        }        
    }
    public static void mostrarPorPuntos(Soldado [] ejercito){
        for (int i = 0; i < ejercito.length; i++){
            System.out.println("\nSoldado" + i + ": " + ejercito[i].getNombre());
            System.out.println("Ubicacion: " + ejercito[i].getColumna() + "-" + ejercito[i].getFila());
            System.out.println("Puntos de vida: " + ejercito[i].getVida());
        }        
    }
    public static void mostrarMayorVida(Soldado [] ejercito){
        int mayor = ejercito[0].getVida();
        int idx = 0;
        for (int i = 0; i < ejercito.length; i++)
            if (ejercito[i].getVida() > mayor){
                mayor = ejercito[i].getVida();
                idx = i;
            }
        System.out.println("Soldado" + idx + ": " + ejercito[idx].getNombre());
        System.out.println("Ubicacion: " + ejercito[idx].getColumna() + "-" + ejercito[idx].getFila());
        System.out.println("Puntos de vida: " + ejercito[idx].getVida());
    }   
}
