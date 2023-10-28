package Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Clase EsperaTriage que gestiona la cola de espera de las consultas para el
 * triage.
 *
 * @author yairc
 */
@Entity
public class EsperaTriage {

    @Transient
    // Cola para las consultas en espera de triage
    private Queue<Consulta> enEsperaT;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private List<Consulta> EnEsperaPersis;

    /**
     * Constructor de la clase EsperaTriage.
     */
    public EsperaTriage() {
        this.enEsperaT = new LinkedList<>();
        this.EnEsperaPersis = new LinkedList<>();
    }

    /**
     * Método para quitar una consulta de la fila de espera de triage.
     *
     * @param t El triage asignado a la consulta.
     * @return La consulta que ha sido quitada de la fila.
     */
    public Consulta QuitarDeFila(Triage t) {
        Consulta consu = this.enEsperaT.poll();
        consu.setTriage(t);
        this.espejarFilas();
        return consu;
    }

    /**
     * Getter para obtener las consultas en espera de triage.
     *
     * @return fila de las consultas en espera de triage.
     */
    public List<Consulta> getEnEsperaPersis() {
        return EnEsperaPersis;
    }

    /**
     * Método para añadir una consulta a la fila de espera de triage.
     *
     * @param consu La consulta a añadir a la fila.
     */
    public void AñadirALaFila(Consulta consu) {
        enEsperaT.add(consu);
        this.espejarFilas();
    }

    /**
     * Getter para obtener las consultas en espera de triage.
     *
     * @return La cola de las consultas en espera de triage.
     */
    public Queue<Consulta> getEnEspera() {
        return enEsperaT;
    }

    /**
     * Este método se utiliza para espejar las filas de la cola enEsperaT en la
     * lista EnEsperaPersis. Primero, convierte la cola enEsperaT en una lista.
     * Luego, asigna esta lista a EnEsperaPersis.
     */
    public void espejarFilas() {
        Queue<Consulta> cola = this.enEsperaT;
        List<Consulta> lista = new ArrayList<>(cola);
        this.EnEsperaPersis = lista;
    }
}
