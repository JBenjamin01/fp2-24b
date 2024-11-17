class Circulo extends Shape {
    private double radio;

    // Constructor
    public Circulo(Color color, Punto origen, double radio) {
        super(color, origen);  // Llamada al constructor de la clase base
        this.radio = radio;
    }

    // Implementación de los métodos abstractos
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;  // Fórmula: π * r^2
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;  // Fórmula: 2 * π * r
    }

    @Override
    public String toString() {
        return "Círculo [Radio: " + radio + ", " + super.toString() + "]";
    }
}