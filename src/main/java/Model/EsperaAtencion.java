package Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Clase EsperaAtencion que gestiona la cola de espera de las consultas.
 *
 * @author yairc
 */
@Entity
public class EsperaAtencion {

    @Transient
    // Cola de prioridad para las consultas en espera
    private PriorityQueue<Consulta> enEspera;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private List<Consulta> EnEsperaPersis;

    /**
     * Constructor de la clase EsperaAtencion.
     */
    public EsperaAtencion() {
        this.enEspera = new PriorityQueue<>(new ComparadorDeConsultas());
        this.EnEsperaPersis = new LinkedList<>();
    }

    /**
     * Método para quitar una consulta de la fila de espera.
     *
     * @param box El box asignado a la consulta.
     * @param medico El médico asignado a la consulta.
     * @return Una lista de objetos que incluye la consulta, el box y el médico.
     */
    public List<Object> quitarDeFila(Box box, Medico medico) {
        List<Object> objetos = new ArrayList<>();
        Consulta consu = enEspera.poll();

        consu.setBox(box);
        consu.setMedico(medico);
        objetos.add(consu);

        box.setConsulta(consu);
        objetos.add(box);

        List<Consulta> consultas = medico.getConsulta();
        consultas.add(consu);
        medico.setConsulta(consultas);
        objetos.add(medico);

        this.espejarFilas();

        return objetos;
    }

    /**
     * Getter para obtener las consultas en espera.
     *
     * @return La cola de prioridad de las consultas en espera.
     */
    public PriorityQueue<Consulta> getEnEspera() {
        return enEspera;
    }

    /**
     * Método para añadir una consulta a la fila de espera.
     *
     * @param consu La consulta a añadir a la fila.
     */
    public void añadirAFila(Consulta consu) {
        enEspera.add(consu);
        this.espejarFilas();
    }

    /**
     * Este método se utiliza para obtener la lista de consultas en espera
     * persistente.
     *
     * @return EnEsperaPersis, que es una lista de objetos Consulta que están en
     * espera.
     */
    public List<Consulta> getEnEsperaPersis() {
        return EnEsperaPersis;
    }

    /**
     * Este método se utiliza para espejar las filas de la cola enEspera en la
     * lista EnEsperaPersis. Primero, convierte la cola enEspera en una lista.
     * Luego, asigna esta lista a EnEsperaPersis.
     */
    public void espejarFilas() {
        Queue<Consulta> cola = this.enEspera;
        List<Consulta> lista = new ArrayList<>(cola);
        this.EnEsperaPersis = lista;
    }

    /**
     * Clase interna ComparadorDeConsultas que implementa Comparator para
     * comparar consultas.
     */
    public class ComparadorDeConsultas implements Comparator<Consulta> {

        /**
         * Método para comparar dos consultas basándose en el color del triage.
         *
         * @param c1 La primera consulta a comparar.
         * @param c2 La segunda consulta a comparar.
         * @return Un entero que indica el resultado de la comparación.
         */
        @Override
        public int compare(Consulta c1, Consulta c2) {
            if (c1.getTriage().getColorFinal() != null) {
                if (c2.getTriage().getColorFinal() != null) {
                    return c1.getTriage().getColorFinal().getValorNumerico().compareTo(c2.getTriage().getColorFinal().getValorNumerico());
                } else {
                    return c1.getTriage().getColorFinal().getValorNumerico().compareTo(c2.getTriage().getColorInicial().getValorNumerico());

                }
            } else {
                if (c2.getTriage().getColorFinal() != null) {
                    return c1.getTriage().getColorInicial().getValorNumerico().compareTo(c2.getTriage().getColorFinal().getValorNumerico());
                } else {
                    return c1.getTriage().getColorInicial().getValorNumerico().compareTo(c2.getTriage().getColorInicial().getValorNumerico());
                }
            }
        }
    }
}
