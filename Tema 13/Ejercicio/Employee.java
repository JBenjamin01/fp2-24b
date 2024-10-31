public class Employee extends Person {
    private int id;

    public Employee() {
        super();  // Llamo al constructor por defecto de Person (para su nombre)
        this.id = 0;
    }

    // Constructor con parámetros
    public Employee(String n, int cod) {
        super(n);  // Aquí llamo al constructor de Person con parámetro
        this.id = cod;
    }

    @Override
    public void display() {
        super.display();  // Uso tambien el método display() de Person
        System.out.println("ID: " + id);
    }
}