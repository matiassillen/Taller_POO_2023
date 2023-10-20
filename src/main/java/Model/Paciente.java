package Model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paciente extends Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idP;
    private String persoDeContacto;
    private String telDeContacto;
    private List <AntecedenteClinico> antecedenteClinico;
    private List <ResultadoEstudio> resultadoEstudio;
    private List <Consulta> consulta;
    
    public Paciente() {
    }
    
    public Paciente(int idP, String persoDeContacto, String telDeContacto, List<AntecedenteClinico> antecedenteClinico, List<ResultadoEstudio> resultadoEstudio, List<Consulta> consulta, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.idP = idP;
        this.persoDeContacto = persoDeContacto;
        this.telDeContacto = telDeContacto;
        this.antecedenteClinico = antecedenteClinico;
        this.resultadoEstudio = resultadoEstudio;
        this.consulta = consulta;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getPersoDeContacto() {
        return persoDeContacto;
    }

    public void setPersoDeContacto(String persoDeContacto) {
        this.persoDeContacto = persoDeContacto;
    }

    public String getTelDeContacto() {
        return telDeContacto;
    }

    public void setTelDeContacto(String telDeContacto) {
        this.telDeContacto = telDeContacto;
    }

    public List<AntecedenteClinico> getAntecedenteClinico() {
        return antecedenteClinico;
    }

    public void setAntecedenteClinico(List<AntecedenteClinico> antecedenteClinico) {
        this.antecedenteClinico = antecedenteClinico;
    }

    public List<ResultadoEstudio> getResultadoEstudio() {
        return resultadoEstudio;
    }

    public void setResultadoEstudio(List<ResultadoEstudio> resultadoEstudio) {
        this.resultadoEstudio = resultadoEstudio;
    }

    public List<Consulta> getConsulta() {
        return consulta;
    }

    public void setConsulta(List<Consulta> consulta) {
        this.consulta = consulta;
    }
    
    

    public Paciente pacienteQMasConsulto(String fecha1, String fecha2) {
        // TODO implement here
        return null;
    }

}