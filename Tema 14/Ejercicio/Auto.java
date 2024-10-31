public class Auto {
    private String marca;
    private String placa;
    private double precio;
    private int año;

    public Auto(String marca, String placa, double precio, int año) {
        this.marca = marca;
        this.placa = placa;
        this.precio = precio;
        this.año = año;
    }

    public final String getMarca() {
        return marca;
    }
    public final String getPlaca() {
        return placa;
    }
    public final double getPrecio() {
        return precio;
    }
    public final int getAño() {
        return año;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + " | Placa: " + placa + " | Precio: " + precio + " | Año: " + año;
    }
}