package Modelo;
import java.sql.*;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/bd_actualizada";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678"; // Cambiar la contraseña por la de ustedes

    public static Connection getConexion() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

