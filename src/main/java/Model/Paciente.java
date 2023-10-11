package Model;
import java.io.Serializable;
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
    
    public Paciente() {
    }
    
    public Paciente(int idP, String persoDeContacto, String telDeContacto, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.idP = idP;
        this.persoDeContacto = persoDeContacto;
        this.telDeContacto = telDeContacto;
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

    public Paciente pacienteQMasConsulto(String fecha1, String fecha2) {
        // TODO implement here
        return null;
    }

}