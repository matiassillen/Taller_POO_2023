/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Paciente;
import Model.ResultadoEstudio;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * La clase `ResultadoEstudioJpaController` se encarga de controlar la
 * persistencia de los Resultados de estudio en la base de datos. Proporciona
 * métodos para crear, editar, eliminar y recuperar Resultados de estudio.
 */
public class ResultadoEstudioJpaController implements Serializable {

    /**
     * Constructor de la clase que permite asignar una instancia de
     * EntityManagerFactory al controlador de resultados de estudios.
     *
     * @param emf La fábrica de EntityManagers que se utilizará para gestionar
     * entidades.
     */
    public ResultadoEstudioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Constructor de la clase que crea una instancia de EntityManagerFactory
     * con un nombre específico ("TallerPooPU").
     */
    public ResultadoEstudioJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }

    private EntityManagerFactory emf = null;

    /**
     * Obtiene una instancia de EntityManager del EntityManagerFactory asociado
     * al controlador.
     *
     * @return Una instancia de EntityManager para gestionar entidades.
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Crea un nuevo resultado de estudio en la base de datos y establece la
     * relación con el paciente correspondiente.
     *
     * @param resultadoEstudio El resultado de estudio que se va a crear.
     */
    public void create(ResultadoEstudio resultadoEstudio) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente paciente = resultadoEstudio.getPaciente();
            if (paciente != null) {
                paciente = em.getReference(paciente.getClass(), paciente.getId());
                resultadoEstudio.setPaciente(paciente);
            }
            em.persist(resultadoEstudio);
            if (paciente != null) {
                paciente.getResultadoEstudio().add(resultadoEstudio);
                paciente = em.merge(paciente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Crea un nuevo resultado de estudio en la base de datos y establece la
     * relación con el paciente correspondiente.
     *
     * @param resultadoEstudio El resultado de estudio que se va a crear.
     */
    public void edit(ResultadoEstudio resultadoEstudio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ResultadoEstudio persistentResultadoEstudio = em.find(ResultadoEstudio.class, resultadoEstudio.getId());
            Paciente pacienteOld = persistentResultadoEstudio.getPaciente();
            Paciente pacienteNew = resultadoEstudio.getPaciente();
            if (pacienteNew != null) {
                pacienteNew = em.getReference(pacienteNew.getClass(), pacienteNew.getId());
                resultadoEstudio.setPaciente(pacienteNew);
            }
            resultadoEstudio = em.merge(resultadoEstudio);
            if (pacienteOld != null && !pacienteOld.equals(pacienteNew)) {
                pacienteOld.getResultadoEstudio().remove(resultadoEstudio);
                pacienteOld = em.merge(pacienteOld);
            }
            if (pacienteNew != null && !pacienteNew.equals(pacienteOld)) {
                pacienteNew.getResultadoEstudio().add(resultadoEstudio);
                pacienteNew = em.merge(pacienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = resultadoEstudio.getId();
                if (findResultadoEstudio(id) == null) {
                    throw new NonexistentEntityException("The resultadoEstudio with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Elimina un resultado de estudio de la base de datos y actualiza la
     * relación con el paciente.
     *
     * @param id El ID del resultado de estudio que se va a eliminar.
     * @throws NonexistentEntityException Si el resultado de estudio no existe
     * en la base de datos.
     */
    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ResultadoEstudio resultadoEstudio;
            try {
                resultadoEstudio = em.getReference(ResultadoEstudio.class, id);
                resultadoEstudio.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The resultadoEstudio with id " + id + " no longer exists.", enfe);
            }
            Paciente paciente = resultadoEstudio.getPaciente();
            if (paciente != null) {
                paciente.getResultadoEstudio().remove(resultadoEstudio);
                paciente = em.merge(paciente);
            }
            em.remove(resultadoEstudio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Elimina un resultado de estudio de la base de datos y actualiza la
     * relación con el paciente.
     */
    public List<ResultadoEstudio> findResultadoEstudioEntities() {
        return findResultadoEstudioEntities(true, -1, -1);
    }

    public List<ResultadoEstudio> findResultadoEstudioEntities(int maxResults, int firstResult) {
        return findResultadoEstudioEntities(false, maxResults, firstResult);
    }

    /**
     * Obtiene una lista de resultados de estudio con opciones de paginación.
     *
     * @param maxResults El número máximo de resultados a obtener.
     * @param firstResult El índice del primer resultado a obtener.
     * @return Una lista de resultados de estudio con paginación.
     */
    private List<ResultadoEstudio> findResultadoEstudioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ResultadoEstudio.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Busca un resultado de estudio por su ID en la base de datos.
     *
     * @param id El ID del resultado de estudio que se busca.
     * @return El resultado de estudio encontrado o null si no se encuentra.
     */
    public ResultadoEstudio findResultadoEstudio(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ResultadoEstudio.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene el número total de resultados de estudio en la base de datos.
     *
     * @return El número total de resultados de estudio.
     */
    public int getResultadoEstudioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ResultadoEstudio> rt = cq.from(ResultadoEstudio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
