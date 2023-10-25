
package Principal;


import Model.Controladora;
import Model.Paciente;
import VentanasGUI.Administrador;
import VentanasGUI.RegistrarPaciente;
import VentanasGUI.VerDiagnosticoClinico;

public class Principal {

    public static void main(String[] args) {
        Controladora control = new Controladora();
        Paciente p = new Paciente();
        
//        RegistrarPaciente buscar = new RegistrarPaciente();
//        buscar.setVisible(true);
//        buscar.setLocationRelativeTo(null);

        VerDiagnosticoClinico pantalla = new VerDiagnosticoClinico(control,p);
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);        


//        Administrador pantalla = new Administrador(control);
//        pantalla.setVisible(true);
//        pantalla.setLocationRelativeTo(null);
//        

    }
    
}
