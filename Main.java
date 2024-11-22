import Vista.LoginGUI;
public class Main {
    public static void main(String[] args) {
        LoginGUI ventana = new LoginGUI(); // Crear una instancia de la ventana de login
        ventana.setBounds(0, 0, 800, 600); // Establecer tamaño de la ventana
        ventana.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        ventana.setVisible(true); // Hacer visible la ventana
    }//main
}//clase