public class Estudiante {
    private int numLista;
    private String nombre;
    private Direccion domicilio;

    public Estudiante(int numLista, String nombre, Direccion domicilio) {
        this.numLista = numLista;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }
    public void mostrarDatos() {
        System.out.println("Estudiante: " + nombre + " (Número de lista: " + numLista + ")");
        System.out.println("Domicilio: " + domicilio.toString());
    }
}