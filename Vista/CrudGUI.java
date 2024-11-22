package Vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class CrudGUI extends JFrame{
    private JPanel panel;
    private JLabel LbMensaje;

    public CrudGUI() {

    setTitle("Ventana CRUD"); // Título de la ventana
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Comportamiento al cerrar la ventana
    panel = new JPanel();
    panel.setLayout(null); // Desactivar el diseño de layout
    add(panel); // Agregar el panel principal a la ventana actual

    AgregarComponentes();//Metodo para agregar componentes
    }//Fin del constructor   

    public void AgregarComponentes() {
        LbMensaje = new JLabel("Bienvenido al CRUD");
        LbMensaje.setBounds(240, 130, 200, 35);//Posicion
        LbMensaje.setForeground(Color.black); // Color 
        LbMensaje.setFont(new Font("Arial", Font.BOLD, 20)); // Fuente 
        panel.add(LbMensaje);
    }
}//Fin de la clase CrudGUI