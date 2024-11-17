public class Employee {
    private String name;

    public Employee(String n) {
        name = n;
    }

    @Override
    public String toString() {
        return name + " --> " + getPay();
    }

    // Método dummy para satisfacer el compilador
    public double getPay() {
        return 0.0;
    }
}