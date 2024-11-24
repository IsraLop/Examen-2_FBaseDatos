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


}
