public class Reino {
    private String nombre;
    private int victorias;

    public Reino(String nombre) {
        this.nombre = nombre;
        this.victorias = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVictorias() {
        return victorias;
    }

    public void incrementarVictorias() {
        this.victorias++;
    }

    public void resetVictorias() {
        this.victorias = 0;
    }
}