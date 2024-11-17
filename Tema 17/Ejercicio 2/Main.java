import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Crear un ArrayList para almacenar figuras
        ArrayList<Shape> figuras = new ArrayList<>();
        Random rand = new Random();

        // Crear objetos Color (por ejemplo, colores aleatorios)
        Color color1 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        Color color2 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

        // Crear objetos Punto (por ejemplo, en posiciones aleatorias)
        Punto origen1 = new Punto(rand.nextDouble() * 10, rand.nextDouble() * 10);
        Punto origen2 = new Punto(rand.nextDouble() * 10, rand.nextDouble() * 10);

        // Crear y añadir algunos círculos y rectángulos al ArrayList
        figuras.add(new Circulo(color1, origen1, rand.nextDouble() * 5 + 1));  // Círculo con radio aleatorio
        figuras.add(new Rectangulo(color2, origen2, rand.nextDouble() * 5 + 1, rand.nextDouble() * 5 + 1));  // Rectángulo con ancho y altura aleatorios

        // Mostrar los detalles de todas las figuras
        for (Shape figura : figuras) {
            figura.mostrarDetalles();
            System.out.println("------------------------");
        }
    }
}