import java.util.*;

public class Mapa {
    private ArrayList<ArrayList<String>> tablero = new ArrayList<>();
    private Ejercito ejercito1;
    private Ejercito ejercito2;

    public Mapa(Ejercito ejercito1, Ejercito ejercito2) {
        this.ejercito1 = ejercito1;
        this.ejercito2 = ejercito2;
        inicializarTablero();
        colocarSoldados();
    }

    private void inicializarTablero() {
        for (int i = 0; i < 10; i++) {
            ArrayList<String> fila = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                fila.add("    ");
            }
            tablero.add(fila);
        }
    }

    private void colocarSoldados() {
        colocarSoldadosPorEjercito(ejercito1, 1);
        colocarSoldadosPorEjercito(ejercito2, 2);
    }

    private void colocarSoldadosPorEjercito(Ejercito ejercito, int numEjercito) {
        for (Soldado soldado : ejercito.getSoldados()) {
            int fila = soldado.getFila() - 1;
            int columna = soldado.getColumna() - 'A';

            String tipoSoldado = obtenerTipoSoldado(soldado);
            String simbolo = (numEjercito == 1 ? "[" : "<") + tipoSoldado + soldado.getNivelVida() + (numEjercito == 1 ? "]" : ">");

            tablero.get(fila).set(columna, simbolo);
        }
    }

    private String obtenerTipoSoldado(Soldado soldado) {
        if (soldado instanceof Arquero) {
            return "A";
        } else if (soldado instanceof Espadachin) {
            return "E";
        } else if (soldado instanceof Caballero) {
            return "C";
        } else {
            return "S";
        }
    }

    public void mostrarMapa() {
        System.out.println("\n═════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("█████     █████     █████      C A M P O   D E  B A T A L L A      █████     █████     █████");
        System.out.println("═════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("\n* Los soldados del Ejército 1 están representados por '[tipo/Vida]'" 
                            + "\n* Los del Ejército 2 por '<tipo/Vida>'\n");
        System.out.println("═════════════════════════════════════════════════════════════════════════════════════════════");

        System.out.println("\n           A      B      C      D      E      F      G      H      I      J");
        System.out.println();
        System.out.println("        -----------------------------------------------------------------------");

        for (int i = 0; i < tablero.size(); i++) {
            System.out.print("  " + (i + 1) + "\t| ");
            for (String cell : tablero.get(i)) {
                if (cell == "") {
                    cell = "     ";
                }
                System.out.print("" + cell + " | ");
            }
            System.out.println();
            System.out.println("        -----------------------------------------------------------------------");
        }
        System.out.println("\n═════════════════════════════════════════════════════════════════════════════════════════════\n");
    }
}
