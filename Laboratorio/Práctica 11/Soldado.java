public class Soldado {
    private String nombre;
    private int puntosVida;
    private int fila;
    private char columna;
    private int nivelAtaque;
    private int nivelDefensa;
    private int velocidad;
    private String actitud;
    private boolean vive;
    
    // Constructores sobrecargados del Soldado
    public Soldado(String nombre, int puntosVida, int fila, char columna, int nivelAtaque, int nivelDefensa) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.fila = fila;
        this.columna = columna;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.velocidad = 0;
        this.actitud = "Defensiva";  // Estado inicial
        this.vive = true; // Aqui dejo que por defecto, el soldado está vivo
    }
    public Soldado(String nombre, int puntosVida, int fila, char columna) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.fila = fila;
        this.columna = columna;
        this.nivelAtaque = (int)(Math.random() * 5) + 1;
        this.nivelDefensa = (int)(Math.random() * 5) + 1;
        this.velocidad = 0;
        this.actitud = "Defensiva";
        this.vive = true;
    }
    public Soldado(String nombre) {
        this(nombre, (int)(Math.random() * 5) + 1, (int)(Math.random() * 10), (char)('A' + (int)(Math.random() * 10)), 
            (int)(Math.random() * 5) + 1, (int)(Math.random() * 5) + 1);
    }
    public Soldado() {
        this("Soldado" + (int)(Math.random() * 100));
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
    public int getPuntosVida() {
        return puntosVida;
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
    
    // Setters
    public void setFila(int fila) {
        this.fila = fila;
    }
    public void setColumna(char columna) {
        this.columna = columna;
    }
    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
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
        puntosVida -= daño;
        if (puntosVida <= 0) {
            puntosVida = 0;
            System.out.println(nombre + " ha muerto.");
        } else {
            System.out.println(nombre + " ha recibido " + daño + " de daño. Vida restante: " + puntosVida);
        }
    }
    public void morir() {
        vive = false;
        System.out.println(nombre + " ha muerto.");
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre 
            + " | Vida: " + puntosVida 
            + " | Ataque: " + nivelAtaque 
            + " | Defensa: " + nivelDefensa 
            + " | Velocidad: " + velocidad
            + " | Actitud: " + actitud
            + " | Posición: " + columna + fila
            + " | Vive: " + (vive ? "Si" : "No");
    }
}