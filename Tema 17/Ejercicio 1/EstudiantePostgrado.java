public class EstudiantePostgrado extends Estudiante {

    public EstudiantePostgrado(String nombre) {
        super(nombre);
    }

    @Override
    public void calcularNotaFinal() {
        // Nota final ponderada
        this.notaFinal = (this.notas[0] * 0.25) + (this.notas[1] * 0.35) + (this.notas[2] * 0.40);
    }
}
