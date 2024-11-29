import java.io.*;
public class EscribirMensaje {
    public static void main(String[] args) throws IOException {
        BufferedWriter w = new BufferedWriter(new FileWriter("mensaje.txt"));
        w.write("hola amigos, como estan");
        w.close();
    }
}