public class Salaried extends Employee {
    private double salary;

    public Salaried(String n, double s) {
        super(n);
        salary = s;
    }

    @Override
    public double getPay() {
        return salary / 24; // Pago quincenal
    }

    @Override
    public String toString() {
        return super.toString() + " (Salaried)";
    }
}