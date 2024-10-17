public class Ejercicio1 {
    public static void main(String[] args) {
        Cuenta c1 = new Cuenta();
        c1.depositar(560.80);
        c1.retirar(220);
        c1.depositar(800);
        c1.mostrar();
        c1.retirar(99999);
        c1.depositar(430.40);
        c1.mostrar();
        c1.retirar(1000);
        c1.mostrar();

        Cuenta c2 = new Cuenta();
        c2.depositar(1000);
        c2.retirar(500);
        c2.mostrar();
        c2.retirar(500);
        c2.mostrar();
    }
}
