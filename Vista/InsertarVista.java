package Vista;

import javax.swing.*;

import Modelo.SP;

import java.awt.*;
import java.io.File;

public class InsertarVista extends JFrame {

    public InsertarVista() {

        // Configuración de la ventana principal
        setTitle("Formulario de Registro de Usuarios");
        setSize(800, 600); // Tamaño ajustado
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana
        setLocationRelativeTo(null);

        // Cambiar color de fondo
        getContentPane().setBackground(new Color(245, 245, 220)); // Color beige claro

        // Configuración de layout principal
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setOpaque(false);
        add(panelPrincipal);

        // Configuración de layout y restricciones
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Crear título estilizado
        JLabel titulo = new JLabel("REGISTRO DE USUARIOS");
        titulo.setFont(new Font("Roboto", Font.BOLD, 28));
        titulo.setForeground(new Color(105, 105, 105)); // Gris oscuro
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
        panelPrincipal.add(titulo, gbc);

        // Crear etiquetas y campos de texto para cada columna
        JLabel labelID = crearEtiqueta("ID de Usuario:");
        JTextField txtID = crearCampoTexto("Ingrese el ID del usuario.");

        JLabel labelPrimerNombre = crearEtiqueta("Primer Nombre:");
        JTextField txtPrimerNombre = crearCampoTexto("Ingrese su primer nombre.");

        JLabel labelSegundoNombre = crearEtiqueta("Segundo Nombre:");
        JTextField txtSegundoNombre = crearCampoTexto("Ingrese su segundo nombre (opcional).");

        JLabel labelPrimerApellido = crearEtiqueta("Primer Apellido:");
        JTextField txtPrimerApellido = crearCampoTexto("Ingrese su primer apellido.");

        JLabel labelSegundoApellido = crearEtiqueta("Segundo Apellido:");
        JTextField txtSegundoApellido = crearCampoTexto("Ingrese su segundo apellido (opcional).");

        JLabel labelLogin = crearEtiqueta("Login:");
        JTextField txtLogin = crearCampoTexto("Ingrese el nombre de usuario para el inicio de sesión.");

        JLabel labelClave = crearEtiqueta("Clave:");
        JTextField txtClave = crearCampoTexto("Ingrese la clave del usuario.");

        JLabel labelFechaCreacion = crearEtiqueta("Fecha de Creación:");
        JTextField txtFechaCreacion = crearCampoTexto("Ingrese la fecha de creación en formato AAAA-MM-DD.");

        // Posicionar etiquetas y campos de texto
        int fila = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;

        for (int i = 0; i < 8; i++) {
            JLabel etiqueta = null;
            JTextField campo = null;

            switch (i) {
                case 0 -> { etiqueta = labelID; campo = txtID; }
                case 1 -> { etiqueta = labelPrimerNombre; campo = txtPrimerNombre; }
                case 2 -> { etiqueta = labelSegundoNombre; campo = txtSegundoNombre; }
                case 3 -> { etiqueta = labelPrimerApellido; campo = txtPrimerApellido; }
                case 4 -> { etiqueta = labelSegundoApellido; campo = txtSegundoApellido; }
                case 5 -> { etiqueta = labelLogin; campo = txtLogin; }
                case 6 -> { etiqueta = labelClave; campo = txtClave; }
                case 7 -> { etiqueta = labelFechaCreacion; campo = txtFechaCreacion; }
            }

            gbc.gridx = 0;
            gbc.gridy = fila++;
            panelPrincipal.add(etiqueta, gbc);

            gbc.gridx = 1;
            panelPrincipal.add(campo, gbc);
        }

        // Crear botones estilizados
        JButton btnInsertar = crearBoton("Insertar", "Haga clic para insertar los datos.", "imagenes/insertar2.png",
                new Color(60, 179, 113), Color.WHITE); // Verde con texto blanco
       // Método para el botón Insertar

     btnInsertar.addActionListener(e -> {
    // Obtener los valores de los campos de texto
    String idUsuario = txtID.getText();
    String primerNombre = txtPrimerNombre.getText();
    String segundoNombre = txtSegundoNombre.getText();
    String primerApellido = txtPrimerApellido.getText();
    String segundoApellido = txtSegundoApellido.getText();
    String login = txtLogin.getText();
    String clave = txtClave.getText();
    String fechaCreacionStr = txtFechaCreacion.getText();

    // Validación de los campos (si es necesario)
    if (idUsuario.isEmpty() || primerNombre.isEmpty() || primerApellido.isEmpty() || login.isEmpty() || clave.isEmpty() || fechaCreacionStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
        return; // No continuar si hay campos vacíos
    }

    // Convertir la fecha de creación de String a java.sql.Date
    java.sql.Date fechaCreacion = null;
    try {
        fechaCreacion = java.sql.Date.valueOf(fechaCreacionStr);
    } catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use AAAA-MM-DD.", "Error de fecha", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Llamar al método InsertarUsuario de la clase SP (Modelo)
    SP sp = new SP();
    sp.InsertarUsuario(idUsuario, primerNombre, segundoNombre, primerApellido, segundoApellido, login, clave, fechaCreacion);

    // Limpiar los campos después de insertar
    txtID.setText("");
    txtPrimerNombre.setText("");
    txtSegundoNombre.setText("");
    txtPrimerApellido.setText("");
    txtSegundoApellido.setText("");
    txtLogin.setText("");
    txtClave.setText("");
    txtFechaCreacion.setText("");
});

        JButton btnRegresar = crearBoton("Regresar", "Regresa al menú principal.", "imagenes/salir.png",
                new Color(30, 144, 255), Color.WHITE); // Azul con texto blanco
        btnRegresar.addActionListener(e -> {
            this.dispose();
            new CrudGUI();
        });

        // Posicionar botones
        gbc.gridx = 0;
        gbc.gridy = fila++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(btnInsertar, gbc);

        gbc.gridy = fila++;
        panelPrincipal.add(btnRegresar, gbc);

        // Mostrar la ventana
        setVisible(true);
    }

    private JLabel crearEtiqueta(String texto) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setForeground(new Color(105, 105, 105)); // Gris oscuro
        etiqueta.setFont(new Font("Arial", Font.BOLD, 14));
        return etiqueta;
    }

    private JTextField crearCampoTexto(String tooltip) {
        JTextField campoTexto = new JTextField(20);
        campoTexto.setToolTipText(tooltip);
        campoTexto.setFont(new Font("Arial", Font.PLAIN, 16));
        campoTexto.setPreferredSize(new Dimension(300, 30));
        return campoTexto;
    }

    private JButton crearBoton(String texto, String tooltip, String rutaIcono, Color colorFondo, Color colorTexto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setFocusPainted(false);
        boton.setToolTipText(tooltip);
        boton.setBackground(colorFondo);
        boton.setForeground(colorTexto);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(150, 30));

        if (new File(rutaIcono).exists()) {
            ImageIcon icono = new ImageIcon(rutaIcono);
            boton.setIcon(new ImageIcon(icono.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
            boton.setHorizontalTextPosition(SwingConstants.RIGHT);
        }

        return boton;
    }
}