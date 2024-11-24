package Controlador;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.*;
import Vista.*;

// LO QUE ES EL MANEJO DE EVENTOS Y ACCIONES SE MANEJA EN LA CLASE CONTROLADOR

public class ClaseCotrolador implements ActionListener {
    // Instancias de las clases que pertenecen a las carpetas modelo y vista
    LoginGUI venLog = new LoginGUI();

    public void llamadoVentanaLogin() {  
    venLog.VenLoguin();;
    venLog.btnIniciar.addActionListener(this);
    }

     public void actionPerformed(ActionEvent e) {
            ValidarUsuario val = new ValidarUsuario();
            if (e.getSource() == venLog.btnIniciar) {
                // Lógica para validar el inicio de sesión
                val.setUsuario(venLog.tfUsuario.getText());
                val.setContraseña(venLog.pfContraseña.getText());
                valAuxi(val);
            } 
                     
        }

        public void valAuxi(ValidarUsuario in) {       
            if (in.validarUsuario()) {

     // ACÁ IRÍA EL LLAMADO AL METODO DE LA INTERFAZ QUE MUESTRA EL MENÚ PRINCIPAL


        JOptionPane.showMessageDialog(null, "¡¡LA CONECCIÓN A LA BASE DE DATOS FUE EXITOSA!!", "Título", JOptionPane.INFORMATION_MESSAGE);

                venLog.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "DATOS NO COICIDEN, INTENTE NUEVAMENTE", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
        }
}
