package Model;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase EsperaTriage que gestiona la cola de espera de las consultas para el
 * triage.
 *
 * @author yairc
 */
public class EsperaTriage {

    // Cola para las consultas en espera de triage
    private Queue<Consulta> enEsperaT;

    /**
     * Constructor de la clase EsperaTriage.
     */
    public EsperaTriage() {
        this.enEsperaT = new LinkedList<>();
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
        return consu;
    }

    /**
     * Método para añadir una consulta a la fila de espera de triage.
     *
     * @param consu La consulta a añadir a la fila.
     */
    public void AñadirALaFila(Consulta consu) {
        enEsperaT.add(consu);
    }

    /**
     * Getter para obtener las consultas en espera de triage.
     *
     * @return La cola de las consultas en espera de triage.
     */
    public Queue<Consulta> getEnEspera() {
        return enEsperaT;
    }
}
