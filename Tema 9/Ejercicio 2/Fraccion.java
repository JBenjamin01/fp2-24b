public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion() {
        this(0, 1);
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero");
        }
        this.numerador = numerador;
        this.denominador = denominador;
        simplify();
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    private void simplify() {
        int mcd = mcd(numerador, denominador);
        numerador /= mcd;
        denominador /= mcd;
    }

    private int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Métodos de instancia
    public Fraccion sumar(Fraccion f) {
        int newNumerador = this.numerador * f.denominador + f.numerador * this.denominador;
        int newDenominador = this.denominador * f.denominador;
        return new Fraccion(newNumerador, newDenominador);
    }

    public Fraccion restar(Fraccion f) {
        int newNumerador = this.numerador * f.denominador - f.numerador * this.denominador;
        int newDenominador = this.denominador * f.denominador;
        return new Fraccion(newNumerador, newDenominador);
    }

    public Fraccion multiplicar(Fraccion f) {
        int newNumerador = this.numerador * f.numerador;
        int newDenominador = this.denominador * f.denominador;
        return new Fraccion(newNumerador, newDenominador);
    }

    public Fraccion dividir(Fraccion f) {
        if (f.numerador == 0) {
            throw new IllegalArgumentException("No es posible dividir entre cero");
        }
        int newNumerador = this.numerador * f.denominador;
        int newDenominador = this.denominador * f.numerador;
        return new Fraccion(newNumerador, newDenominador);
    }

    // Métodos de clase
    public static Fraccion sumar(Fraccion a, Fraccion b) {
        return a.sumar(b);
    }

    public static Fraccion restar(Fraccion a, Fraccion b) {
        return a.restar(b);
    }

    public static Fraccion multiplicar(Fraccion a, Fraccion b) {
        return a.multiplicar(b);
    }

    public static Fraccion dividir(Fraccion a, Fraccion b) {
        return a.dividir(b);
    }
}