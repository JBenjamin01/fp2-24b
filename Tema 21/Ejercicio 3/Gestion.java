import java.util.*;
import java.io.*;

public class Gestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Ingrese el número de alumnos a registrar: ");
            int n = sc.nextInt();
            sc.nextLine();

            List<Alumno> alumnos = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                System.out.println("Ingrese los datos del alumno " + (i + 1) + ":");
                System.out.print("CUI: ");
                String cui = sc.nextLine();
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Edad: ");
                int edad = sc.nextInt();
                sc.nextLine();

                alumnos.add(new Alumno(cui, nombre, edad));
            }

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("alumnos.bin"))) {
                for (Alumno a : alumnos) {
                    out.writeObject(a);
                }
            }

            List<Alumno> alumnosLeidos = new ArrayList<>();
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("alumnos.bin"))) {
                while (true) {
                    try {
                        Alumno a = (Alumno) in.readObject();
                        alumnosLeidos.add(a);
                    } catch (EOFException e) {
                        break;
                    }
                }
            }

            System.out.println("\nAlumnos leídos del archivo:");
            for (Alumno a : alumnosLeidos) {
                System.out.println(a);
            }

            alumnosLeidos.sort(Comparator.comparingInt(Alumno::getEdad));

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("alumnosOrdenados.bin"))) {
                for (Alumno a : alumnosLeidos) {
                    out.writeObject(a);
                }
            }

            System.out.println("\nAlumnos ordenados por edad y guardados en 'alumnosOrdenados.bin'.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}