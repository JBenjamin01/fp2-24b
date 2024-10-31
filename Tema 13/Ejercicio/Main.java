public class Main {
    public static void main(String[] args) {
        // Objeto de la clase Person
        Person p = new Person("Jhonatan");
        System.out.println("Información del objeto Person:");
        p.display();
        System.out.println();

        // Objeto de la clase Employee
        Employee e = new Employee("Benjamin", 81556132);
        System.out.println("Información del objeto Employee:");
        e.display();
        System.out.println();

        // Objeto de la clase FullTime
        FullTime f = new FullTime("Pepe", 56713418, 3502.70);
        System.out.println("Información del objeto FullTime:");
        f.display();
    }
}