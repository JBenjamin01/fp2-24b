public class Main {
    public static void main(String[] args) {
        // Creación de un estudiante usando agregación, el estudiante y la dirección se crean separado
        Direccion d = new Direccion("Calle Pizarro", "Arequipa", "Arequipa", "Perú");
        Estudiante e1 = new Estudiante(1, "Juan", d);
        
        // Creación del segundo estudiante usando composición, se hace la direccion dentro del constructor
        Estudiante e2 = new Estudiante(2, "Maria", new Direccion("Via Roma", 
                                                                    "Roma", 
                                                                    "Lacio", 
                                                                    "Italia"));

        e1.mostrarDatos();
        e2.mostrarDatos();
    }
}