package Model;
import java.util.ArrayList;
public class Paciente extends Persona {
    
    private String persoDeContacto;
    private String telDeContacto;
    private ArrayList<Consulta>consulta;
    private Estadistica estadistica;
    private ArrayList<ResultadoEstudio>resultadoEstudio;
    private ArrayList<AntecedenteClinico>antecedenteClinico;
    public Paciente() {
    }
    
    
    public Paciente(String nombre, String apellido, String fechaDeNac, String domicilio, int dni, int telefonoFijo, int telefonoCel, String correoE, String estadoCivil, String nombreP, String apellidoP, int telefonoCelP, String persoDeContacto, String telDeContacto, ArrayList<Consulta>consulta, Estadistica estadistica, ArrayList<ResultadoEstudio>resultadoEstudio, ArrayList<AntecedenteClinico>antecedenteClinico) {
        super(nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.persoDeContacto = persoDeContacto;
        this.telDeContacto = telDeContacto;
        this.consulta = consulta;
        this.estadistica = estadistica;
        this.resultadoEstudio = resultadoEstudio;
        this.antecedenteClinico = antecedenteClinico;
    }
    
    public String getPersoDeContacto() {
        
        return persoDeContacto;
    }

    public void setPersoDeContacto(String persoDeContacto) {
        // TODO implement here
        this.persoDeContacto = persoDeContacto;
    }

    public String getTelDeContacto() {
        return telDeContacto;
    }

    public void setTelDeContacto(String telDeContacto) {
        this.telDeContacto = telDeContacto;
    }

    public ArrayList<Consulta> getConsulta() {
        return consulta;
    }

    public void setConsulta(ArrayList<Consulta> consulta) {
        this.consulta = consulta;
    }

    public Estadistica getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(Estadistica estadistica) {
        this.estadistica = estadistica;
    }

    public ArrayList<ResultadoEstudio> getResultadoEstudio() {
        return resultadoEstudio;
    }

    public void setResultadoEstudio(ArrayList<ResultadoEstudio> resultadoEstudio) {
        this.resultadoEstudio = resultadoEstudio;
    }

    public ArrayList<AntecedenteClinico> getAntecedenteClinico() {
        return antecedenteClinico;
    }

    public void setAntecedenteClinico(ArrayList<AntecedenteClinico> antecedenteClinico) {
        this.antecedenteClinico = antecedenteClinico;
    }
    
    
    public Paciente pacienteQMasConsulto(String fecha1, String fecha2) {
        // TODO implement here
        return null;
    }

    
    
    
    
}