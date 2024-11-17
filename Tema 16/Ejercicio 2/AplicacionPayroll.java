public class AplicacionPayroll {
    public static void main(String[] args) {
        Employee[] employees = new Employee[100];
        employees[0] = new Hourly("Anna", 25.0);
        employees[1] = new Salaried("Simon", 48000.0);
        employees[2] = new Hourly("Donovan", 20.0);

        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i] instanceof Hourly) {
                Hourly hourlyEmployee = (Hourly) employees[i];
                hourlyEmployee.addHours(160);
            }

            System.out.println(employees[i]); // Llamada a toString() aprovechando el polimorfismo
        }
    }
}