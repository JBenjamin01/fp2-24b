public class Espadachin extends Soldado {
    private double longitudEspada;

    public Espadachin(String nombre, int nivelVida, int fila, char columna, 
                    int nivelAtaque, int nivelDefensa, int ejercito, double longitudEspada) {
        super(nombre, nivelVida, fila, columna, nivelAtaque, nivelDefensa, ejercito);
        this.longitudEspada = longitudEspada;
    }

    public Espadachin(String nombre, int nivelVida, int fila, char columna, int ejercito, double longitudEspada) {
        super(nombre, nivelVida, fila, columna, ejercito);
        this.longitudEspada = longitudEspada;
    }

    public void crearMuroDeEscudos() {
        System.out.println(getNombre() + " ha creado un muro de escudos.");
    }
    
    @Override
    public String toString() {
        return super.toString() + " | Longitud Espada: " + longitudEspada;
    }
}