package Model;


public class Especialidad extends FuncionarioGeneral {
    
    private int numMatriculaProfesional;

    public Especialidad(String nomUsuario, String passw, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, int telefonoFijo, int telefonoCel, String correoE, String estadoCivil) {
        super(nomUsuario, passw, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
    }

    public Especialidad(int numMatriculaProfesional, String nomUsuario, String passw, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, int telefonoFijo, int telefonoCel, String correoE, String estadoCivil) {
        super(nomUsuario, passw, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
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