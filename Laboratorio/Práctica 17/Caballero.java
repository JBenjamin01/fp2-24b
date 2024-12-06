public class Caballero extends Soldado {
    private boolean montado;
    private String arma;

    public Caballero(String nombre, int nivelVida, int fila, char columna, int nivelAtaque, int nivelDefensa, int ejercito) {
        super(nombre, nivelVida, fila, columna, nivelAtaque, nivelDefensa, ejercito);
        this.montado = true;
        this.arma = "lanza";
    }

    public void montar() {
        if (!montado) {
            montado = true;
            arma = "lanza";
            System.out.println(getNombre() + " ha montado y cambiado a " + arma + ".");
        } else {
            System.out.println(getNombre() + " ya está montado.");
        }
    }

    public void desmontar() {
        if (montado) {
            montado = false;
            arma = "espada";
            System.out.println(getNombre() + " ha desmontado y cambiado a " + arma + ".");
        } else {
            System.out.println(getNombre() + " ya está desmontado.");
        }
    }

    public void envestir() {
        int ataques = montado ? 3 : 2;
        System.out.println(getNombre() + " realizó una envestida con " + ataques + " ataques.");
    }
    
    @Override
    public String toString() {
        return super.toString() + " | Montado: " + montado + " | Arma: " + arma;
    }
}