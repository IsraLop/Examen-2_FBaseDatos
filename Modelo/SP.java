package Modelo;

import java.sql.*;

public class SP {

    private Connection conexion;

    public SP() {
        conexion = ConexionBD.getConexion();
    }

    public boolean EliminarUsuario(String id_usuario) {
        String sql = "{ CALL DELETE(?) }";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setString(1, id_usuario);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean InsertarUsuario(String idUsuario, String primerNombre, String segundoNombre,
            String primerApellido, String segundoApellido, String login,
            String clave, java.sql.Date fechaCreacion) {

        String sql = "{ CALL InsertarUsuario(?, ?, ?, ?, ?, ?, ?, ?) }";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setString(1, idUsuario);
            stmt.setString(2, primerNombre);
            stmt.setString(3, segundoNombre);
            stmt.setString(4, primerApellido);
            stmt.setString(5, segundoApellido);
            stmt.setString(6, login);
            stmt.setString(7, clave);
            stmt.setDate(8, fechaCreacion);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0; // Retorna true si se insertó el usuario
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retorna false si ocurre un error
        }
    }

    
    public boolean ActualizarUsuario(String idUsuario, String primerNombre, String segundoNombre,
            String primerApellido, String segundoApellido, String login,
            String clave) {
        String sql = "{ CALL ActualizarUsuario(?, ?, ?, ?, ?, ?, ?) }";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setString(1, idUsuario);
            stmt.setString(2, primerNombre);
            stmt.setString(3, segundoNombre);
            stmt.setString(4, primerApellido);
            stmt.setString(5, segundoApellido);
            stmt.setString(6, login);
            stmt.setString(7, clave);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0; // Retorna true si se actualizó el usuario
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retorna false si ocurre un error
        }
    }
   

    public ResultSet ConsultarUsuario(String idUsuario) {
        String sql = "{ CALL ConsultarUsuario(?) }";
        try {
            CallableStatement stmt = conexion.prepareCall(sql);
            stmt.setString(1, idUsuario);
            return stmt.executeQuery(); // Retorna el ResultSet con el resultado de la consulta
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Retorna null si ocurre un error
        }

    }
}
