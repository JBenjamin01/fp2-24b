import java.util.*;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        ArrayList<String> participantes = new ArrayList<>();

        System.out.print("Ingresa la cantidad de participantes: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Ingresa el nombre del participante #" + (i + 1) + ": ");
            String nombre = sc.nextLine();
            participantes.add(nombre);
        }

        while (participantes.size() > 1) {
            int indexEliminado = random.nextInt(participantes.size());
            String eliminado = participantes.remove(indexEliminado);

            System.out.println("Eliminado: " + eliminado);

            System.out.println("Quedan con vida: " + participantes);
        }

        System.out.println("El ganador del reality de supervivencia es: " + participantes.get(0) + "!!!");
    }
}