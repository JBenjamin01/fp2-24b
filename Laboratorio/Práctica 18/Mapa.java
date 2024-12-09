import java.util.*;

public class Mapa {
    private ArrayList<ArrayList<String>> tablero = new ArrayList<>();
    private Ejercito ej1;
    private Ejercito ej2;

    public Mapa(Ejercito ej1, Ejercito ej2) {
        this.ej1 = ej1;
        this.ej2 = ej2;
        inicializarTablero();
        colocarSoldados();
    }

    public Soldado getSoldado(int fila, char columna) {
        for (Soldado soldado : ej1.getSoldados()) 
            if (soldado.getFila() == fila && soldado.getColumna() == columna)
                return soldado;

        for (Soldado soldado : ej2.getSoldados()) 
            if (soldado.getFila() == fila && soldado.getColumna() == columna)
                return soldado;

        return null;
    }

    private void inicializarTablero() {
        for (int i = 0; i < 10; i++) {
            ArrayList<String> fila = new ArrayList<>();
            for (int j = 0; j < 10; j++)
                fila.add("    ");
            tablero.add(fila);
        }
    }

    public void limpiarTablero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++)
                tablero.get(i).set(j, "    ");
        }
    }

    private void colocarSoldados() {
        colocarSoldadosPorEjercito(ej1, 1);
        colocarSoldadosPorEjercito(ej2, 2);
    }

    private void colocarSoldadosPorEjercito(Ejercito ejercito, int numEjercito) {
        for (Soldado soldado : ejercito.getSoldados()) {
            int fila = soldado.getFila() - 1;
            int columna = soldado.getColumna() - 'A';

            String tipoSoldado = obtenerTipoSoldado(soldado);
            String representacion = (numEjercito == 1 ? "[" : "<") + tipoSoldado + soldado.getNivelVida() + (numEjercito == 1 ? "]" : ">");

            tablero.get(fila).set(columna, representacion);
        }
    }

    private String obtenerTipoSoldado(Soldado soldado) {
        if (soldado instanceof Arquero)
            return "A";
        else if (soldado instanceof Espadachin)
            return "E";
        else if (soldado instanceof Caballero)
            return "C";
        else
            return "S"; // Aquí sería un soldado por defecto
    }

    public void mostrarMapa() {
        System.out.println("\n════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("██████       ██████       C A M P O   D E   B A T A L L A        ██████       ██████");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("\n* Los soldados del Ejército 1 están representados por '[tipo/Vida]'" 
                            + "\n* Los del Ejército 2 por '<tipo/Vida>'\n");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════");

        System.out.println("\n           A      B      C      D      E      F      G      H      I      J");
        System.out.println();
        System.out.println("        -----------------------------------------------------------------------");

        for (int i = 0; i < tablero.size(); i++) {
            System.out.print("  " + (i + 1) + "\t| ");
            for (String celda : tablero.get(i)) {
                if (celda == "") {
                    celda = "     ";
                }
                System.out.print("" + celda + " | ");
            }
            System.out.println();
            System.out.println("        -----------------------------------------------------------------------");
        }
        System.out.println("\n════════════════════════════════════════════════════════════════════════════════════\n");
    }
    
    public void actualizarMapa(Ejercito ej1, Ejercito ej2) {
        limpiarTablero();
        this.ej1 = ej1;
        this.ej2 = ej2;
        colocarSoldados();
    }
}