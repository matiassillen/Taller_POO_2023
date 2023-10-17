/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;

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
  
    /*
    * Validacion hace la logica de buscar y confirmar la existencia del usuario
    * @return boolean
    */
    private boolean validacion(String us, String pas){
        try{
            List<FuncionarioGeneral> listaBusqueda = traerFuncionariosEnGeneral();
            for (FuncionarioGeneral comprobar : listaBusqueda) {
                if (comprobar.getNomUsuario() == us){
                    if(comprobar.getPassw() == pas) {
                        return true;
                        
                    }
                    else {}
                }
                else {}
            }
            return false;
        }
        catch (Exception e) {
            return false;
        }
        
    }
}
