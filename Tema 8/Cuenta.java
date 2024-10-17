import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cuenta {
    private double saldo;

    public Cuenta() {
        saldo = 0;
    }

    public void depositar(double deposito) {
        saldo += deposito;
    }

    public void retirar(double retiro) {
        if (retiro > saldo) {
            System.out.println("No puedes retirar la cantidad solicitada, saldo insuficiente");
            return;
        } else {
            saldo -= retiro;
        }
    }

    public void mostrar() {
        System.out.println("El saldo de la cuenta actual es: " + saldo.setScale(2, RoundingMode.HALF_UP) + " soles.");
    }
}