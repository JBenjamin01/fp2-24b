import java.util.*;

public class Mapa {
    private static final String [] territorios = {"bosque", "campo abierto", "montaña", "desierto", "playa"};

    private String territorio;
    private ArrayList<ArrayList<Ejercito>> tablero = new ArrayList<>();
    private Reino r1;
    private Reino r2;

    public Mapa(Reino r1, Reino r2) {
        this.r1 = r1;
        this.r2 = r2;
        generarTerritorio();
        inicializarTablero();
        colocarEjercitos();
    }

    // Generar un tipo de territorio aleatorio para el mapa
    private void generarTerritorio() {
        Random rand = new Random();
        String tipoTerreno = territorios[rand.nextInt(territorios.length)];
        territorio = tipoTerreno;
    }

    public String getTerritorio() {
        return territorio;
    }

    public void inicializarTablero() {
        for (int i = 0; i < 10; i++) {
            ArrayList<Ejercito> fila = new ArrayList<>();
            for (int j = 0; j < 10; j++) 
                fila.add(null);
            tablero.add(fila);
        }
    }

    private void colocarEjercitos() {
        for (Ejercito e : r1.getEjercitos()) {
            int fila = e.getFila() - 1; 
            int columna = e.getColumna() - 'A';

            tablero.get(fila).set(columna, e);
        }

        for (Ejercito e : r2.getEjercitos()) {
            int fila = e.getFila() - 1;
            int columna = e.getColumna() - 'A';

            tablero.get(fila).set(columna, e);
        }
    }

    public void mostrarMapa() {
        System.out.println("\n════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("█████     █████     █████     █████      C A M P O   D E  B A T A L L A      █████     █████     █████     █████");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("\n█ ESCENARIO: " + territorio.toUpperCase() + " █\n"
                            + "\n* Los ejércitos del reino de " + r1.getNombre() + " están colocados entre corchetes ([x])" 
                            + "\n* Los del reino de " + r2.getNombre() + " entre signos menor y mayor que (<x>)");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        
        System.out.println("\n             A         B         C         D         E         F         G         H         I         J");
        System.out.println();
        System.out.println("        -----------------------------------------------------------------------------------------------------");

        for (int i = 0; i < tablero.size(); i++) {
            System.out.print("  " + (i + 1) + "\t| ");
            for (int j = 0; j < tablero.get(i).size(); j++) {
                Ejercito ejercito = tablero.get(i).get(j);
                if (ejercito == null)
                    System.out.print("        | ");
                else {
                    int totalSoldados = ejercito.getTotalSoldadosEjercito();
                    int vidaTotal = ejercito.getVidaTotal();

                    String soldados = (totalSoldados < 10 ? " " : "") + totalSoldados;
                    String vida = vidaTotal + (vidaTotal < 10 ? " " : "");

                    if (r1.contains(ejercito)) {
                        System.out.print("[" + soldados + "-" + vida + "] | ");
                    } else if (r2.contains(ejercito)) {
                        System.out.print("<" + soldados + "-" + vida + "> | ");
                    } else {
                        System.out.print(totalSoldados + "  |  ");
                    }
                }
            }
            System.out.println();
            System.out.println("        -----------------------------------------------------------------------------------------------------");
        }
        System.out.println("\n════════════════════════════════════════════════════════════════════════════════════════════════════════════════\n");
    }
}