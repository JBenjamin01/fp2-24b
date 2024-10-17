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
        int nuevoNumerador = this.numerador * f.denominador + f.numerador * this.denominador;
        int nuevoDenominador = this.denominador * f.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion restar(Fraccion f) {
        int nuevoNumerador = this.numerador * f.denominador - f.numerador * this.denominador;
        int nuevoDenominador = this.denominador * f.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion multiplicar(Fraccion f) {
        int nuevoNumerador = this.numerador * f.numerador;
        int nuevoDenominador = this.denominador * f.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion dividir(Fraccion f) {
        int nuevoNumerador = this.numerador * f.denominador;
        int nuevoDenominador = this.denominador * f.numerador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion simplificar() {
        int mcd = mcd(numerador, denominador);
        return new Fraccion(numerador / mcd, denominador / mcd);
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