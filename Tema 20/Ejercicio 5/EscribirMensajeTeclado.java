import java.io.*;
import java.util.*;
public class EscribirMensajeTeclado {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = sc.nextLine();
        System.out.print("Ingrese el mensaje: ");
        String mensaje = sc.nextLine();

        BufferedWriter w = new BufferedWriter(new FileWriter(nombreArchivo));
        w.write(mensaje);
        w.close();
    }
}