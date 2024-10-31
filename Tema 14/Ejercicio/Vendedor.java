public class Vendedor extends Trabajador {
    private double ventas = 0.0;
    private String direccion;

    public Vendedor(String nombre, String direccion, String telefono) {
        super(nombre, telefono);
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }
    public double getVentas() {
        return ventas;
    }

    public void registrarVenta(double monto) {
        this.ventas += monto;
    }

    @Override
    public String toString() {
        return super.toString() + " | Direccion: " + direccion + " | Ventas totales: " + ventas;
    }
}