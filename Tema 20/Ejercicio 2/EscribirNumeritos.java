import java.io.*;
public class EscribirNumeritos {
    public static void main(String[] args) throws IOException {
        BufferedWriter w = new BufferedWriter(new FileWriter("numeritos.txt"));
        for (int i = 1; i <= 10; i++) {
            w.write(i + "\n");
        }
        w.close();
    }
}