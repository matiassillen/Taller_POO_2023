
package Principal;

import Model.Controladora;
import VentanasGUI.Administrador;

public class Principal {
    
    public static void main(String[] args) {
        Controladora control = new Controladora();
//        GuiLogin pantalla= new GuiLogin();
//        pantalla.setVisible(true);
//        pantalla.setLocationRelativeTo(null);

        Administrador pantalla = new Administrador(control);
        
        
    }
    
}
