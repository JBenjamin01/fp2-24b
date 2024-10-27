public class Gerente {
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private double salario;

    public Gerente(String nombre, String apellido, String telefono, String correo, double salario){
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.salario = salario;
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + "\nApellido: " + apellido + "\nTelefono: " + telefono + "\nCorreo: " + correo + "\nSalario: $" + salario;
    }
}
