package Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class LicEnEnfermeria extends FuncSalud {
    
    @OneToMany
    List<Triage> triage;
    
    public LicEnEnfermeria() {
        triage = new ArrayList<>();
    }

    public LicEnEnfermeria(List<Triage> triage, Usuario usu, long id, String nombre, String apellido, String fechaDeNac, String domicilio, int dni, String telefonoFijo, String telefonoCel, String correoE, String estadoCivil) {
        super(usu, id, nombre, apellido, fechaDeNac, domicilio, dni, telefonoFijo, telefonoCel, correoE, estadoCivil);
        this.triage = triage;
    }

    public List<Triage> getTriage() {
        return triage;
    }

    public void setTriage(List<Triage> triage) {
        this.triage = triage;
    }

    public void setTriage(ArrayList<Triage> triage) {
        this.triage = triage;
    }
   
}