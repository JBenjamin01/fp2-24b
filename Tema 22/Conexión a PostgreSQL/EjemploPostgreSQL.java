import java.sql.*;

public class EjemploPostgreSQL {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/prueba";
        String user = "postgres";
        String password = "301005";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a PostgreSQL");

            String query1 = "SELECT * FROM ejemplo";
            try (Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(query1)) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + ", Nombre: " + rs.getString("nombre")
                                    + ", Edad: " + rs.getInt("edad"));
                }
            }

            String query2 = "SELECT e.nombre, d.direccion FROM ejemplo e JOIN direcciones d ON e.id = d.ejemplo_id";
            try (Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(query2)) {
                while (rs.next()) {
                    System.out.println("Nombre: " + rs.getString("nombre") + ", Dirección: " + rs.getString("direccion"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}