import java.util.*;

public class Ejercito {
    private int numEjercito;
    private ArrayList<Soldado> soldados = new ArrayList<>();
    private Set<String> posicionesExistentes = new HashSet<>();

    public Ejercito(int numEjercito) {
        this.numEjercito = numEjercito;
        generarSoldados();
    }

    public void addSoldado(Soldado soldado) {
        soldados.add(soldado);
    }

    public int getTotalSoldados() {
        return soldados.size();
    }

    public ArrayList<Soldado> getSoldados() {
        return soldados;
    }

    private void generarSoldados() {
        int n = (int) (Math.random() * Soldado.MAX_SOLDADOS_POR_EJERCITO) + 1;
        for (int i = 0; i < n; i++) {
            Soldado soldado = crearSoldadoAleatorio(i + 1);
            soldados.add(soldado);
        }
    }

    private Soldado crearSoldadoAleatorio(int idx) {
        String tipo = generarTipoSoldado();
        String nombre = tipo + numEjercito + "X" + idx;

        int fila, columna;
        do {
            fila = (int) (Math.random() * 10);
            columna = (int) (Math.random() * 10);
        } while (posicionesExistentes.contains(fila + "," + columna));
        posicionesExistentes.add(fila + "," + columna);

        switch (tipo) {
            case "Espadachin":
                return new Espadachin(nombre, generarVida(3, 4), fila + 1, (char) ('A' + columna), numEjercito, 1.5);
            case "Arquero":
                return new Arquero(nombre, generarVida(1, 3), fila + 1, (char) ('A' + columna), numEjercito, 10);
            case "Caballero":
                return new Caballero(nombre, generarVida(3, 5), fila + 1, (char) ('A' + columna), numEjercito);
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

    public void mostrarEjercito() {
        System.out.println("\nEjército #" + numEjercito);
        for (Soldado soldado : soldados) {
            System.out.println(" - " + soldado);
        }
    }

    public boolean isEmpty() {
        return soldados.isEmpty();
    }
    
    public void eliminarSoldado(Soldado soldado) {
        soldados.remove(soldado);
        posicionesExistentes.remove(soldado.getFila() + "," + soldado.getColumna());
    }

    public Boolean contains(Soldado soldado) {
        return soldados.contains(soldado);
    }
}