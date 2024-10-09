import java.util.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean continuar = true;

        System.out.print("=== Simulador de Guerra entre dos Reinos ===");

        while (continuar) {
            System.out.print("\nIngrese el nombre del primer reino: ");
            String nombreReino1 = sc.nextLine().trim();
            while (nombreReino1.isEmpty()) {
                System.out.print("El nombre no puede estar vacío. Ingrese nuevamente: ");
                nombreReino1 = sc.nextLine().trim();
            }

            System.out.print("Ingrese el nombre del segundo reino: ");
            String nombreReino2 = sc.nextLine().trim();
            while (nombreReino2.isEmpty()) {
                System.out.print("El nombre no puede estar vacío. Ingrese nuevamente: ");
                nombreReino2 = sc.nextLine().trim();
            }

            Reino reino1 = new Reino(nombreReino1);
            Reino reino2 = new Reino(nombreReino2);

            // simulación de la guerra
            Guerra guerra = new Guerra(reino1, reino2);
            guerra.simularGuerra();

            System.out.print("\n¿Desea iniciar otra guerra? (S/N): ");
            String respuesta = sc.nextLine().trim().toUpperCase();

            while (!respuesta.equals("S") && !respuesta.equals("N")) {
                System.out.print("Respuesta inválida. Ingrese 'S' para sí o 'N' para no: ");
                respuesta = sc.nextLine().trim().toUpperCase();
            }

            if (respuesta.equals("N")) {
                continuar = false;
                System.out.println("\n¡Gracias por jugar este simulador de guerra! Hasta luego ;)");
            }
        }
    }
}