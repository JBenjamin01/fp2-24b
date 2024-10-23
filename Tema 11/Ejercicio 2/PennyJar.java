public class PennyJar {
    public static final int GOAL = 10000;  // Esta es la meta fija para todas las jarras de mi clase
    private static int allPennies = 0;     // Cuenta total de monedas en todas las jarras
    private int pennies = 0;               // Monedas en la jarra actual

    public void addPenny() {
        pennies++;       // Incrementa el número de monedas en esta jarra
        allPennies++;    // Incrementa el número total de monedas en todas las jarras
        System.out.println("'clink'");

        // Verifica si se alcanzó o excedió la meta
        if (allPennies >= GOAL)
            System.out.println("¡Tiempo de compras!");
    }

    // Método para obtener el número de monedas de la jarra actual
    public int getPennies() {
        return pennies;
    }

    // Método para obtener el número total de monedas en todas las jarras
    public static int getAllPennies() {
        return allPennies;
    }
}