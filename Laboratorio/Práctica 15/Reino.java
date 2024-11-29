import java.util.*;
public class Reino {
    private static ArrayList<String> reinos = new ArrayList<String>(Arrays.asList("Inglaterra", "Francia", "Castilla-Aragón",
                                                                                    "Moros", "Sacro Imperio Romano Germánico"));
    private String nombre;
    private ArrayList<Ejercito> ejercitos = new ArrayList<>();
    private static Set<String> posicionesOcupadas = new HashSet<>();

    public Reino() {
        generarNombre();
        generarEjercitos();
    }

    private void generarNombre() {
        Random r = new Random();
        int indice = r.nextInt(reinos.size());
        nombre = reinos.remove(indice);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Ejercito> getEjercitos() {
        return ejercitos;
    }

    public int getTotalSoldadosReino() {
        int total = 0;
        for (Ejercito e : ejercitos) {
            total += e.getTotalSoldadosEjercito();
        }
        return total;
    }

    public int getTotalVidaReino() {
        int total = 0;
        for (Ejercito e : ejercitos) {
            total += e.getTotalVidaEjercito();
        }
        return total;
    }

    private void generarEjercitos() {
        int n = (int) (Math.random() * 10) + 1;
        for (int i = 0; i < n; i++) {
            int fila, columna;
            do {
                fila = (int) (Math.random() * 10);
                columna = (int) (Math.random() * 10);
            } while (posicionesOcupadas.contains(fila + "," + columna));

            posicionesOcupadas.add(fila + "," + columna);
            Ejercito e = new Ejercito(nombre, i + 1, 1 + fila, (char) ('A' + columna));

            ejercitos.add(e);
        }
    }

    public boolean contains(Ejercito ejercito) {
        return ejercitos.contains(ejercito);
    }
    
    public void mostrarInformacion() {
        System.out.println("█ REINO DE " + nombre.toUpperCase() + " █");
        System.out.println("+ Total de ejércitos: " + ejercitos.size());
        System.out.println("+ Total de soldados: " + getTotalSoldadosReino());
        System.out.println("+ Total de vida: " + getTotalVidaReino());
        System.out.println("\nLista de ejércitos creados para este reino:\n");
        for (Ejercito ejercito : ejercitos) {
            System.out.println("\nEjercito " + (ejercitos.indexOf(ejercito) + 1) + " ---> "
                                + ejercito.getCantidadSoldados() + " soldados, "
                                + ejercito.getTotalVidaEjercito() + " puntos de vida, ubicado en la posición " 
                                + ejercito.getColumna() + ejercito.getFila());
            ejercito.mostrarEjercito();
        }
    }
}
