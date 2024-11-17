public class Main {
    public static void main(String[] args) {
        Object[] figuras = new Object[3];

        figuras[0] = new Triangulo(7, 9);
        figuras[1] = new Rectangulo(12, 10.5);
        figuras[2] = new Circulo(9);

        for (Object f : figuras) {
            System.out.println(f.toString());
        }
    }
}