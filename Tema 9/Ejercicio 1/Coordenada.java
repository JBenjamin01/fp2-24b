public class Coordenada {
    private int x;
    private int y;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double calcularDistancia2(int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x), 2) + Math.pow((y2 - y), 2));
    }

    public double calcularDistancia3(Coordenada c) {
        return Math.sqrt(Math.pow((c.getX() - this.x), 2) + Math.pow((c.getY() - this.y), 2));
    }
}