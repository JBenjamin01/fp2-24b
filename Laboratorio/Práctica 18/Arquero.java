public class Arquero extends Soldado {
    private int flechasDisponibles;

    public Arquero(String nombre, int nivelVida, int fila, char columna, 
                int nivelAtaque, int nivelDefensa, int ejercito, int flechasDisponibles) {
        super(nombre, nivelVida, fila, columna, nivelAtaque, nivelDefensa, ejercito);
        this.flechasDisponibles = flechasDisponibles;
    }

    public Arquero(String nombre, int nivelVida, int fila, char columna, int ejercito, int flechasDisponibles) {
        super(nombre, nivelVida, fila, columna, ejercito);
        this.flechasDisponibles = flechasDisponibles;
    }

    public int getFlechasDisponibles() {
        return flechasDisponibles;
    }

    public void dispararFlecha() {
        if (flechasDisponibles > 0) {
            flechasDisponibles--;
            System.out.println(getNombre() + " ha disparado una flecha. Flechas restantes: " + flechasDisponibles);
        } else
            System.out.println(getNombre() + " no tiene flechas disponibles para disparar.");
    }

    @Override
    public void atacar() {
        if (flechasDisponibles > 0) 
            dispararFlecha();
        else 
            System.out.println(getNombre() + " no puede atacar porque no tiene flechas.");
    }
}