// LABORATORIO N° 2 - EJERCICIO 1
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES
// TIEMPO: 32 MINUTOS

import java.util.*;
public class Cambiar {
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
        while(contador <= 6){
            letra = ingreseLetra();
            if (letraEnPalabraSecreta(letra, palSecreta))
                mostrarBlancosActualizados(letra);
            else  
                System.out.println(figuras[contador]);
            contador = contador +1;
        }
//COMPLETAR PARA INDICAR SI GANÓ, PERDIÓ Y CUÁNTOS TURNOS NECESITÓ
        System.out.println("\n");
    }
    public static String ingreseLetra(){
        String laLetra;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese letra: ");
        laLetra = sc.next();
        while(laLetra.length() != 1){ //COMPLETAR PARA VALIDAR CARACTERES PERMITIDOS a-z
            System.out.println("Ingrese letra: ");
            laLetra = sc.next();
        }
        return laLetra;
    }
    public static boolean letraEnPalabraSecreta(String letra, String palSecreta ){
//COMPLETAR
        return false;
    }
    public static void mostrarBlancosActualizados(String letra){
//COMPLETAR
        String vacios = "";
        for (int i = 0; i < letra.length(); i++){
            vacios += "_";
        }
        return letra + vacios;
        
    }
}