package Model;

import java.util.ArrayList;


public class Especialidad extends FuncionarioGeneral {
    
    private int numMatriculaProfesional;

    public Especialidad() {
    }

    public Especialidad(int numMatriculaProfesional, long id, String nomUsuario, String passw, ArrayList<Rol> rol, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(id, nomUsuario, passw, rol, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.numMatriculaProfesional = numMatriculaProfesional;
    }

    public int getNumMatriculaProfesional() {
        return numMatriculaProfesional;
    }

    public void setNumMatriculaProfesional(int numMatriculaProfesional) {
        this.numMatriculaProfesional = numMatriculaProfesional;
    }
    
    
    public int getNumMatriPorf() {
        // TODO implement here
        return 0;
    }

}