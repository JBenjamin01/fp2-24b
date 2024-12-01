import java.io.*;

public class FileWriter {
    public static void main(String[] args) {
        String fileName = "data.bin";
        String tableName = "Ejemplo";
        int numRecords = 5;
        int[] numbers = {10, 20, 30, 40, 50};

        try (DataOutputStream fileOut = new DataOutputStream(new FileOutputStream(fileName))) {
            for (char ch : tableName.toCharArray())
                fileOut.writeChar(ch);
            
            fileOut.writeChar('\0');

            fileOut.writeInt(numRecords);

            for (int number : numbers) 
                fileOut.writeInt(number);

            System.out.println("Archivo generado correctamente: " + fileName);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}