public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion() {
        this.numerador = 0;
        this.denominador = 1;
    }

    public Fraccion(Fraccion f) {
        this.numerador = f.numerador;
        this.denominador = f.denominador;
    }

    // Aquí se maneja la consistencia de los atributos de la fracción
    // También se le da los valores por defecto en caso de estar erróneos
    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            this.numerador = 0;
            this.denominador = 1;
        } else {
            this.numerador = numerador;
            this.denominador = denominador;
        }
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public void setDenominador(int denominador) {
        if (denominador != 0) {
            this.denominador = denominador;
        }
    }

    // Los formatos para mostrar la fracción
    public String mostrarFraccion() {
        return numerador + "/" + denominador;
    }

    public String mostrarDecimal() {
        return String.format("%.3f", (double) numerador / denominador);
    }

    // Operaciones
    public Fraccion sumar(Fraccion f) {
        this.numerador = this.numerador * f.denominador + f.numerador * this.denominador;
        this.denominador = this.denominador * f.denominador;
        simplificar();
        return this;
    }

    public Fraccion restar(Fraccion f) {
        this.numerador = this.numerador * f.denominador - f.numerador * this.denominador;
        this.denominador = this.denominador * f.denominador;
        simplificar();
        return this;
    }

    public Fraccion multiplicar(Fraccion f) {
        this.numerador = this.numerador * f.numerador;
        this.denominador = this.denominador * f.denominador;
        simplificar();
        return this;
    }

    public Fraccion dividir(Fraccion f) {
        this.numerador = this.numerador * f.denominador;
        this.denominador = this.denominador * f.numerador;
        simplificar();
        return this;
    }

    public Fraccion simplificar() {
        int mcd = mcd(numerador, denominador);
        this.numerador /= mcd;
        this.denominador /= mcd;
        return this;
    }

    // Maximo comun divisor privado
    private int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}