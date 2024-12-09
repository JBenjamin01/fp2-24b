public class Soldado {
    public static final int MAX_SOLDADOS_POR_EJERCITO = 10;
    private String nombre;
    private int nivelVida;
    private int fila;
    private char columna;
    private int nivelAtaque;
    private int nivelDefensa;
    private int velocidad;
    private String actitud;
    private boolean vive;
    private int ejercito;
    
    // Constructores sobrecargados del Soldado
    public Soldado(String nombre, int nivelVida, int fila, char columna, int nivelAtaque, int nivelDefensa, int ejercito) {
        this.nombre = nombre;
        this.nivelVida = nivelVida;
        this.fila = fila;
        this.columna = columna;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.velocidad = 0;
        this.actitud = "Defensiva";
        this.vive = true;
        this.ejercito = ejercito;
    }
    public Soldado(String nombre, int nivelVida, int fila, char columna, int ejercito) {
        this.nombre = nombre;
        this.nivelVida = nivelVida;
        this.fila = fila;
        this.columna = columna;
        this.nivelAtaque = generarNivel();
        this.nivelDefensa = generarNivel();
        this.velocidad = 0;
        this.actitud = "Defensiva";
        this.vive = true;
        this.ejercito = ejercito;
    }
    public Soldado(String nombre, int fila, char columna, int ejercito) {
        this.nombre = nombre;
        this.nivelVida = generarNivel();
        this.fila = fila;
        this.columna = columna;
        this.nivelAtaque = generarNivel();
        this.nivelDefensa = generarNivel();
        this.velocidad = 0;
        this.actitud = "Defensiva";
        this.vive = true;
        this.ejercito = ejercito;
    }
    public Soldado(String nombre, int nivelVida, int ejercito) {
        this.nombre = nombre;
        this.nivelVida = nivelVida;
        this.fila = 0;
        this.columna = 'A';
        this.nivelAtaque = generarNivel();
        this.nivelDefensa = generarNivel();
        this.velocidad = 0;
        this.actitud = "Defensiva";
        this.vive = true;
        this.ejercito = ejercito;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }
    public int getFila() {
        return fila;
    }
    public char getColumna() {
        return columna;
    }
    public int getNivelVida() {
        return nivelVida;
    }
    public int getNivelAtaque() {
        return nivelAtaque;
    }
    public int getNivelDefensa() {
        return nivelDefensa;
    }
    public int getVelocidad() {
        return velocidad;
    }
    public String getActitud() {
        return actitud;
    }
    public boolean isVivo() {
        return vive;
    }
    public int getEjercito() {
        return ejercito;
    }

    private int generarNivel() {
        return (int) (Math.random() * 5) + 1;
    }
    
    // Setters
    public void setFila(int fila) {
        this.fila = fila;
    }
    public void setColumna(char columna) {
        this.columna = columna;
    }
    public void setNivelVida(int nivelVida) {
        this.nivelVida = nivelVida;
    }
    public void setNivelAtaque(int nivelAtaque) {
        this.nivelAtaque = nivelAtaque;
    }
    public void setNivelDefensa(int nivelDefensa) {
        this.nivelDefensa = nivelDefensa;
    }
    public void setEjercito(int ejercito) {
        this.ejercito = ejercito;
    }

    // Métodos del UML de referencia
    public void atacar() {
        velocidad += 1;
        actitud = "Ofensiva";
        System.out.println(nombre + " ha atacado, su velocidad es ahora " + velocidad);
    }
    public void defender() {
        actitud = "Defensiva";
        System.out.println(nombre + " está en modo defensivo.");
    }
    public void huir() {
        velocidad += 2;
        actitud = "Fuga";
        System.out.println(nombre + " está huyendo, su velocidad es ahora " + velocidad);
    }
    public void avanzar() {
        velocidad += 1;
        System.out.println(nombre + " avanza, su velocidad es ahora " + velocidad);
    }
    public void retroceder() {
        if (velocidad > 0) {
            velocidad = 0;
            actitud = "Defensiva";
            System.out.println(nombre + " se ha detenido, velocidad actual: " + velocidad);
        } else {
            velocidad -= 1;
            System.out.println(nombre + " ha retrocedido, velocidad negativa: " + velocidad);
        }
    }
    public void serAtacado(int daño) {
        recibirAtaque(daño);
    }
    public void recibirAtaque(int daño) {
        nivelVida -= daño;
        if (nivelVida <= 0) {
            nivelVida = 0;
            System.out.println(nombre + " ha muerto.");
        } else {
            System.out.println(nombre + " ha recibido " + daño + " de daño. Vida restante: " + nivelVida);
        }
    }
    public void morir() {
        vive = false;
        System.out.println(nombre + " ha muerto.");
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre 
            + " | Vida: " + nivelVida 
            + " | Ataque: " + nivelAtaque 
            + " | Defensa: " + nivelDefensa 
            + " | Velocidad: " + velocidad
            + " | Actitud: " + actitud
            + " | Posición: " + columna + fila
            + " | Vive: " + (vive ? "Si" : "No");
    }
}