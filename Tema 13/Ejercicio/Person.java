public class Person {
    private String name;

    // En el constructor vacío le estoy añandiendo un valor por defecto
    public Person() {
        this.name = "No tiene Nombre";
    }

    public Person(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println("Nombre: " + name);
    }
}