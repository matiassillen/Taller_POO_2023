
package Principal;


import Model.Controladora;
import Model.Paciente;
import VentanasGUI.Administrador;
import VentanasGUI.MedicoMasPacientes;
import VentanasGUI.RegistrarPaciente;
import VentanasGUI.VerDiagnosticoClinico;

public class Principal {

    public static void main(String[] args) {
        Controladora control = new Controladora();
        Paciente p = new Paciente();
        
        MedicoMasPacientes pantalla= new MedicoMasPacientes(control);
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
        
//        RegistrarPaciente buscar = new RegistrarPaciente();
//        buscar.setVisible(true);
//        buscar.setLocationRelativeTo(null);
        
        Administrador pantalla = new Administrador(control);
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);

//          GuiLogin pantalla = new GuiLogin();
//          pantalla.setVisible(true);
//          pantalla.setLocationRelativeTo(null);
          
    }
    
}
