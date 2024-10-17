public class Main {
    public static void main(String[] args) {
        Fraccion f1 = new Fraccion(3, 4);
        Fraccion f2 = new Fraccion(5, 6);
        
        System.out.println("Fracción 1: " + f1.mostrarFraccion());
        System.out.println("Fracción 1 en decimal: " + f1.mostrarDecimal());
        
        System.out.println("Fracción 2: " + f2.mostrarFraccion());
        System.out.println("Fracción 2 en decimal: " + f2.mostrarDecimal());
        
        Fraccion suma = f1.sumar(f2);
        System.out.println("Suma: " + suma.mostrarFraccion() + " o " + suma.mostrarDecimal());
        
        Fraccion resta = f1.restar(f2);
        System.out.println("Resta: " + resta.mostrarFraccion() + " o " + resta.mostrarDecimal());
        
        Fraccion multiplicacion = f1.multiplicar(f2);
        System.out.println("Multiplicación: " + multiplicacion.mostrarFraccion() + " o " + multiplicacion.mostrarDecimal());
        
        Fraccion division = f1.dividir(f2);
        System.out.println("División: " + division.mostrarFraccion() + " o " + division.mostrarDecimal());
        
        Fraccion f3 = new Fraccion(16, 28);
        Fraccion f3Simplificada = f3.simplificar();
        System.out.println("Fracción original: " + f3.mostrarFraccion());
        System.out.println("Fracción simplificada: " + f3Simplificada.mostrarFraccion());
    }
}