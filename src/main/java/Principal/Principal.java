
package Principal;


import Model.Controladora;
import VentanasGUI.Administrador;
import VentanasGUI.BuscarPaciente;

public class Principal {

    public static void main(String[] args) {
        Controladora control = new Controladora();
        
//        BuscarPaciente buscar = new BuscarPaciente();
//        buscar.setVisible(true);
//        buscar.setLocationRelativeTo(null);
        
        Administrador pantalla = new Administrador(control);
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);

    }
    
}
