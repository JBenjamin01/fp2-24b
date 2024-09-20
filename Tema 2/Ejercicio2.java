import java.util.*;
public class Ejercicio2 {
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
        
        // EJERCICIO 2:

        Persona masJoven = personas[0];
        Persona masMayor = personas[0];
        
        for (int i = 1; i < n; i++) {
            if (personas[i].getEdad() < masJoven.getEdad())
                masJoven = personas[i];
            if (personas[i].getEdad() > masMayor.getEdad())
                masMayor = personas[i];
        }
        
        System.out.println("\nEl amigo más joven es:");
        System.out.println(masJoven);
        
        System.out.println("\nEl amigo más viejo es:");
        System.out.println(masMayor);
    }
}
