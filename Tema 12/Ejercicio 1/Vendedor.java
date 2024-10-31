public class Vendedor {
    private String nombre;
    private double ventas = 0.0;
    private String direccion;
    private String telefono;

    public Vendedor(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void registrarVenta(double monto) {
        this.ventas += monto;
    }
    public double getVentas() {
        return ventas;
    }

    @Override
    public String toString() {
        return "Vendedor: " + nombre + ", Teléfono: " + telefono + ", Ventas totales: " + ventas;
    }
}