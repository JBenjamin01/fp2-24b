import java.io.*;
import java.util.*;

public class Aleatorios {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Ingrese el nombre del archivo para guardar los números aleatorios: ");
            String archivoAleatorios = sc.nextLine();

            System.out.print("Ingrese el nombre del archivo para guardar los números ordenados: ");
            String archivoOrdenados = sc.nextLine();

            System.out.print("Ingrese el número de enteros (N): ");
            int n = sc.nextInt();

            System.out.print("Ingrese el valor mínimo del intervalo (x): ");
            int x = sc.nextInt();

            System.out.print("Ingrese el valor máximo del intervalo (y): ");
            int y = sc.nextInt();

            if (x > y) {
                System.out.println("El valor mínimo (x) no puede ser mayor que el máximo (y).");
                return;
            }

            Random r = new Random();
            List<Integer> numeros = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                numeros.add(r.nextInt(y - x + 1) + x);
            }

            try (DataOutputStream aleatorios = new DataOutputStream(new FileOutputStream(archivoAleatorios))) {
                for (int num : numeros) {
                    aleatorios.writeInt(num);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            System.out.println("Números aleatorios guardados en el archivo: " + archivoAleatorios);

            List<Integer> numerosLeidos = new ArrayList<>();
            try (DataInputStream randomFile = new DataInputStream(new FileInputStream(archivoAleatorios))) {
                while (randomFile.available() > 0) {
                    numerosLeidos.add(randomFile.readInt());
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            

            Collections.sort(numerosLeidos);

            try (DataOutputStream ordenados = new DataOutputStream(new FileOutputStream(archivoOrdenados))) {
                for (int num : numerosLeidos) {
                    ordenados.writeInt(num);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            System.out.println("Números ordenados guardados en el archivo: " + archivoOrdenados);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}