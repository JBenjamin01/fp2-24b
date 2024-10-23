import java.util.*;
public class Main {
    // Lista para almacenar las jarras creadas
    private static ArrayList<PennyJar> jarras = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenú:");
            System.out.println("1. Crear nueva jarra");
            System.out.println("2. Insertar moneda en una jarra");
            System.out.println("3. Ver número de monedas en una jarra específica");
            System.out.println("4. Ver número total de monedas en todas las jarras");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    PennyJar newJar = new PennyJar();
                    jarras.add(newJar);
                    System.out.println("¡Jarra creada! Ahora tienes " + jarras.size() + " jarras.");
                    break;
                case 2:
                    if (jarras.isEmpty()) {
                        System.out.println("No hay jarras disponibles. Crea una jarra primero.");
                    } else {
                        System.out.println("Elige una jarra (1 a " + jarras.size() + "): ");
                        int jarIndex = sc.nextInt();
                        if (jarIndex > 0 && jarIndex <= jarras.size()) {
                            jarras.get(jarIndex - 1).addPenny();
                        } else {
                            System.out.println("Índice de jarra no válido.");
                        }
                    }
                    break;
                case 3:
                    if (jarras.isEmpty()) {
                        System.out.println("No hay jarras disponibles. Crea una jarra primero.");
                    } else {
                        System.out.println("Elige una jarra (1 a " + jarras.size() + "): ");
                        int jarIndex = sc.nextInt();
                        if (jarIndex > 0 && jarIndex <= jarras.size()) {
                            System.out.println("Monedas en jarra " + jarIndex + ": " + jarras.get(jarIndex - 1).getPennies());
                        } else {
                            System.out.println("Índice de jarra no válido.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Monedas totales en todas las jarras: " + PennyJar.getAllPennies());
                    break;
                case 5:
                    exit = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}