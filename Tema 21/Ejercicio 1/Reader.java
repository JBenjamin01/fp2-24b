import java.io.*;
import java.util.*;

public class Reader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del archivo a leer: ");
        String fileName = sc.nextLine();
        
        try (DataInputStream fileIn = new DataInputStream(new FileInputStream(fileName))) {
            StringBuilder nombreTablaBuilder = new StringBuilder();
            char ch;
            while ((ch = fileIn.readChar()) != 0) {
                nombreTablaBuilder.append(ch);
            }
            String nombreTabla = nombreTablaBuilder.toString();
            
            int numRecords = fileIn.readInt();
            
            ArrayList<Integer> numeros = new ArrayList<>();
            for (int i = 0; i < numRecords; i++) 
                numeros.add(fileIn.readInt());
            
            System.out.println("Nombre de la tabla: " + nombreTabla);
            System.out.println("Número de registros: " + numRecords);
            System.out.println("Números leídos:");
            for (int n : numeros) 
                System.out.println(n);
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}