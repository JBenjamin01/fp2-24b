// LABORATORIO N° 2 - EJERCICIO 1
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES
// TIEMPO: 36 MINUTOS (EN PROCESO)

import java.util.*;
public class Ejercicio1 {
    public static void main(String []args){
        String ahor1 = "  +---+ \n"+
                       "  |   | \n" +
                       "      | \n" +
                       "      | \n" +
                       "      | \n" +
                       "      | \n" +
                       "========= ";
        String ahor2 = "  +---+ \n"+
                       "  |   | \n" +
                       "  O   | \n" +
                       "      | \n" +
                       "      | \n" +
                       "      | \n" +
                       "========= ";
        String ahor3 = "  +---+ \n"+
                       "  |   | \n" +
                       "  O   | \n" +
                       "  |   | \n" +
                       "      | \n" +
                       "      | \n" +
                       "========= ";
        String ahor4 = "  +---+ \n"+
                       "  |   | \n" +
                       "  O   | \n" +
                       " /|   | \n" +
                       "      | \n" +
                       "      | \n" +
                       "========= ";
        String ahor5 = "  +---+ \n"+
                       "  |   | \n" +
                       "  O   | \n" +
                       " /|\\  | \n" +
                       "      | \n" +
                       "      | \n" +
                       "========= ";
        String ahor6 = "  +---+ \n"+
                       "  |   | \n" +
                       "  O   | \n" +
                       " /|\\  | \n" +
                       " /    | \n" +
                       "      | \n" +
                       "========= ";
        String ahor7 = "  +---+ \n"+
                       "  |   | \n" +
                       "  O   | \n" +
                       " /|\\  | \n" +
                       " / \\  | \n" +
                       "      | \n" +
                       "========= ";
        String [] figuras = {ahor1, ahor2, ahor3, ahor4, ahor5, ahor6, ahor7};
        int contador = 1;
        String letra;
        String [] palabras = {"programacion", "java", "indentacion", "clases",
                                        "objetos", "desarrollador", "pruebas"};
        String palSecreta = getPalabraSecreta(palabras);
        System.out.println(figuras[0]);
        mostrarBlancos(palSecreta);
        System.out.println("\n");
//COMPLETAR Y/O CORREGIR PARA QUE FUNCIONE EL JUEGO
        while (contador <= 6){
            letra = ingreseLetra();
            if (letraEnPalabraSecreta(letra, palSecreta))
                mostrarBlancosActualizados(letra, palSecreta);
            else  
                System.out.println(figuras[contador]);
            contador++;
        }
        if (contador > 6)
            System.out.println("Has perdido. La palabra era: " + palSecreta);
        else
            System.out.println("¡Has ganado! Te tomó " + (contador - 1) + " turnos adivinar la palabra.");
//COMPLETAR PARA INDICAR SI GANÓ, PERDIÓ Y CUÁNTOS TURNOS NECESITÓ
        System.out.println("\n");
    }
    public static String getPalabraSecreta(String [] lasPalabras){
        String palSecreta;
        int ind;
        int indiceMayor = lasPalabras.length -1;
        int indiceMenor =0;
        ind = (int) ((Math.random() * (indiceMayor - indiceMenor + 1) + indiceMenor));
        return lasPalabras[ind];
    }
    public static void mostrarBlancos(String palabra){
        for(int i = 0; i < palabra.length(); i++)
            System.out.print("_ " );
    }
    public static String ingreseLetra(){
        String abc = "abcdefghijklmnopqrstuvwxyz";
        String laLetra;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese letra: ");
        laLetra = sc.next();
        char letra = laLetra.charAt(0);
        while (laLetra.length() != 1 || abc.indexOf(letra) == -1){
            System.out.println("Ingrese letra: ");
            laLetra = sc.next();
            letra = laLetra.charAt(0);
        }
        return laLetra;
    }
    public static boolean letraEnPalabraSecreta(String letra, String palSecreta ){
        for (int i = 0; i < palSecreta.length(); i++)
            if (palSecreta.charAt(i) == letra.charAt(0))
                return true;
        return false;
    }
    public static void mostrarBlancosActualizados(String letra, String palSecreta){
        char[] palabraArray = palSecreta.toCharArray();

        for (int i = 0; i < palSecreta.length(); i++) {
            if (palSecreta.charAt(i) == letra.charAt(0)) {
                palabraArray[i] = letra.charAt(0);
            }
        }

        String palabraActualizada = new String(palabraArray);
        System.out.println(palabraActualizada);
    }
}