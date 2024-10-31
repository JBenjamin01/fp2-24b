public abstract class Trabajador {
    protected String nombre;
    protected String telefono;

    public Trabajador(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    public final String getNombre() {
        return nombre;
    }
    public final String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Telefono: " + telefono;
    }
}