package Model;


import java.util.*;


 

public class Recepciónista extends FuncionarioGeneral {
    
    private ArrayList <Paciente> paciente;

    public Recepciónista() {
    }

    public Recepciónista(ArrayList<Paciente> paciente) {
        this.paciente = paciente;
    }

    public ArrayList<Paciente> getPaciente() {
        return paciente;
    }

    public void setPaciente(ArrayList<Paciente> paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Recepci\u00f3nista{" + "paciente=" + paciente + '}';
    }

  

}
