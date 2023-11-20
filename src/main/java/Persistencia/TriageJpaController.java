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
import Model.Consulta;
import Model.Triage;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * La clase `TriageJpaController` se encarga de controlar la persistencia de los
 * Triages en la base de datos. Proporciona métodos para crear, editar, eliminar
 * y recuperar Triages.
 */
public class TriageJpaController implements Serializable {

    /**
     * Constructor de la clase TriageJpaController con un EntityManagerFactory
     * proporcionado.
     *
     * @param emf El EntityManagerFactory utilizado para interactuar con la base
     * de datos.
     */
    public TriageJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Constructor de la clase TriageJpaController que crea un
     * EntityManagerFactory interno.
     */
    public TriageJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }

    private EntityManagerFactory emf = null;

    /**
     * Obtiene un EntityManager para interactuar con la base de datos.
     *
     * @return Un EntityManager.
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Crea un nuevo registro de triaje en la base de datos.
     *
     * @param triage El registro de triaje que se va a crear.
     */
    public void create(Triage triage) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consulta consulta = triage.getConsulta();
            if (consulta != null) {
                consulta = em.getReference(consulta.getClass(), consulta.getId());
                triage.setConsulta(consulta);
            }
            em.persist(triage);
            if (consulta != null) {
                Triage oldTriageOfConsulta = consulta.getTriage();
                if (oldTriageOfConsulta != null) {
                    oldTriageOfConsulta.setConsulta(null);
                    oldTriageOfConsulta = em.merge(oldTriageOfConsulta);
                }
                consulta.setTriage(triage);
                consulta = em.merge(consulta);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Edita un registro de triaje existente en la base de datos.
     *
     * @param triage El registro de triaje que se va a editar.
     * @throws NonexistentEntityException Si el registro de triaje no existe en
     * la base de datos.
     * @throws Exception Si se produce un error durante la edición.
     */
    public void edit(Triage triage) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Triage persistentTriage = em.find(Triage.class, triage.getId());
            Consulta consultaOld = persistentTriage.getConsulta();
            Consulta consultaNew = triage.getConsulta();
            if (consultaNew != null) {
                consultaNew = em.getReference(consultaNew.getClass(), consultaNew.getId());
                triage.setConsulta(consultaNew);
            }
            triage = em.merge(triage);
            if (consultaOld != null && !consultaOld.equals(consultaNew)) {
                consultaOld.setTriage(null);
                consultaOld = em.merge(consultaOld);
            }
            if (consultaNew != null && !consultaNew.equals(consultaOld)) {
                Triage oldTriageOfConsulta = consultaNew.getTriage();
                if (oldTriageOfConsulta != null) {
                    oldTriageOfConsulta.setConsulta(null);
                    oldTriageOfConsulta = em.merge(oldTriageOfConsulta);
                }
                consultaNew.setTriage(triage);
                consultaNew = em.merge(consultaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = triage.getId();
                if (findTriage(id) == null) {
                    throw new NonexistentEntityException("The triage with id " + id + " no longer exists.");
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
     * Elimina un registro de triaje de la base de datos por su ID.
     *
     * @param id El ID del registro de triaje que se va a eliminar.
     * @throws NonexistentEntityException Si el registro de triaje no existe en
     * la base de datos.
     */
    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Triage triage;
            try {
                triage = em.getReference(Triage.class, id);
                triage.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The triage with id " + id + " no longer exists.", enfe);
            }
            Consulta consulta = triage.getConsulta();
            if (consulta != null) {
                consulta.setTriage(null);
                consulta = em.merge(consulta);
            }
            em.remove(triage);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Obtiene una lista de registros de triaje desde la base de datos.
     *
     * @return Una lista de registros de triaje.
     */
    public List<Triage> findTriageEntities() {
        return findTriageEntities(true, -1, -1);
    }

    /**
     * Obtiene una lista de registros de triaje con opciones de paginación.
     *
     * @param maxResults El número máximo de resultados a obtener.
     * @param firstResult El índice del primer resultado a obtener.
     * @return Una lista de registros de triaje con opciones de paginación.
     */
    public List<Triage> findTriageEntities(int maxResults, int firstResult) {
        return findTriageEntities(false, maxResults, firstResult);
    }

    private List<Triage> findTriageEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Triage.class));
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
     * Busca y devuelve un registro de triaje por su ID en la base de datos.
     *
     * @param id El ID del registro de triaje que se desea buscar.
     * @return El registro de triaje con el ID especificado.
     */
    public Triage findTriage(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Triage.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene el número total de registros de triaje en la base de datos.
     *
     * @return El número total de registros de triaje.
     */
    public int getTriageCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Triage> rt = cq.from(Triage.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
