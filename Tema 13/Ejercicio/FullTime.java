public class FullTime extends Employee {
    private double salary;

    public FullTime() {
        super();
        this.salary = 0.0;
    }

    // Constructor con parámetros
    public FullTime(String n, int cod, double s) {
        super(n, cod);
        this.salary = s;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Salario: " + salary + " soles");
    }
}