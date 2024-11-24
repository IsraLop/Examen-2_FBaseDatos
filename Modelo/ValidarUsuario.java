package Modelo;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidarUsuario {

    private String Usuario, contraseña;

    public static boolean validarUsuario(String usuario, String contraseña) {
        String spCall = "{CALL sp_validarUsuario(?, ?)}"; 

        try (Connection con = ConexionBD.getConexion(); 
             CallableStatement cbtmt = con.prepareCall(spCall)) {

            cbtmt.setString(1, usuario);
            cbtmt.setString(2, contraseña);

            try (ResultSet rs = cbtmt.executeQuery()) {
                
                return rs.next();
            }

        } catch (SQLException ex) {
            
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
