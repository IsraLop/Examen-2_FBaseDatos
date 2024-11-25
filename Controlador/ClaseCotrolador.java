package Controlador;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.*;
import Vista.*;

public class ClaseCotrolador implements ActionListener {

    // Instancias de las clases que pertenecen a las carpetas modelo y vista
    LoginGUI venLog = new LoginGUI();

    // Método que abre la ventana de Login
    public void llamadoVentanaLogin() {  
        venLog.VenLoguin();  // Llama a la ventana de login
        venLog.btnIniciar.addActionListener(this); // Agrega el ActionListener al botón
    }

    // Maneja la acción del botón de iniciar sesión
    @Override
    public void actionPerformed(ActionEvent e) {
        // Verifica si el evento es generado por el botón de iniciar sesión
        if (e.getSource() == venLog.btnIniciar) {
            // Lógica para validar el inicio de sesión
            String usuario = venLog.tfUsuario.getText();  // Obtiene el texto del campo de usuario
            String contraseña = new String(venLog.pfContraseña.getPassword());  // Obtiene la contraseña del campo de contraseña

            // Llama a la función valAuxi con los parámetros necesarios
            valAuxi(usuario, contraseña);  
        }
    }

    // Llama al método validarUsuario pasando los parámetros usuario y contraseña
    public void valAuxi(String usuario, String contraseña) {
        // Llama al método validarUsuario pasando los parámetros usuario y contraseña
        if (ValidarUsuario.validarUsuario(usuario, contraseña)) {  // Aquí estamos llamando al método estático de ValidarUsuario

            // Si la validación es exitosa
            JOptionPane.showMessageDialog(null, "¡LA CONEXIÓN A LA BASE DE DATOS FUE EXITOSA!", "Título", JOptionPane.INFORMATION_MESSAGE);
            venLog.dispose();  // Cierra la ventana de login
            new CrudGUI();
        } else {
            // Si la validación falla
            JOptionPane.showMessageDialog(null, "Los datos no coinciden, intente nuevamente", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}
