public class Gerente {
    private String nombre;
    private String telefono;
    private double salario;

    public Gerente(String nombre, String telefono, double salario){
        this.nombre = nombre;
        this.telefono = telefono;
        this.salario = salario;
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + "\nTelefono: " + telefono + "\nSalario: $" + salario;
    }
}