public class EstudiantePregrado extends Estudiante {

    public EstudiantePregrado(String nombre) {
        super(nombre);
    }

    @Override
    public void calcularNotaFinal() {
        int sumaNotas = 0;
        for (int i = 0; i < 3; i++) {
            sumaNotas += this.notas[i];
        }
        this.notaFinal = sumaNotas / 3.0;
    }
}