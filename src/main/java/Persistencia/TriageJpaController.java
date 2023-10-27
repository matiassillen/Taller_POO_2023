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
 * @author Matías Sillen Ríos
 */
public class TriageJpaController implements Serializable {

    public TriageJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public TriageJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

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

    public List<Triage> findTriageEntities() {
        return findTriageEntities(true, -1, -1);
    }

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

    public Triage findTriage(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Triage.class, id);
        } finally {
            em.close();
        }
    }

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
