import java.io.*;
public class LeerNumeritos {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("numeritos.txt"));
        String linea;
        while ((linea = r.readLine()) != null) {
            System.out.println(linea);
        }
        r.close();
    }
}