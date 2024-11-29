import java.util.*;
public class Ejercito {
    private int numEjercito;
    private String reino;
    private ArrayList<Soldado> soldados = new ArrayList<Soldado>();
    private int fila;
    private char columna;

    public Ejercito(String reino, int numEjercito, int fila, char columna) {
        this.numEjercito = numEjercito;
        this.reino = reino;
        this.fila = fila;
        this.columna = columna;
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

    public String getReino() {
        return reino;
    }
    
    public int getFila() {
        return fila;
    }
    
    public char getColumna() {
        return columna;
    }
    
    public int getCantidadSoldados() {
        return soldados.size();
    }

    public int getVidaTotal() {
        int vidaTotal = 0;
        for (Soldado s : soldados) {
            vidaTotal += s.getNivelVida();
        }
        return vidaTotal;
    }

    private void generarSoldados() {
        Set<String> posicionesOcupadas = new HashSet<>();
        int n = (int) (Math.random() * Soldado.MAX_SOLDADOS_POR_EJERCITO) + 1;
        for (int i = 0; i < n; i++) {
            String nombre = "Soldado" + numEjercito + "X" + (i + 1);
            int puntosVida = (int) (Math.random() * 5) + 1;
            int puntosAtaque = (int) (Math.random() * 5) + 1;
            int puntosDefensa = (int) (Math.random() * 5) + 1;
            
            int fila, columna;

            do {
                fila = (int) (Math.random() * 10);
                columna = (int) (Math.random() * 10);
            } while (posicionesOcupadas.contains(fila + "," + columna));

            posicionesOcupadas.add(fila + "," + columna);

            Soldado soldado = new Soldado(nombre, puntosVida, 1 + fila, (char) ('A' + columna), puntosAtaque, puntosDefensa, i + 1);

            soldados.add(soldado);
        }
    }

    public void mostrarEjercito() {
        System.out.println("\nSoldados de este ejército:");
        for (Soldado soldado : soldados) {
            System.out.println(" - " + soldado);
        }
        System.out.println();
    }

    public void aplicarBonus(String tipoTerritorio) {
        if (tipoTerritorio.equals("bosque") && (reino.equals("Inglaterra") || reino.equals("Sacro Imperio Romano Germánico"))) {
            for (Soldado s : soldados) {
                s.setNivelVida(s.getNivelVida() + 1);
            }
        } else if (tipoTerritorio.equals("campo abierto") && reino.equals("Francia")) {
            for (Soldado s : soldados) {
                s.setNivelVida(s.getNivelVida() + 1);
            }
        } else if (tipoTerritorio.equals("montaña") && (reino.equals("Castilla-Aragón"))) {
            for (Soldado s : soldados) {
                s.setNivelVida(s.getNivelVida() + 1);
            }
        } else if (tipoTerritorio.equals("desierto") && reino.equals("Moros")) {
            for (Soldado s : soldados) {
                s.setNivelVida(s.getNivelVida() + 1);
            }
        } else if (tipoTerritorio.equals("playa") && (reino.equals("Sacro Imperio Romano Germánico") || reino.equals("Francia"))) {
            for (Soldado s : soldados) {
                s.setNivelVida(s.getNivelVida() + 1);
            }
        }
    }
}