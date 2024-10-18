public class Soldado {
    private String nombre;
    private int puntosVida;
    private int fila;
    private char columna;

    public Soldado(String nombre, int puntosVida, int fila, char columna) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.fila = fila;
        this.columna = columna;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }
    public void setColumna(char columna) {
        this.columna = columna;
    }

    public String getNombre() {
        return nombre;
    }
    public int getPuntosVida() {
        return puntosVida;
    }
    public int getFila() {
        return fila;
    }
    public char getColumna() {
        return columna;
    }
}