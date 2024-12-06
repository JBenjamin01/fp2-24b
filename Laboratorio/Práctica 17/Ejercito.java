import java.util.*;

public class Ejercito {
    private int numEjercito;
    private ArrayList<Soldado> soldados = new ArrayList<>();
    private Set<String> posicionesOcupadas = new HashSet<>();

    public Ejercito(int numEjercito) {
        this.numEjercito = numEjercito;
        generarSoldados();
    }

    public void addSoldado(Soldado soldado) {
        soldados.add(soldado);
    }

    public int getTotalSoldadosEjercito() {
        return soldados.size();
    }

    public int getTotalVidaEjercito() {
        int total = 0;
        for (Soldado s : soldados) {
            total += s.getNivelVida();
        }
        return total;
    }

    public ArrayList<Soldado> getSoldados() {
        return soldados;
    }

    public Soldado getSoldadoConMayorVida() {
        return soldados.stream().max(Comparator.comparingInt(Soldado::getNivelVida)).orElse(null);
    }

    public double getPromedioVida() {
        return soldados.stream().mapToInt(Soldado::getNivelVida).average().orElse(0);
    }

    private void generarSoldados() {
        int n = (int) (Math.random() * Soldado.MAX_SOLDADOS_POR_EJERCITO) + 1;
        for (int i = 0; i < n; i++) {
            Soldado soldado = crearSoldadoAleatorio(i + 1);
            soldados.add(soldado);
        }
    }

    private Soldado crearSoldadoAleatorio(int indice) {
        String tipo = generarTipoSoldado();
        String nombre = tipo + numEjercito + "X" + indice;

        // Generar posición única
        int fila, columna;
        do {
            fila = (int) (Math.random() * 10);
            columna = (int) (Math.random() * 10);
        } while (posicionesOcupadas.contains(fila + "," + columna));
        posicionesOcupadas.add(fila + "," + columna);

        // Crear soldado según el tipo
        switch (tipo) {
            case "Espadachin":
                return new Espadachin(nombre, generarVida(3, 4), fila + 1, (char) ('A' + columna), generarNivel(), generarNivel(), numEjercito, 1.5);
            case "Arquero":
                return new Arquero(nombre, generarVida(1, 3), fila + 1, (char) ('A' + columna), generarNivel(), generarNivel(), numEjercito, 10);
            case "Caballero":
                return new Caballero(nombre, generarVida(3, 5), fila + 1, (char) ('A' + columna), generarNivel(), generarNivel(), numEjercito);
            default:
                throw new IllegalArgumentException("Tipo de soldado desconocido: " + tipo);
        }
    }

    private String generarTipoSoldado() {
        String[] tipos = {"Espadachin", "Arquero", "Caballero"};
        return tipos[(int) (Math.random() * tipos.length)];
    }

    private int generarVida(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    private int generarNivel() {
        return (int) (Math.random() * 5) + 1;
    }

    public void mostrarEjercito() {
        System.out.println("\nEjército #" + numEjercito);
        for (Soldado soldado : soldados) {
            System.out.println(" - " + soldado);
        }
    }

    public void mostrarRanking() {
        System.out.println("\nRanking del Ejército #" + numEjercito + " (Por nivel de vida):");
        soldados.stream()
                .sorted((s1, s2) -> Integer.compare(s2.getNivelVida(), s1.getNivelVida()))
                .forEach(System.out::println);
    }
}