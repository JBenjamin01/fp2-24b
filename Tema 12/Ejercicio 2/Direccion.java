public class Direccion {
    private String calle;
    private String ciudad;
    private String region;
    private String pais;

    public Direccion() {
    }

    public Direccion(String calle, String ciudad, String region, String pais) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.region = region;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return calle + ", " + ciudad + ", " + region + ", " + pais;
    }
}