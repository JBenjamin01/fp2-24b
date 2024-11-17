import java.util.*;
public class AplicacionPayroll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[100];
        int count = 0;

        // Menú para agregar empleados
        while (true) {
            System.out.println("Seleccione el tipo de empleado a insertar:");
            System.out.println("1. Empleado por hora");
            System.out.println("2. Empleado asalariado");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            int option = sc.nextInt();
            sc.nextLine();

            if (option == 3) {
                break;
            }

            System.out.print("Ingrese el nombre del empleado: ");
            String name = sc.nextLine();

            if (option == 1) {
                System.out.print("Ingrese la tarifa por hora: ");
                double hourlyRate = sc.nextDouble();
                sc.nextLine();
                Hourly hourlyEmployee = new Hourly(name, hourlyRate);
                employees[count++] = hourlyEmployee;

            } else if (option == 2) {
                System.out.print("Ingrese el salario anual: ");
                double salary = sc.nextDouble();
                sc.nextLine();
                Salaried salariedEmployee = new Salaried(name, salary);
                employees[count++] = salariedEmployee;
            } else {
                System.out.println("Opción inválida. Inténtelo nuevamente.");
            }
        }

        // Asignar horas trabajadas a empleados por hora (8 horas diarias y 5 días a la semana)
        for (int i = 0; i < count; i++) {
            if (employees[i] instanceof Hourly) {
                ((Hourly) employees[i]).addHours(8 * 5); // Horas para una semana
            }
        }

        // Simulación de pagos para un mes de 30 días
        System.out.println("\nPagos para el mes (30 días, comenzando en martes):");

        int day = 1;
        int weekday = 2;

        while (day <= 30) {
            if (weekday == 5) {
                System.out.println("Viernes, día " + day + ": Pagos para empleados por horas");
                for (int i = 0; i < count; i++) {
                    if (employees[i] instanceof Hourly) {
                        System.out.println(employees[i]);
                    }
                }
            }

            if (day == 15 || day == 30) { // Días 15 y 30, paga a empleados asalariados
                System.out.println("Día " + day + ": Pagos para empleados asalariados");
                for (int i = 0; i < count; i++) {
                    if (employees[i] instanceof Salaried) {
                        System.out.println(employees[i]);
                    }
                }
            }

            day++;
            weekday = (weekday % 7) + 1; // Este es el iclo semanal (1-7)
        }
    }
}