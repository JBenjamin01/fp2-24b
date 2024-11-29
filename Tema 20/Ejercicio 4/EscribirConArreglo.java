import java.io.*;
import java.util.*;
public class EscribirConArreglo {
    public static void main(String[] args) throws IOException {
        int[] lanzamientos = generarLanzamientos();
        escribirLanzamientos(lanzamientos, "lanzamientos.txt");
    }

    public static int[] generarLanzamientos() {
        int[] lanzamientos = new int[10];
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            lanzamientos[i] = r.nextInt(6) + 1;
        }
        return lanzamientos;
    }

    public static void escribirLanzamientos(int[] lanzamientos, String archivo) throws IOException {
        BufferedWriter w = new BufferedWriter(new FileWriter(archivo));
        for (int lanzamiento : lanzamientos) {
            w.write(lanzamiento + "\n");
        }
        w.close();
    }
}