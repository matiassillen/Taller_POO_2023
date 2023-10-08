
package Principal;

import VentanasGUI.GestionHospital;

import VentanasGUI.Recepcion;



public class Principal {

   
    public static void main(String[] args) {

        //GestionHospital admin = new GestionHospital();

        Recepcion admin = new Recepcion();
        admin.setVisible(true);
        admin.setLocationRelativeTo(null);
    }
    
}
