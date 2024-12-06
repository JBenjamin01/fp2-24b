// LABORATORIO N° 17
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES
// TIEMPO: 59 MINUTOS
public class VideoJuego {
    public static void main(String[] args) {
        Ejercito ejercito1 = new Ejercito(1);
        Ejercito ejercito2 = new Ejercito(2);

        Mapa mapa = new Mapa(ejercito1, ejercito2);

        mapa.mostrarMapa();

        System.out.println("\n--- Información del Ejército 1 ---");
        ejercito1.mostrarEjercito();
        System.out.println("\n--- Información del Ejército 2 ---");
        ejercito2.mostrarEjercito();

        System.out.println("\n--- Resultado de la Batalla ---");
        int vidaE1 = ejercito1.getTotalVidaEjercito();
        int vidaE2 = ejercito2.getTotalVidaEjercito();

        System.out.println("Vida total Ejército 1: " + vidaE1);
        System.out.println("Vida total Ejército 2: " + vidaE2);

        if (vidaE1 > vidaE2) {
            System.out.println("¡El Ejército 1 gana la batalla!");
        } else if (vidaE2 > vidaE1) {
            System.out.println("¡El Ejército 2 gana la batalla!");
        } else {
            System.out.println("¡La batalla termina en empate!");
        }
    }
}