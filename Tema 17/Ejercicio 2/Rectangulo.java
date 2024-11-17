class Rectangulo extends Shape {
    private double ancho;
    private double altura;

    // Constructor
    public Rectangulo(Color color, Punto origen, double ancho, double altura) {
        super(color, origen);  // Llamada al constructor de la clase base
        this.ancho = ancho;
        this.altura = altura;
    }

    // Implementación de los métodos abstractos
    @Override
    public double calcularArea() {
        return ancho * altura;  // Fórmula: ancho * altura
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (ancho + altura);  // Fórmula: 2 * (ancho + altura)
    }

    @Override
    public String toString() {
        return "Rectángulo [Ancho: " + ancho + ", Altura: " + altura + ", " + super.toString() + "]";
    }
}