import java.util.*;
public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Contacto> contactos = new ArrayList<>();

        // Llenar el ArrayList con contactos
        boolean continuar = true;
        while (continuar) {
            System.out.print("Ingresa el nombre del contacto: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingresa el teléfono del contacto: ");
            String telefono = scanner.nextLine();

            System.out.print("Ingresa el email del contacto: ");
            String email = scanner.nextLine();

            contactos.add(new Contacto(nombre, telefono, email));

            System.out.print("¿Deseas añadir otro contacto? (si/no): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("no")) {
                continuar = false;
            }
        }

        // Ordenar el ArrayList de contactos por nombre para realizar la búsqueda binaria
        Collections.sort(contactos, Comparator.comparing(Contacto::getNombre));

        // Imprimir todos los contactos
        System.out.println("\nLista de contactos:");
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }

        // Realizar búsqueda binaria
        System.out.print("\nIngresa el nombre del contacto que deseas buscar: ");
        String nombreBuscar = scanner.nextLine();

        int indexEncontrado = Collections.binarySearch(contactos, new Contacto(nombreBuscar, "", ""), Comparator.comparing(Contacto::getNombre));

        if (indexEncontrado >= 0) {
            System.out.println("Contacto encontrado: " + contactos.get(indexEncontrado));
        } else {
            System.out.println("El contacto no se encontró.");
        }
    }
}
