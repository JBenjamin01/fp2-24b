// LABORATORIO N° 3 - EJERCICIO 1
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES
// TIEMPO: 57 MINUTOS
import java.util.*;
public class DemoBatalla {
    public static void main(String [] args){
        Nave [] misNaves = new Nave[5];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;
        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.print("Fila (Entre 1 y 10): ");
            do
                fil = sc.nextInt();
            while (fil > 10 || fil < 1);
            System.out.print("Columna (De la A a la J): ");
            String abc = "ABCDEFGHIJ";
            do 
                col = sc.next().toUpperCase();
            while (abc.indexOf(col) == -1);
            System.out.print("Estado: ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();

            misNaves[i] = new Nave();

            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
        }
        System.out.println("\nGenerando naves...");
        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);
        System.out.print("\nIntroduzca el nombre de la nave que desea buscar: ");
        mostrarPorNombre(misNaves);
        System.out.print("\nIntroduzca los puntos maximos que puede tener una nave: ");
        mostrarPorPuntos(misNaves);
        System.out.println("\nEn su flota, la nave con el mayor numero de puntos es:");
        mostrarMayorPuntos(misNaves);
    }
    public static void mostrarNaves(Nave [] flota){
        for (int i = 0; i < flota.length; i++){
            System.out.println("\nNave " + (i + 1)+ ": " + flota[i].getNombre());
            System.out.println("Ubicacion: " + flota[i].getColumna() + "-" + flota[i].getFila());
            if (flota[i].getEstado() == true)
                System.out.println("Estado: Activo");
            else
                System.out.println("Estado: Inactivo");
            System.out.println("Puntos: " + flota[i].getPuntos());
        }        
    }
    public static void mostrarPorNombre(Nave [] flota){
        Scanner sc = new Scanner(System.in);
        String nombre = sc.next();
        for (int i = 0; i < flota.length; i++)
            if (nombre.equals(flota[i].getNombre())){
                System.out.println("Nave " + (i + 1) + ": " + nombre);
                System.out.println("Ubicacion: " + flota[i].getColumna() + "-" + flota[i].getFila());
                if (flota[i].getEstado() == true)
                    System.out.println("Estado: Activo");
                else
                    System.out.println("Estado: Inactivo");
                System.out.println("Puntos: " + flota[i].getPuntos());
            }
    }
    public static void mostrarPorPuntos(Nave [] flota){
        Scanner sc = new Scanner(System.in);
        int puntos = sc.nextInt();
        System.out.println("Lista de naves con puntos menores o iguales a " + puntos + ":");
        for (int i = 0; i < flota.length; i++)
            if (puntos >= flota[i].getPuntos()){
                System.out.println("Nave " + (i + 1) + ": " + flota[i].getNombre());
                System.out.println("Ubicacion: " + flota[i].getColumna() + "-" + flota[i].getFila());
                if (flota[i].getEstado() == true)
                    System.out.println("Estado: Activo");
                else
                    System.out.println("Estado: Inactivo");
                System.out.println("Puntos: " + flota[i].getPuntos());
            }
    }
    public static void mostrarMayorPuntos(Nave [] flota){
        int mayor = flota[0].getPuntos();
        int idx = 0;
        for (int i = 0; i < flota.length; i++)
            if (flota[i].getPuntos() > mayor){
                mayor = flota[i].getPuntos();
                idx = i;
            }
        System.out.println("Nave " + (idx + 1) + ": " + flota[idx].getNombre());
        System.out.println("Ubicacion: " + flota[idx].getColumna() + "-" + flota[idx].getFila());
        if (flota[idx].getEstado() == true)
            System.out.println("Estado: Activo");
        else
            System.out.println("Estado: Inactivo");
        System.out.println("Puntos: " + flota[idx].getPuntos());
    }
}
