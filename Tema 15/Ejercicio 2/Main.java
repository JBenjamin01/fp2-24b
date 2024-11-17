public class Main {
    public static void main(String[] args) {
        Figura f;

        f = new Triangulo(3, 4);
        System.out.println(f);

        f = new Rectangulo(5, 6);
        System.out.println(f);

        f = new Circulo(7);
        System.out.println(f);
    }
}