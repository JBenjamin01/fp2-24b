public class Main {
    public static void main(String[] args) {
        Coordenada p1 = new Coordenada(11, 31);
        Coordenada p2 = new Coordenada(5, 16);

        double d1 = calcularDistancia1(p1, p2);
        System.out.println("Distancia (con el método en clase principal): " + d1);


        double d2 = p1.calcularDistancia2(5, 16);
        System.out.println("Distancia (con el método con 2 parámetros): " + d2);

        double d3 = p1.calcularDistancia3(p2);
        System.out.println("Distancia (con el método con 1 parámetro): " + d3);
    }
    
    public static double calcularDistancia1(Coordenada c1, Coordenada c2) {
        return Math.sqrt(Math.pow((c2.getX() - c1.getX()), 2) + Math.pow((c2.getY() - c1.getY()), 2));
    }
}