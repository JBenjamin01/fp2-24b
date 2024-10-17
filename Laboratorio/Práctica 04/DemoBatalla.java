// LABORATORIO N° 4 - EJERCICIO 1
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES
// TIEMPO: 49 MINUTOS
import java.util.*;
public class DemoBatalla {
    public static void main(String [] args){
        Nave [] misNaves = new Nave[5];
        Scanner sc = new Scanner(System.in);
        String nomb, col, nombre;
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

        System.out.println("\nBUSQUEDA LINEAL:");
        System.out.print("\nIngrese el nombre de la nave que quiere buscar: ");
        nombre = sc.next();
        int pos = busquedaLinealNombre(misNaves, nombre);
        if (pos != -1){
            mostrarNaveEspecifica(misNaves, pos);
        } else {
            System.out.println("No se ha encontrado la nave");
        }

        // BURBUJA
        System.out.println("\nOrdenamiento de las naves por el algoritmo Burbuja:");
        System.out.println("\nPor puntos:");
        ordenarPorPuntosBurbuja(misNaves);
        mostrarNaves(misNaves);
        System.out.println("\nPor nombres:");
        ordenarPorNombreBurbuja(misNaves);
        mostrarNaves(misNaves);

        System.out.println("\nSe han ordenado exitosamente las naves, puede buscar por la forma binaria:");
        System.out.println("\nBUSQUEDA BINARIA:");
        System.out.print("\nIngrese el nombre de la nave que quiere buscar: ");
        nombre = sc.next();
        int pos1 = busquedaBinariaNombre(misNaves, nombre);
        if (pos1 != -1)
            mostrarNaveEspecifica(misNaves, pos1);
        else 
            System.out.println("No se ha encontrado la nave");
        System.out.println("\nORDENAMIENTO POR PUNTOS (SELECCIÓN):");
        ordenarPorPuntosSeleccion(misNaves);
        mostrarNaves(misNaves);
        System.out.println("\nORDENAMIENTO POR NOMBRES (SELECCIÓN):");
        ordenarPorNombreSeleccion(misNaves);
        mostrarNaves(misNaves);
        System.out.println("\nORDENAMIENTO POR PUNTOS (INSERCIÓN):");
        ordenarPorPuntosInsercion(misNaves);
        mostrarNaves(misNaves);
        System.out.println("\nORDENAMIENTO POR NOMBRES (INSERCIÓN):");
        ordenarPorNombreInsercion(misNaves);
        mostrarNaves(misNaves);
    }
    public static void mostrarNaveEspecifica(Nave [] flota, int n){
        System.out.println("\nNave " + (n + 1)+ ": " + flota[n].getNombre());
        System.out.println("Ubicacion: " + flota[n].getColumna() + "-" + flota[n].getFila());
        if (flota[n].getEstado() == true)
            System.out.println("Estado: Activo");
        else
            System.out.println("Estado: Inactivo");
        System.out.println("Puntos: " + flota[n].getPuntos());
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
    public static int busquedaLinealNombre(Nave[] flota, String s){
        for (int i = 0; i < flota.length; i++) 
            if (flota[i].getNombre().equalsIgnoreCase(s)) 
                return i;
        return -1;
    }
    public static void ordenarPorPuntosBurbuja(Nave[] flota){
        int n = flota.length;
        for (int i = 0; i < n - 1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (flota[j].getPuntos() > flota[j+1].getPuntos()) {
                    Nave temp = flota[j];
                    flota[j] = flota[j + 1];
                    flota[j + 1] = temp;
                }
    }
    public static void ordenarPorNombreBurbuja(Nave[] flota){
        int n = flota.length;
        for (int i = 0; i < n - 1; i++) 
            for (int j = 0; j < n - i - 1; j++)
                if (flota[j].getNombre().compareTo(flota[j + 1].getNombre()) > 0) {
                    Nave temp = flota[j];
                    flota[j] = flota[j + 1];
                    flota[j + 1] = temp;
                }
    }
    public static int busquedaBinariaNombre(Nave[] flota, String s){
        int left = 0;
        int right = flota.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = flota[mid].getNombre().compareTo(s);
            if (comparison == 0)
                return mid;
            if (comparison < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
    public static void ordenarPorPuntosSeleccion(Nave[] flota){
        int n = flota.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (flota[j].getPuntos() < flota[minIdx].getPuntos())
                    minIdx = j;
            }
            Nave temp = flota[minIdx];
            flota[minIdx] = flota[i];
            flota[i] = temp;
        }
    }
    public static void ordenarPorNombreSeleccion(Nave[] flota){
        int n = flota.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) 
                if (flota[j].getNombre().compareTo(flota[minIdx].getNombre()) < 0)
                    minIdx = j;
            Nave temp = flota[minIdx];
            flota[minIdx] = flota[i];
            flota[i] = temp;
        }
    }
    public static void ordenarPorPuntosInsercion(Nave[] flota){
        int n = flota.length;
        for (int i = 1; i < n; ++i) {
            Nave key = flota[i];
            int j = i - 1;
            while (j >= 0 && flota[j].getPuntos() > key.getPuntos()) {
                flota[j + 1] = flota[j];
                j = j - 1;
            }
            flota[j + 1] = key;
        }
    }
    public static void ordenarPorNombreInsercion(Nave[] flota){
        int n = flota.length;
        for (int i = 1; i < n; ++i) {
            Nave key = flota[i];
            int j = i - 1;
            while (j >= 0 && flota[j].getNombre().compareTo(key.getNombre()) > 0) {
                flota[j + 1] = flota[j];
                j = j - 1;
            }
            flota[j + 1] = key;
        }
    }
}
