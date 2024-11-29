import java.io.*;
import java.util.*;
public class AñadirMensajeArchivo {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = sc.nextLine();
        System.out.print("Ingrese el mensaje inicial: ");
        String mensajeInicial = sc.nextLine();

        BufferedWriter w = new BufferedWriter(new FileWriter(nombreArchivo));
        w.write(mensajeInicial);
        w.close();

        System.out.print("Ingrese el segundo mensaje para añadir: ");
        String mensajeAdicional = sc.nextLine();
        w = new BufferedWriter(new FileWriter(nombreArchivo, true));
        w.write("\n" + mensajeAdicional);
        w.close();
    }
}