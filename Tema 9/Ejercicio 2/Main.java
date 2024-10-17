public class Main {
    public static void main(String[] args) {
        Fraccion f1 = new Fraccion(7, 9);
        Fraccion f2 = new Fraccion(5, 13);

        // Usando los métodos de instancia
        Fraccion suma = f1.sumar(f2);
        Fraccion diferencia = f1.restar(f2);
        Fraccion producto = f1.multiplicar(f2);
        Fraccion cociente = f1.dividir(f2);

        // Usando los métodos de clase
        Fraccion sumaStatic = Fraccion.sumar(f1, f2);
        Fraccion diferenciaStatic = Fraccion.restar(f1, f2);
        Fraccion productoStatic = Fraccion.multiplicar(f1, f2);
        Fraccion cocienteStatic = Fraccion.dividir(f1, f2);

        // Usando los métodos de la clase Main
        Fraccion sumaMain = sumar(f1, f2);
        Fraccion diferenciaMain = restar(f1, f2);
        Fraccion productoMain = multiplicar(f1, f2);
        Fraccion cocienteMain = dividir(f1, f2);

        System.out.println("* Resultados de los métodos de instancia:");
        System.out.println("   - Suma: " + suma.getNumerador() + "/" + suma.getDenominador());
        System.out.println("   - Diferencia: " + diferencia.getNumerador() + "/" + diferencia.getDenominador());
        System.out.println("   - Producto: " + producto.getNumerador() + "/" + producto.getDenominador());
        System.out.println("   - Cociente: " + cociente.getNumerador() + "/" + cociente.getDenominador());

        System.out.println("\n* Resultados de los métodos de clase:");
        System.out.println("   - Suma: " + sumaStatic.getNumerador() + "/" + sumaStatic.getDenominador());
        System.out.println("   - Diferencia: " + diferenciaStatic.getNumerador() + "/" + diferenciaStatic.getDenominador());
        System.out.println("   - Producto: " + productoStatic.getNumerador() + "/" + productoStatic.getDenominador());
        System.out.println("   - Cociente: " + cocienteStatic.getNumerador() + "/" + cocienteStatic.getDenominador());

        System.out.println("\n* Resultados de los métodos de la clase princial (main):");
        System.out.println("   - Suma: " + sumaMain.getNumerador() + "/" + sumaMain.getDenominador());
        System.out.println("   - Diferencia: " + diferenciaMain.getNumerador() + "/" + diferenciaMain.getDenominador());
        System.out.println("   - Producto: " + productoMain.getNumerador() + "/" + productoMain.getDenominador());
        System.out.println("   - Cociente: " + cocienteMain.getNumerador() + "/" + cocienteMain.getDenominador());
    }

    public static Fraccion sumar(Fraccion a, Fraccion b) {
        return a.sumar(b);
    }

    public static Fraccion restar(Fraccion a, Fraccion b) {
        return a.restar(b);
    }

    public static Fraccion multiplicar(Fraccion a, Fraccion b) {
        return a.multiplicar(b);
    }

    public static Fraccion dividir(Fraccion a, Fraccion b) {
        return a.dividir(b);
    }
}
