public class Lancero extends Soldado {
    private double longitudLanza;

    public Lancero(String nombre, int nivelVida, int fila, char columna, 
                    int nivelAtaque, int nivelDefensa, int ejercito, double longitudLanza) {
        super(nombre, nivelVida, fila, columna, nivelAtaque, nivelDefensa, ejercito);
        this.longitudLanza = longitudLanza;
    }

    public Lancero(String nombre, int nivelVida, int fila, char columna, int ejercito, double longitudLanza) {
        super(nombre, nivelVida, fila, columna, ejercito);
        this.longitudLanza = longitudLanza;
    }

    public void schiltrom() {
        System.out.println(getNombre() + " se ha colocado en su estado de defensa.");
        setNivelDefensa(getNivelDefensa() + 1);
    }
    
    @Override
    public String toString() {
        return super.toString() + " | Longitud Lanza: " + longitudLanza;
    }
}