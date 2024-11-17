public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        
        Object[] xd = {perro, gato};

        for (Object x : xd) {
            System.out.println(x);
        }
    }
}