public class Imaginario {
    private double real;
    private double imaginario;

    // Constructores sobrecargados
    public Imaginario() {
        this(0, 0);
    }

    public Imaginario(double real) {
        this(real, 0);
    }

    public Imaginario(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    // Getters Y setters
    public double getReal() {
        return real;
    }
    
    public double getImaginario() {
        return imaginario;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginario(double imaginario) {
        this.imaginario = imaginario;
    }

    // Formatos para mostrar el numero imaginario
    public String formato1() {
        return "(" + real + ", " + imaginario + ")";
    }

    public String formato2() {
        return real + " + " + imaginario + "i";
    }

    // Operaciones con los primeros números del arreglo
    // Métodos de instancia
    public Imaginario sumar(Imaginario i) {
        return new Imaginario(this.real + i.real, this.imaginario + i.imaginario);
    }

    public Imaginario restar(Imaginario i) {
        return new Imaginario(this.real - i.real, this.imaginario - i.imaginario);
    }

    public Imaginario multiplicar(Imaginario i) {
        double parteReal = this.real * i.real - this.imaginario * i.imaginario;
        double parteImaginaria = this.real * i.imaginario + this.imaginario * i.real;
        return new Imaginario(parteReal, parteImaginaria);
    }

    // Métodos de clase
    public static Imaginario sumar(Imaginario i1, Imaginario i2) {
        return new Imaginario(i1.real + i2.real, i1.imaginario + i2.imaginario);
    }
    
    public static Imaginario restar(Imaginario i1, Imaginario i2) {
        return new Imaginario(i1.real - i2.real, i1.imaginario - i2.imaginario);
    }

    public static Imaginario multiplicar(Imaginario i1, Imaginario i2) {
        double parteReal = i1.real * i2.real - i1.imaginario * i2.imaginario;
        double parteImaginaria = i1.real * i2.imaginario + i1.imaginario * i2.real;
        return new Imaginario(parteReal, parteImaginaria);
    }

    // Otros métodos
    public double modulo() {
        return Math.sqrt(real * real + imaginario * imaginario);
    }

    public Imaginario conjugado() {
        return new Imaginario(real, -imaginario);
    }
}