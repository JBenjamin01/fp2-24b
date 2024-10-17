public class Main {
    public static void main(String[] args) {
        Fraccion f1 = new Fraccion(3, 4);
        Fraccion f2 = new Fraccion(7, 9);
        Fraccion f3 = new Fraccion(2, 6);
        Fraccion f4 = new Fraccion(5, 20);
        Fraccion f5 = new Fraccion(3, 7);

        // Encadenamiento de llamadas a métodos, sin modificar f1
        Fraccion resultado = f1.sumar(f2).sumar(f3).restar(f4).multiplicar(f5);
        
        System.out.println("Resultado final: " + resultado.mostrarFraccion() + " o " + resultado.mostrarDecimal());
        System.out.println("Valor original de f1: " + f1.mostrarFraccion()); // Aqui puedo comprobar que f1 sigue siendo 3/4
    }
}