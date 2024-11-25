package Vista;

// Librerías
import javax.swing.*;
import java.awt.*;

public class LoginGUI extends JFrame {

    // Atributos de la clase
    public JTextField tfUsuario;
    public JPasswordField pfContraseña;
    public JLabel Lbusuario, LbContraseña;
    public JButton btnIniciar, btnCancelar;
    public JPanel panel;

    public void VenLoguin() {
        setTitle("Ventana login"); // Título del panel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar ventana con X
        setSize(800, 600); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setTitle("Ventana Login"); // Título del panel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar ventana con X

        // Panel con imagen de fondo
        panel = new JPanel() {
            private Image fondo = new ImageIcon(getClass().getResource("Imagenes/Fondo3.jpg")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this); // Fondo del panel
            }
        }; // Panel con imagen de fondo

        panel.setLayout(null); // Desactivar el diseño de layout
        add(panel);
        configurarComponentes();
    } // Fin del constructor

    private void configurarComponentes() {
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

        // Botón para iniciar sesión
        btnIniciar = crearBotonConEstilo("Ingresar", "Imagenes/ingresarbtn.png");
        btnIniciar.setBounds(240, 300, 150, 35); // Posición y tamaño
        panel.add(btnIniciar);

        // Botón para cancelar
        btnCancelar = crearBotonConEstilo("Cancelar", "Imagenes/btnsalir.png");
        btnCancelar.setBounds(390, 300, 150, 35);
        panel.add(btnCancelar);

        setVisible(true);
    } // Fin del método configurarComponentes

    // Método para crear un botón con icono y texto
    private JButton crearBotonConEstilo(String texto, String rutaIcono) {
        JButton boton = new JButton(texto);
        boton.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(rutaIcono)).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH))); // Busca el icono y se aplica redimensión
        boton.setHorizontalTextPosition(SwingConstants.RIGHT); // Texto a la derecha
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cursor de la mano
        return boton;
    } // Fin del método crearBotonEstilo
} // Fin de la clase
