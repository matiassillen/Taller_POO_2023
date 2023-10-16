/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Usuario
 */
public class ValidacionLogin{

    private String rolUsuario;
    
    /*
    * El siguiente modulo debe validar tomando como datos de entrada 2 String
    */
    public boolean validar(String uss, String pass){
        return validacion(uss, pass);
    }
    
    // OPCION rolUsuario, tambien puede estar en otra clase principal luego de la validacion
    public String rolUsuario(String user, String passw){
        return extraerRol(user, passw);
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
    
    /*
    * OPCIONAL, puede estar en otra clase despues de la validacion
    * El siguiente metodo debe extraer el rol del usuario
    * para asignarle la interfaz que le corresponda
    */
    
    private String extraerRol(String us2, String pas2) {
        try{
            //Extraccion del rol mediante consulta a base de datos
            // utilizando us2 y pas2
            
            this.rolUsuario = "";
            return this.rolUsuario;
        }
        catch (Exception e) {
            return "Rol no encontrado";
        }
    } 
}
