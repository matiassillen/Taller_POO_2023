
package Principal;


import VentanasGUI.Administrador;
import VentanasGUI.HacerTriage;
import VentanasGUI.Recepcion;



public class Principal {

   
    public static void main(String[] args) {

        //GestionHospital admin = new GestionHospital();

        HacerTriage admin = new HacerTriage();
        admin.setVisible(true);
        admin.setLocationRelativeTo(null);
        
//          Administrador pantalla = new Administrador();
//          pantalla.setVisible(true);
//          pantalla.setLocationRelativeTo(null);
    }
    
}
