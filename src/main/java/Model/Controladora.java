package Model;

import Persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    ControladoraPersistencia controlPersis;

    public Controladora() {
        controlPersis = new ControladoraPersistencia();
    }
    
    
    
    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    public Rol traerRol(String rolRecibido) {
        List<Rol> listaRoles = controlPersis.traerRoles();
        
        for (Rol rol : listaRoles) {
            if (rol.getNombre().equals(rolRecibido)) {
                return rol;
            }
        }
        return null;
    }
}
