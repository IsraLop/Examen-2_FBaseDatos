package Modelo;

import java.sql.*;

import javax.swing.JOptionPane;

public class SP {

    private Connection conexion;

    public SP() {
        conexion = ConexionBD.getConexion();
    }

    // Método para insertar un usuario en la base de datos
    public void InsertarUsuario(String idUsuario, String primerNombre, String segundoNombre,
            String primerApellido, String segundoApellido, String login,
            String clave, java.sql.Date fechaCreacion) {

        // Definir la consulta SQL para el procedimiento almacenado
        String sql = "{ CALL InsertarUsuario(?, ?, ?, ?, ?, ?, ?, ?) }";

        try (CallableStatement stmt = conexion.prepareCall(sql)) {

            // Asignar los parámetros al procedimiento
            stmt.setString(1, idUsuario);
            stmt.setString(2, primerNombre);
            stmt.setString(3, segundoNombre);
            stmt.setString(4, primerApellido);
            stmt.setString(5, segundoApellido);
            stmt.setString(6, login);
            stmt.setString(7, clave);
            stmt.setDate(8, fechaCreacion);

            // Ejecutar el procedimiento y obtener el número de filas afectadas
            int filasInsertadas = stmt.executeUpdate();

            // Verificar si la inserción fue exitosa
            if (filasInsertadas > 0) {
                JOptionPane.showMessageDialog(null, "Usuario insertado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo insertar el usuario.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el usuario: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para actualizar un usuario en la base de datos
    public void ActualizarUsuario(String idUsuario, String primerNombre, String segundoNombre,
            String primerApellido, String segundoApellido,
            String login, String clave, String fechaCreacion) {
        String query = "{CALL ActualizarUsuario(?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection con = ConexionBD.getConexion();
                CallableStatement stmt = con.prepareCall(query)) {

            // Establecer los parámetros
            stmt.setString(1, idUsuario);
            stmt.setString(2, primerNombre);
            stmt.setString(3, segundoNombre);
            stmt.setString(4, primerApellido);
            stmt.setString(5, segundoApellido);
            stmt.setString(6, login);
            stmt.setString(7, clave);
            stmt.setString(8, fechaCreacion);

            // Ejecutar la actualización
            stmt.executeUpdate();
            System.out.println("Usuario actualizado exitosamente.");

        } catch (SQLException e) {
            System.err.println("Error al actualizar el usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String consultarUsuario(int idUsuario) {
        String resultado = ""; // Cadena para devolver los resultados
        String sql = "{CALL ConsultarUsuario(?)}";
    
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            // Establecer el parámetro de entrada
            stmt.setInt(1, idUsuario);
    
            // Ejecutar el procedimiento y obtener el resultado
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Procesar el resultado y construir la cadena
                    resultado = "ID Usuario: " + rs.getInt("id_usuario") + "\n" +
                            "Primer Nombre: " + rs.getString("primer_nombre") + "\n" +
                            "Segundo Nombre: " + rs.getString("segundo_nombre") + "\n" +
                            "Primer Apellido: " + rs.getString("primer_apellido") + "\n" +
                            "Segundo Apellido: " + rs.getString("segundo_apellido") + "\n" +
                            "Login: " + rs.getString("login") + "\n" +
                            "Clave: " + rs.getString("clave") + "\n" +
                            "Fecha Creación: " + rs.getDate("fecha_creacion") + "\n";
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar el usuario: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    
        return resultado; // Devolver la cadena con el resultado o vacía si no hay datos
    }
    

    // Método para eliminar un usuario de la base de datos por su ID
    public void EliminarUsuario(String idUsuario) throws SQLException {

        // Definir la consulta SQL para el procedimiento almacenado
        String sql = "{ CALL EliminarUsuario(?) }";

        try (CallableStatement stmt = conexion.prepareCall(sql)) {

            // Asignar el parámetro al procedimiento
            stmt.setString(1, idUsuario);

            // Ejecutar el procedimiento y obtener el número de filas afectadas
            int filasEliminadas = stmt.executeUpdate();

            // Verificar si la eliminación fue exitosa
            if (filasEliminadas > 0) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario. Verifique el ID proporcionado.",
                        "Resultado de la eliminación", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el usuario: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}