package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 */

@Entity
public enum Box {
    
    BOX1(1, false),
    BOX2(2, false),
    BOX3(3, false),
    BOX4(4, false),
    BOX5(5, false),
    BOX6(6, false),
    BOX7(7, false),
    BOX8(8, false);
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private final Integer numer;
    private Boolean estado;

    
    /**
     * Default constructor
     */
    
    private Box(Integer numer, Boolean estado) {    
        this.numer = numer;
        this.estado = estado;
    }

    /**
     * @return retorna un integer que es el numero especifico de cada box  
     */
    public Integer getNumer() {
        return numer;
    }
  
    /**
     * @return retorna un booleano del estado del box, true = ocupado y false = libre
     */
    public Boolean getEstado() {
        return estado;
    }
    /**
     * Cambia el estado del box
     */
    public void setEstado() {
        this.estado = !this.estado;
                
    }
}