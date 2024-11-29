import java.io.*;
import java.util.*;
public class LeerConArreglo {
    public static void main(String[] args) throws IOException {
        int[] lanzamientos = leerLanzamientos("numeritosAleatorios.txt");
        System.out.println("Lanzamientos leídos: " + Arrays.toString(lanzamientos));
    }

    public static int[] leerLanzamientos(String archivo) throws IOException {
        int[] lanzamientos = new int[10];
        BufferedReader r = new BufferedReader(new FileReader(archivo));
        for (int i = 0; i < 10; i++) {
            lanzamientos[i] = Integer.parseInt(r.readLine());
        }
        r.close();
        return lanzamientos;
    }
}