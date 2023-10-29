package Model;

import java.util.Queue;

/**
 * La clase EsperaTriage representa una cola de consultas en espera de triage.
 */
public class EsperaTriage {
    // Cola para las consultas en espera de triage
    private Queue<Consulta> enEsperaT;

    /**
     * Constructor para la clase EsperaTriage.
     *
     * @param fila La cola de consultas en espera de triage.
     */
    public EsperaTriage(Queue<Consulta> fila) {
        this.enEsperaT = fila;
    }

    /**
     * Método para obtener la cola de consultas en espera de triage.
     *
     * @return La cola de consultas en espera de triage.
     */
    public Queue<Consulta> getEnEspera() {
        return enEsperaT;
    }

    /**
     * Método para añadir una consulta a la cola de espera de triage.
     *
     * @param consu La consulta a añadir a la cola.
     */
    public void AñadirALaFila(Consulta consu) {
        enEsperaT.add(consu);
    }

    /**
     * Método para quitar una consulta de la cola de espera de triage y asignarle un triage.
     *
     * @param t El triage a asignar a la consulta.
     * @return La consulta que ha sido quitada de la cola y a la que se le ha asignado el triage.
     */
    public Consulta QuitarDeFila(Triage t) {
        Consulta consu = this.enEsperaT.poll();
        consu.setTriage(t);
        return consu;
    }

    /**
     * Método para quitar una consulta específica de la cola de espera de triage.
     *
     * @param consu La consulta a quitar de la cola.
     */
    void quitarDeLista(Consulta consu) {
//        this.enEsperaT.remove(consu);
    }
}