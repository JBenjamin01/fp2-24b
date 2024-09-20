public class Contacto {
    private String nombre;
    private String celular;

    public Contacto(String nombre, String celular) {
        this.nombre = nombre;
        this.celular = celular;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCelular() {
        return celular;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Celular: " + celular;
    }
}