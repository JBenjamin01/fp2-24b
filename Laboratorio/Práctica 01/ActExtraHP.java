// LABORATORIO N° 1 - EJERCICIO lamsflmaefmoamwfmalsmflsamf
// AUTOR: JHONATAN BENJAMIN MAMANI CÉSPEDES
// TIEMPO: 999999 MINUTOS
class ActExtraHP {
    public static void main(String[] args){
        int n = (int)(Math.random() * (5 - 1) + 1);
        String[] soldados = new String[n];
        int[] hp = new int[n];
        for (int i = 0; i < n; i++){
            soldados[i] = "Soldado" + i;
            hp[i] = (int)(Math.random() * 5 + 1);
        }
        System.out.println("Datos del ejercito 1");
        System.out.println("Nombres    |   Vida");
        for (int j = 0; j < n; j++){
            System.out.print(soldados[j] + "\t");
            System.out.println(hp[j]);
        }
        for (int i = 0; i < n; i++){
            soldados[i] = "Soldado" + i;
            hp[i] = (int)(Math.random() * 5 + 1);
        }
        System.out.println("Datos del ejercito 2");
        System.out.println("Nombres    |   Vida");
        for (int j = 0; j < n; j++){
            System.out.print(soldados[j] + "\t");
            System.out.println(hp[j]);
        }

    }

}
