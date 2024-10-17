public class Prueba {
    public static void main(String []args){
        int contador = 1;
        String letra;
    String [] palabras = {"programacion", "java", "indentacion", "clases",
    "objetos", "desarrollador", "pruebas"};
    String palSecreta = getPalabraSecreta(palabras);
    System.out.print(palSecreta);
    mostrarBlancos(palSecreta);
    while(contador <= 6){
        letra = ingreseLetra();
        if (letraEnPalabraSecreta(letra, palSecreta))
            mostrarBlancosActualizados(letra);
        else  
            System.out.println(figuras[contador]);
        contador++;
    }

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
        for(int i=0; i< palabra.length(); i++)
            System.out.print("_ " );
    }
    public static void mostrarBlancosActualizados(String letra){
        //COMPLETAR
        System.out.println("PROCESANDO.....");
                
    }
}