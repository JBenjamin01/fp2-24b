import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Imaginario> imaginarios = new ArrayList<>();
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Crear ArrayList de Imaginarios");
            System.out.println("2. Mostrar todos los Imaginarios creados");
            System.out.println("3. Realizar operaciones (de 2 primeros Imaginarios almacenados)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la parte real: ");
                    double real = sc.nextDouble();
                    System.out.print("Ingrese la parte imaginaria: ");
                    double imaginario = sc.nextDouble();
                    imaginarios.add(new Imaginario(real, imaginario));
                    break;
                case 2:
                    for (Imaginario i : imaginarios) {
                        System.out.println(i.formato1() + " o " + i.formato2());
                    }
                    break;
                case 3:
                    if (imaginarios.size() < 2) {
                        System.out.println("Se necesitan al menos 2 Imaginarios para realizar operaciones.");
                        break;
                    }
                    Imaginario i1 = imaginarios.get(0);
                    Imaginario i2 = imaginarios.get(1);

                    // Suma
                    Imaginario suma1 = i1.sumar(i2);
                    Imaginario suma2 = Imaginario.sumar(i1, i2);
                    Imaginario suma3 = sumar(i1, i2);
                    System.out.println("Suma: " + suma1.formato2() + ", "
                                        + suma2.formato2() + ", " + suma3.formato2());

                    // Resta
                    Imaginario resta1 = i1.restar(i2);
                    Imaginario resta2 = Imaginario.restar(i1, i2);
                    Imaginario resta3 = restar(i1, i2);
                    System.out.println("Resta: " + resta1.formato2() + ", "
                                        + resta2.formato2() + ", " + resta3.formato2());

                    // Multiplicación
                    Imaginario multiplicacion1 = i1.multiplicar(i2);
                    Imaginario multiplicacion2 = Imaginario.multiplicar(i1, i2);
                    Imaginario multiplicacion3 = multiplicar(i1, i2);
                    System.out.println("Multiplicación: " + multiplicacion1.formato2() + ", "
                                        + multiplicacion2.formato2() + ", " + multiplicacion3.formato2());

                    // Módulo
                    System.out.println("Módulo de " + i1.formato2() + ": " + i1.modulo());

                    // Conjugado
                    System.out.println("Conjugado de " + i1.formato2() + ": " + i1.conjugado().formato2());
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    public static Imaginario sumar(Imaginario i1, Imaginario i2) {
        return i1.sumar(i2);
    }

    public static Imaginario restar(Imaginario i1, Imaginario i2) {
        return i1.restar(i2);
    }

    public static Imaginario multiplicar(Imaginario i1, Imaginario i2) {
        return i1.multiplicar(i2);
    }
}