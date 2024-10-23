public class Main {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("Juan", "Perez", 30);
        Empleado e2 = new Empleado("Ana", "Gomez", 25);
        Empleado e3 = new Empleado("Luis", 29);

        System.out.println("Empleado 1: " + e1.getNombre() + " " 
                            + e1.getApellido() + ", Edad: " + e1.getEdad());
        System.out.println("Empleado 2: " + e2.getNombre() + " " 
                            + e2.getApellido() + ", Edad: " + e2.getEdad());
        System.out.println("Empleado 3: " + e3.getNombre() + ", Edad: " + e3.getEdad());

        System.out.println("Total de empleados creados: " + Empleado.getContadorEmpleados());
    }
}