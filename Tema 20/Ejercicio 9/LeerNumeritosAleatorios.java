import java.io.*;
public class LeerNumeritosAleatorios {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("numeritosAleatorios.txt"));
        String linea;
        while ((linea = r.readLine()) != null) {
            System.out.println(linea);
        }
        r.close();
    }
}