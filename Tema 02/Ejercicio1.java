import java.util.*;
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingresa el número de personas: ");
        int n = sc.nextInt();
        
        Persona[] personas = new Persona[n];
        
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            System.out.println("Persona " + (i + 1) + ":");
            
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            
            System.out.print("Género (M/F): ");
            char genero = sc.next().charAt(0);
            
            personas[i] = new Persona(nombre, edad, genero);
        }
        
        System.out.println("\nLista de personas ingresadas:");
        for (int i = 0; i < n; i++) 
            System.out.println("- " + personas[i]);
    }
}