package Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


/**
 * Clase EsperaAtencion que gestiona la cola de espera de las consultas.
 *
 * @author yairc
 */

public class EsperaAtencion {


    // Cola de prioridad para las consultas en espera
    private PriorityQueue<Consulta> enEspera;
    private List<Consulta> EnEsperaPersis;

    /**
     * Constructor de la clase EsperaAtencion.
     */
    public EsperaAtencion(PriorityQueue<Consulta> fila) {
        this.enEspera = fila;
    }

    /**
     * Método para quitar una consulta de la fila de espera.
     *
     * @param box El box asignado a la consulta.
     * @param medico El médico asignado a la consulta.
     * @return Una lista de objetos que incluye la consulta, el box y el médico.
     */
    public Consulta quitarDeFila() { 
        return enEspera.poll();

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
