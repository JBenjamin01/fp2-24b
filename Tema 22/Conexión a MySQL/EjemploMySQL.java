import java.sql.*;
public class EjemploMySQL {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/empresa";
        String usuario = "root";
        String contraseña = "jb301005";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            System.out.println("Conexión exitosa a la base de datos 'empresa'.");

            String consulta1 = "SELECT e.nombre AS empleado, e.edad, e.salario, d.nombre AS departamento "
                                + "FROM empleados e "
                                + "JOIN departamentos d ON e.departamento_id = d.id";
            try (Statement stmt = conexion.createStatement();
                    ResultSet rs1 = stmt.executeQuery(consulta1)) {
                System.out.println("Consulta 1: Empleados y su departamento");
                while (rs1.next()) {
                    String empleado = rs1.getString("empleado");
                    int edad = rs1.getInt("edad");
                    double salario = rs1.getDouble("salario");
                    String departamento = rs1.getString("departamento");
                    System.out.println("Empleado: " + empleado + ", Edad: " + edad
                                    + ", Salario: " + salario + ", Departamento: " + departamento);
                }
            }

            String consulta2 = "SELECT d.nombre AS departamento, AVG(e.salario) AS salario_promedio "
                                + "FROM empleados e "
                                + "JOIN departamentos d ON e.departamento_id = d.id "
                                + "GROUP BY d.nombre";
            try (Statement stmt = conexion.createStatement();
                    ResultSet rs2 = stmt.executeQuery(consulta2)) {
                System.out.println("\nConsulta 2: Salario promedio por departamento");
                while (rs2.next()) {
                    String departamento = rs2.getString("departamento");
                    double salarioPromedio = rs2.getDouble("salario_promedio");
                    System.out.println("Departamento: " + departamento + ", Salario Promedio: " + salarioPromedio);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}