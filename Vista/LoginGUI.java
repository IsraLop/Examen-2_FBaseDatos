package Vista;

//Librerias
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {

    // Atributos de la clase
    public JTextField tfUsuario;
    public JPasswordField pfContraseña;
    public JLabel Lbusuario, LbContraseña;
    public JButton btnIniciar, btnCancelar;
    public JPanel panel;

    public LoginGUI() {
        setTitle("Ventana Login");//Titulo del panel 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Cerrar ventana con X

        // Panel con imagen de fondo
        panel = new JPanel() {
            private Image fondo = new ImageIcon(getClass().getResource("Imagenes/Fondo3.jpg")).getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this); // Fondo del panel
            }
        };//Panel con imagen de fondo

        panel.setLayout(null); // Desactivar el diseño de layout
        add(panel);
        eventos();
    }//Fin de constructor

    public void eventos() {
        // Etiqueta y campo de texto para usuario
        Lbusuario = new JLabel("Ingrese el nombre usuario:");
        Lbusuario.setBounds(240, 130, 200, 35);
        Lbusuario.setForeground(Color.WHITE);
        panel.add(Lbusuario);

        tfUsuario = new JTextField();
        tfUsuario.setBounds(240, 160, 300, 35);
        panel.add(tfUsuario);

        // Etiqueta y campo de texto para contraseña
        LbContraseña = new JLabel("Ingrese la contraseña:");
        LbContraseña.setBounds(240, 210, 200, 35);
        LbContraseña.setForeground(Color.WHITE);
        panel.add(LbContraseña);

        pfContraseña = new JPasswordField();
        pfContraseña.setBounds(240, 240, 300, 35);
        panel.add(pfContraseña);

        // Boton para iniciar sesion
        btnIniciar = crearBotonConEstilo("Ingresar", "Imagenes/ingresarbtn.png");
        btnIniciar.setBounds(240, 300, 150, 35);//Posicion y tamaño
        panel.add(btnIniciar);

        //Accion para iniciar sesion
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrudGUI ventana = new CrudGUI();
                ventana.setBounds(0, 0, 800, 600);//Posicion y tamaño
                ventana.setLocationRelativeTo(null);
                ventana.setVisible(true);//Hacer visible la ventana
                dispose();//Cierra la ventana actual
            }
        });

        // Boton para cancelar
        btnCancelar = crearBotonConEstilo("Cancelar", "Imagenes/btnsalir.png");
        btnCancelar.setBounds(390, 300, 150, 35);
        panel.add(btnCancelar);

        //Accion para cerrar 
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }//Fin de metodo eventos

    // Método para crear un boton con icono y texto
    private JButton crearBotonConEstilo(String texto, String rutaIcono) {
        JButton boton = new JButton(texto);
        boton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(rutaIcono)).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));//Busca el icono y se aplica redimension
        boton.setHorizontalTextPosition(SwingConstants.RIGHT); // Texto a la derecha
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));//Cursor de la mano
        return boton;
    }//Fin de metodo crearBotonEstilo
}//Fin de la clase