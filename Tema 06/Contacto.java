import java.util.*;
public class Contacto {
    private String nombre;
    private String telefono;
    private String email;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Teléfono: " + telefono + ", Email: " + email;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Contacto> contactos = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {
            System.out.print("Ingresa el nombre del contacto: ");
            String nombre = sc.nextLine();

            System.out.print("Ingresa el teléfono del contacto: ");
            String telefono = sc.nextLine();

            System.out.print("Ingresa el email del contacto: ");
            String email = sc.nextLine();

            contactos.add(new Contacto(nombre, telefono, email));

            System.out.print("¿Deseas añadir otro contacto? (si/no): ");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("no")) {
                continuar = false;
            }
        }

        Collections.sort(contactos, Comparator.comparing(Contacto::getNombre));

        System.out.println("\nLista de contactos:");
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }

        System.out.print("\nIngresa el nombre del contacto que deseas buscar: ");
        String nombreBuscar = sc.nextLine();

        int indexEncontrado = Collections.binarySearch(contactos, new Contacto(nombreBuscar, "", ""), Comparator.comparing(Contacto::getNombre));

        if (indexEncontrado >= 0) {
            System.out.println("Contacto encontrado: " + contactos.get(indexEncontrado));
        } else {
            System.out.println("El contacto no se encontró.");
        }
    }
}