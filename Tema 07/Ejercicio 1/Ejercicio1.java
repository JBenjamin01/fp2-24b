import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear el primer soldado
        System.out.print("Ingrese el nombre del Soldado 1: ");
        String nombre1 = sc.nextLine();
        System.out.print("Ingrese la columna (A-J) del Soldado 1: ");
        char columna1 = sc.next().charAt(0);
        System.out.print("Ingrese la fila (1-10) del Soldado 1: ");
        int fila1 = sc.nextInt();
        Soldado soldado1 = new Soldado(nombre1, columna1, fila1);

        // Crear el segundo soldado
        System.out.print("Ingrese el nombre del Soldado 2: ");
        sc.nextLine(); // Esta linea limpia el buffer
        String nombre2 = sc.nextLine();
        System.out.print("Ingrese la columna (A-J) del Soldado 2: ");
        char columna2 = sc.next().charAt(0);
        System.out.print("Ingrese la fila (1-10) del Soldado 2: ");
        int fila2 = sc.nextInt();
        Soldado soldado2 = new Soldado(nombre2, columna2, fila2);

        // Mostrar los resultados
        System.out.println(soldado1);
        System.out.println(soldado2);
    }
}
