import java.util.*;
public class Soldado {
    private String tipo;
    private int nivelVida;

    public Soldado(String tipo, int nivelVida) {
        this.tipo = tipo;
        this.nivelVida = nivelVida;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    // Método estático para generar un soldado aleatorio
    public static Soldado generarSoldado(Random random) {
        String[] tipos = {"Arquero", "Espadachín", "Caballero"};
        String tipo = tipos[random.nextInt(tipos.length)];
        int nivelVida = 0;

        switch (tipo) {
            case "Arquero":
                nivelVida = random.nextInt(3) + 3;
                break;
            case "Espadachín":
                nivelVida = random.nextInt(3) + 5;
                break;
            case "Caballero":
                nivelVida = random.nextInt(3) + 7;
                break;
        }
        return new Soldado(tipo, nivelVida);
    }

    @Override
    public String toString() {
        return tipo + " (Vida: " + nivelVida + ")";
    }
}