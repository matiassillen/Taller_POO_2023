package Model;


public class Especialidad extends FuncionarioGeneral {
    
    private int numMatriculaProfesional;
    
    public Especialidad() {
    }

    public Especialidad(int numMatriculaProfesional) {
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