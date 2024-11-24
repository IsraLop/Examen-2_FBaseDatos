package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidarUsuario {

    private String Usuario, contraseña;

    public boolean validarUsuario() {
        String spCall = "{CALL sp_validarUsuario(?, ?)}"; // Llamada al procedimiento almacenado

        // Establecer la conexión a la base de datos y ejecutar el SP dentro del try-with-resources
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/GitHub?verifyServerCertificate=false&useSSL=true", 
                "root", 
                "Isra1107.");
             CallableStatement cbtmt = con.prepareCall(spCall)) {

            // Establecer los parámetros del procedimiento almacenado
            cbtmt.setString(1, getUsuario());   // Nombre de usuario
            cbtmt.setString(2, getContraseña()); // Contraseña

            // Ejecuta el SP y devuelve si el usuario es válido
            try (ResultSet rs = cbtmt.executeQuery()) {
                return rs.next(); // Si hay un resultado, el usuario es válido
            }

        } catch (SQLException ex) {
            // Manejo adecuado de excepciones, con un mensaje más claro
            System.err.println("Error al validar el usuario: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    // Getters y setters
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
