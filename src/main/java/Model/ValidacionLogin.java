/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Usuario
 */
public abstract class ValidacionLogin{

    
    /*
    * El siguiente modulo debe validar tomando como datos de entrada 2 String
    */
    public boolean validar(String uss, String pass){
        return validacion(uss, pass);
    }
  
    private boolean validacion(String us, String pas){
        try{
            String usernameValidation = us;
            String passwordValidation = pas;
            // Aca va un if que consulta en la base de datos si estan los datos us y pas
            // va a devolver un booleano que usara otro modulo para abrir la ventana correcta
            //if (boolean algo) {
            //    
            //    return true;
            //}
            //else {
                return false;
            //}
        }
        catch (Exception e) {
            return false;
        }
    }
}
