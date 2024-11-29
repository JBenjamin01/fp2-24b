import java.io.*;
import java.util.*;
public class EscribirNumeritosAleatorios {
    public static void main(String[] args) throws IOException {
        BufferedWriter w = new BufferedWriter(new FileWriter("numeritosAleatorios.txt"));
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            w.write((r.nextInt(6) + 1) + "\n");
        }
        w.close();
    }
}