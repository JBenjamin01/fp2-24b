import java.util.*;

public class Notas {
    private static int [] notas;
    static Scanner sc = new Scanner(System.in);

    public static void ingresarNotas() {
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Ingresa la nota: ");
            notas[i] = sc.nextInt();
        }
    }
    
    public static void imprimirNotas() {
        System.out.println("Lista de notas ingresadas:");
        for (int nota : notas)
            System.out.println("- " + nota);
    }

    public static void main(String[] args) {
        System.out.print("Ingresa la cantidad de notas: ");
        int n = sc.nextInt();

        notas = new int[n];

        ingresarNotas();
        imprimirNotas();
    }
}