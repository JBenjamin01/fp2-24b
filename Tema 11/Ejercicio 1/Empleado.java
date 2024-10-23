public class Empleado {
    private String nombre;
    private String apellido;
    private int edad;
    private static int contadorEmpleados = 0;

    public Empleado(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        contadorEmpleados++;
    }

    public Empleado(String nombre, int edad) {
        this.nombre = nombre;
        this.apellido = "";
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public int getEdad() {
        return edad;
    }
    public static int getContadorEmpleados() {
        return contadorEmpleados;
    }
}