import java.util.*;
public class Guerra {
    private Reino reino1;
    private Reino reino2;
    private int cantidadBatallas;
    private int victoriasReino1;
    private int victoriasReino2;
    private int empates;
    private Random random;

    public Guerra(Reino reino1, Reino reino2) {
        this.reino1 = reino1;
        this.reino2 = reino2;
        this.random = new Random();
        this.cantidadBatallas = random.nextInt(16) + 5; // 5-20
        this.victoriasReino1 = 0;
        this.victoriasReino2 = 0;
        this.empates = 0;
    }

    public void simularGuerra() {
        System.out.println("\n--- Inicio de la Guerra entre " + reino1.getNombre() 
                                            + " y " + reino2.getNombre() + " ---");
        System.out.println("Cantidad de batallas: " + cantidadBatallas + "\n");

        for (int i = 1; i <= cantidadBatallas; i++) {
            System.out.println("Batalla " + i + ":");
            Soldado soldado1 = Soldado.generarSoldado(random);
            Soldado soldado2 = Soldado.generarSoldado(random);

            System.out.println(reino1.getNombre() + ": " + soldado1);
            System.out.println(reino2.getNombre() + ": " + soldado2);

            determinarGanador(soldado1, soldado2);

            System.out.println();
        }

        mostrarResultados();
    }

    // Método para determinar el ganador de una batalla
    private void determinarGanador(Soldado s1, Soldado s2) {
        int vidaTotal = s1.getNivelVida() + s2.getNivelVida();
        double probabilidadReino1 = ((double) s1.getNivelVida() / vidaTotal) * 100;
        double probabilidadReino2 = ((double) s2.getNivelVida() / vidaTotal) * 100;

        double aleatorio = random.nextDouble() * 100;

        System.out.printf("Probabilidades - %s: %.2f%% | %s: %.2f%%\n", 
                            reino1.getNombre(), probabilidadReino1, 
                            reino2.getNombre(), probabilidadReino2);
        System.out.printf("Número aleatorio generado: %.2f\n", aleatorio);

        if (aleatorio < probabilidadReino1) {
            System.out.println("Ganador de la batalla: " + reino1.getNombre());
            victoriasReino1++;
            reino1.incrementarVictorias();
        } else if (aleatorio < probabilidadReino1 + probabilidadReino2) {
            System.out.println("Ganador de la batalla: " + reino2.getNombre());
            victoriasReino2++;
            reino2.incrementarVictorias();
        } else {
            System.out.println("Empate en la batalla.");
            empates++;
        }
    }

    private void mostrarResultados() {
        System.out.println("--- Resultados Finales ---");
        System.out.println(reino1.getNombre() + " ganó " + victoriasReino1 + " batallas.");
        System.out.println(reino2.getNombre() + " ganó " + victoriasReino2 + " batallas.");
        System.out.println("Batallas empatadas: " + empates);

        if (victoriasReino1 > victoriasReino2) {
            System.out.println("¡" + reino1.getNombre() + " ha ganado la guerra!");
        } else if (victoriasReino1 < victoriasReino2) {
            System.out.println("¡" + reino2.getNombre() + " ha ganado la guerra!");
        } else {
            System.out.println("La guerra ha terminado en empate.");
        }
    }
}