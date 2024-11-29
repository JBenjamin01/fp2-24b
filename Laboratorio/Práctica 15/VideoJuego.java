// LABORATORIO N° 15
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES
// TIEMPO: 167 MINUTOS
import java.util.*;
public class VideoJuego {
    public static void main(String[] args) {
        // Los reinos que creo aquí aleatoriamente generan sus ejércitos y soldados 
        // desde sus respectivas clases:
        Reino r1 = new Reino();
        Reino r2 = new Reino();

        Mapa mapa = new Mapa(r1, r2);
        mapa.mostrarMapa();

        System.out.println("Información de los reinos para comprobar los datos de ejércitos y soldados creados:\n");
        r1.mostrarInformacion();
        System.out.println();
        r2.mostrarInformacion();
        System.out.println("═══════════════════════════════════════════════════════════════"
                            + "══════════════════════════════════════════════════════════\n");

        // Aquí estan las métricas que definirán a un vencedor de los reinos
        System.out.println("Las 3 métricas usadas para determinar al vencedor:\n");
        mostrarMetricasVencedor(r1, r2);
    }

    public static void mostrarMetricasVencedor(Reino r1, Reino r2) {
        // Para definir al vencedor voy a utilizar estas tres métricas diferentes; 
        // Total de soldados, total de niveles de vida y probabilidad respecto a la vida
        System.out.println("1. Cantidad de soldados vivos");
        System.out.println("   Cantidad de soldados vivos del reino de " + r1.getNombre() + ": " + r1.getTotalSoldadosReino());
        System.out.println("   Cantidad de soldados vivos del reino de " + r2.getNombre() + ": " + r2.getTotalSoldadosReino());
        System.out.println("   ......");
        if (r1.getTotalSoldadosReino() > r2.getTotalSoldadosReino()) {
            System.out.println("   El reino de " + r1.getNombre() + " ha ganado la batalla.");
        } else if (r1.getTotalSoldadosReino() < r2.getTotalSoldadosReino()) {
            System.out.println("   El reino de " + r2.getNombre() + " ha ganado la batalla.");
        } else {
            System.out.println("   La batalla ha terminado en empate.");
        }

        System.out.println();

        System.out.println("2. Total de niveles de vida");
        System.out.println("   Total de niveles de vida del reino de " + r1.getNombre() + ": " + r1.getTotalVidaReino());
        System.out.println("   Total de niveles de vida del reino de " + r2.getNombre() + ": " + r2.getTotalVidaReino());
        System.out.println("   ......");
        if (r1.getTotalVidaReino() > r2.getTotalVidaReino()) {
            System.out.println("   El reino de " + r1.getNombre() + " ha ganado la batalla.");
        } else if (r1.getTotalVidaReino() < r2.getTotalVidaReino()) {
            System.out.println("   El reino de " + r2.getNombre() + " ha ganado la batalla.");
        } else {
            System.out.println("   La batalla ha terminado en empate.");
        }

        System.out.println();

        System.out.println("3. Probabilidades respecto a sus puntos de vida");
        int totalVida = r1.getTotalVidaReino() + r2.getTotalVidaReino();
        double probabilidadR1 = (double) r1.getTotalVidaReino() / totalVida;
        double probabilidadR2 = (double) r2.getTotalVidaReino() / totalVida;
        System.out.println("   Probabilidad de vida total del reino de " + r1.getNombre() + ": " + probabilidadR1 * 100 + "%");
        System.out.println("   Probabilidad de vida roral del reino de " + r2.getNombre() + ": " + probabilidadR2 * 100 + "%");
        System.out.println("\n   Calculando el resultado de la batalla...");
        System.out.println();
        Random r = new Random();
        double resultado = r.nextDouble() * 100;
        if (resultado < probabilidadR1 * 100) {
            System.out.println("   El reino de " + r1.getNombre() + " ha ganado la batalla.");
        } else if (resultado > probabilidadR1 * 100) {
            System.out.println("   El reino de " + r2.getNombre() + " ha ganado la batalla.");
        } else {
            System.out.println("   La batalla ha terminado en empate.");
        }
        System.out.println("\n═════════════════════════════════════════════════════════════"
                            + "════════════════════════════════════════════════════════════");
        System.out.println();
    }
}