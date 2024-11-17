abstract class Shape {
    protected Color color;
    protected Punto origen;

    // Constructor 1: Sin parámetros
    public Shape() {
        this.color = new Color(0, 0, 0); // Color negro por defecto
        this.origen = new Punto(0, 0);  // Origen en (0, 0) por defecto
    }

    // Constructor 2: Con color y origen
    public Shape(Color color, Punto origen) {
        this.color = color;
        this.origen = origen;
    }

    // Constructor 3: Con color solo, origen en (0, 0)
    public Shape(Color color) {
        this.color = color;
        this.origen = new Punto(0, 0);
    }

    // Métodos abstractos
    public abstract double calcularArea();
    public abstract double calcularPerimetro();

    // Métodos getter y setter
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Punto getOrigen() {
        return origen;
    }

    public void setOrigen(Punto origen) {
        this.origen = origen;
    }

    // Método para mostrar los detalles de la figura
    public void mostrarDetalles() {
        System.out.println("Color: " + color);
        System.out.println("Origen: " + origen);
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
    }
}
