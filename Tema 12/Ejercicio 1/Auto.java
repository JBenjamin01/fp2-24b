public class Auto{
    private String marca;
    private String placa;
    private double precio;
    private int año;

    public Auto(String marca, String placa, double precio, int año){
        this.marca = marca;
        this.placa = placa;
        this.precio = precio;
        this.año = año;
    }
    
    public String getMarca(){
        return marca;
    }
    public String getPlaca(){
        return placa;
    }
    public double getPrecio(){
        return precio;
    }
    public int getAño(){
        return año;
    }
    @Override
    public String toString(){
        return "Marca: " + marca + "\nPlaca: " + placa + "\nPrecio: " + precio + "\nAño: " + año;
    }
}