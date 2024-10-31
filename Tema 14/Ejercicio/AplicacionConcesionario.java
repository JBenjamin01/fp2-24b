import java.util.*;
public class AplicacionConcesionario {
    public static void main(String[] args) {
        // Antes del menú creo algunos objetos predefinidos 
        Gerente elGerente = new Gerente("Juan Perez", "1234567", 5000.0);
        Concesionario miEmpresa = new Concesionario("Carros EPIS - OK", elGerente);
        
        Vendedor nicole = new Vendedor("Nicole Betz", "Calle Peral", "977846512");
        Vendedor vince = new Vendedor("Vince Sola", "Calle M. Grau", "965152132");
        miEmpresa.addVendedor(nicole);
        miEmpresa.addVendedor(vince);
        miEmpresa.addAuto(new Auto("BMW a", "123", 2000.0, 2010));
        miEmpresa.addAuto(new Auto("Ford Fiesta", "456", 1500.0, 2015));
        miEmpresa.addAuto(new Auto("Chevrolet Spark", "789", 1000.0, 2018));
        miEmpresa.addAuto(new Auto("Honda", "789", 10000.0, 2018));

        menu(miEmpresa);
    }

    public static void menu(Concesionario concesionario) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú Concesionario:");
            System.out.println("1. Añadir Vendedor");
            System.out.println("2. Añadir Auto");
            System.out.println("3. Imprimir Estatus del Concesionario");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    añadirVendedor(concesionario, sc);
                    break;
                case 2:
                    añadirAuto(concesionario, sc);
                    break;
                case 3:
                    concesionario.imprimirEstatus();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    public static void añadirVendedor(Concesionario concesionario, Scanner sc) {
        System.out.print("Ingrese el nombre del vendedor: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la dirección del vendedor: ");
        String direccion = sc.nextLine();
        System.out.print("Ingrese el teléfono del vendedor: ");
        String telefono = sc.nextLine();

        Vendedor nuevoVendedor = new Vendedor(nombre, direccion, telefono);
        concesionario.addVendedor(nuevoVendedor);
        System.out.println("Vendedor añadido exitosamente.\n");
    }

    public static void añadirAuto(Concesionario concesionario, Scanner sc) {
        System.out.print("Ingrese la marca del auto: ");
        String marca = sc.nextLine();
        System.out.print("Ingrese el modelo del auto: ");
        String modelo = sc.nextLine();
        System.out.print("Ingrese el precio del auto: ");
        double precio = sc.nextDouble();
        System.out.print("Ingrese el año del auto: ");
        int año = sc.nextInt();
        sc.nextLine();

        Auto nuevoAuto = new Auto(marca, modelo, precio, año);
        concesionario.addAuto(nuevoAuto);
        System.out.println("Auto añadido exitosamente.\n");
    }
}
