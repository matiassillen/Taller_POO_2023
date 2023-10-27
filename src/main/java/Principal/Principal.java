
package Principal;


import Model.Controladora;
import Model.Paciente;
import VentanasGUI.Administrador;
import VentanasGUI.CantTriageColor;
import VentanasGUI.GuiLogin;
import VentanasGUI.HacerTriage;
import VentanasGUI.MedicoMasPacientes;
import VentanasGUI.RegistrarPaciente;
import VentanasGUI.TriageCambiado;
import VentanasGUI.VerDiagnosticoClinico;

public class Principal {

    public static void main(String[] args) {
        Controladora control = new Controladora();
//        Paciente p = new Paciente();

//        CantTriageColor pantalla= new CantTriageColor();
         //Paciente p = new Paciente();
        
//        HacerTriage pantalla= new HacerTriage(control,idConsulta);
//        pantalla.setVisible(true);
//        pantalla.setLocationRelativeTo(null);
        
//        TriageCambiado pantalla= new TriageCambiado(control);
//        pantalla.setVisible(true);
//        pantalla.setLocationRelativeTo(null);
        
    RegistrarPaciente buscar = new RegistrarPaciente(control);
    buscar.setVisible(true);
    buscar.setLocationRelativeTo(null);
        
//        Administrador pantalla = new Administrador(control);
//        pantalla.setVisible(true);
//        pantalla.setLocationRelativeTo(null);
        
//        MedicoMasPacientes pantalla= new MedicoMasPacientes(control);
//        pantalla.setVisible(true);
//        pantalla.setLocationRelativeTo(null);
        
//        RegistrarPaciente buscar = new RegistrarPaciente(control);
//        buscar.setVisible(true);
//        buscar.setLocationRelativeTo(null);

//        GuiLogin pantalla = new GuiLogin();
//        pantalla.setVisible(true);
//        pantalla.setLocationRelativeTo(null);
//          
    }
    
}
