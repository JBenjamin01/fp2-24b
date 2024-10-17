import java.util.*;

public class Numeros {
    private static String[] numeros = new String[100];
    private static int c = 0;
    public static void ingresarNumeros() {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        String s;
        do {
            System.out.print("Ingresa el número de celular  o 'q' para salir: ");
            s = sc.nextLine();
            if (!s.equals("q")) {
                if (s.length() == 9) {
                    numeros[i] = s;
                    c++;
                    i++;
                } else
                    System.out.println("El número debe tener 9 dígitos.");
            }
        }
        while (!s.equals("q") && i < 100);
    }
    
    public static void imprimir() {
        System.out.println("Números de celular ingresados:");
        for (int i = 0; i < c; i++)
            System.out.println(numeros[i]);
    }

    public static void main(String[] args) {
        ingresarNumeros();
        imprimir();
    }
}