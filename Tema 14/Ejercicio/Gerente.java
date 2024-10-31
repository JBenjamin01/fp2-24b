public class Gerente extends Trabajador {
    private final double salario;

    public Gerente(String nombre, String telefono, double salario) {
        super(nombre, telefono);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return super.toString() + " | Salario: " + salario + " soles";
    }
}