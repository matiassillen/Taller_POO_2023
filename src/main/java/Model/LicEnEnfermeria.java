package Model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;


@Entity
public class LicEnEnfermeria extends FuncionarioGeneral {
    
    @ManyToMany
    ArrayList<Triage> triage;
    
    public LicEnEnfermeria() {
        triage = new ArrayList<Triage>();
    }

    public LicEnEnfermeria(ArrayList<Triage> triage, long id, String nomUsuario, String passw, ArrayList<Rol> rol, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(id, nomUsuario, passw, rol, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.triage = triage;
    }

    public ArrayList<Triage> getTriage() {
        return triage;
    }

    public void setTriage(ArrayList<Triage> triage) {
        this.triage = triage;
    }
    
    
}