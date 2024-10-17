public class Soldado{
    private String nombre;
    private int fila;
    private String columna;
    private int vida;
    // Metodos mutadores
    public void setNombre(String n){
        nombre = n;
    }
    public void setFila(int f){
        fila = f;
    }
    public void setColumna(String c){
        columna = c;
    }
    public void setVida(int p){
        vida = p;
    }
    // Metodos accesores
    public String getNombre(){
        return nombre;
    }
    public int getFila(){
        return fila;
    }
    public String getColumna(){
        return columna;
    }
    public int getVida(){
        return vida;
    }
}