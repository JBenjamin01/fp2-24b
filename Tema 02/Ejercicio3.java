import java.util.*;
public class Ejercicio3 {
    private static Contacto[] contactos = new Contacto[100];
    private static int c = 0;

    public static void ingresarContactos() {
        Scanner sc = new Scanner(System.in);
        String nombre, celular;
        
        while (true) {
            System.out.print("Ingresa el nombre del contacto (o 'q' para salir): ");
            nombre = sc.nextLine();
            
            if (nombre.equalsIgnoreCase("q"))
                break;
            
            do {
                System.out.print("Ingresa el número de teléfono: ");
                celular = sc.nextLine();
                
                if (esNumeroValido(celular))
                    break;
                else
                    System.out.println("Número inválido. Debe contener exactamente 9 dígitos.");
            } while (true);
            
            contactos[c++] = new Contacto(nombre, celular);
        }
    }

    public static boolean esNumeroValido(String numero) {
        if (numero.length() != 9) return false;
        
        for (int i = 0; i < numero.length(); i++)
            if (!Character.isDigit(numero.charAt(i)))
                return false;
        return true;
    }

    public static void imprimirContactos() {
        System.out.println("\nContactos ingresados:");
        for (int i = 0; i < c; i++)
            System.out.println(contactos[i]);
    }

    public static void buscarContacto(String nombre) {
        for (int i = 0; i < c; i++)
            if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("El número de " + nombre + " es: " + contactos[i].getCelular());
                return;
            }
        System.out.println("No se encontró un contacto con el nombre: " + nombre);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ingresarContactos();
        
        imprimirContactos();
        
        System.out.print("\nIngresa el nombre del contacto para buscar su número: ");
        String nombreBuscado = sc.nextLine();
        buscarContacto(nombreBuscado);
        
        sc.close();
    }
}