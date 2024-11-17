public class Rectangulo {
    private double largo;
    private double ancho;

    public Rectangulo(double largo, double ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    public double calcularArea() {
        return largo * ancho;
    }

    @Override
    public String toString() {
        return "Rectangulo --> [Largo: " + largo + " - Ancho: " + ancho + " | Area = " + calcularArea() + "]";
    }
}