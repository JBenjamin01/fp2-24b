import java.util.*;
public class Soldado {
        private String reino;
        private int puntosVida;

        public Soldado(String reino) {
            Random random = new Random();
            this.reino = reino;
            this.puntosVida = random.nextInt(10) + 1; // Puntos de vida aleatorios entre 1 y 10
        }

        public String getReino() {
            return reino;
        }

        public int getPuntosVida() {
            return puntosVida;
        }
}