/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.ResultadoEstudio;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Matías Sillen Ríos
 */
public class ResultadoEstudioJpaController implements Serializable {

    public ResultadoEstudioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public ResultadoEstudioJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ResultadoEstudio resultadoEstudio) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(resultadoEstudio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ResultadoEstudio resultadoEstudio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            resultadoEstudio = em.merge(resultadoEstudio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = resultadoEstudio.getNumResEst();
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

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ResultadoEstudio resultadoEstudio;
            try {
                resultadoEstudio = em.getReference(ResultadoEstudio.class, id);
                resultadoEstudio.getNumResEst();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The resultadoEstudio with id " + id + " no longer exists.", enfe);
            }
            em.remove(resultadoEstudio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ResultadoEstudio> findResultadoEstudioEntities() {
        return findResultadoEstudioEntities(true, -1, -1);
    }

    public List<ResultadoEstudio> findResultadoEstudioEntities(int maxResults, int firstResult) {
        return findResultadoEstudioEntities(false, maxResults, firstResult);
    }

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

    public ResultadoEstudio findResultadoEstudio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ResultadoEstudio.class, id);
        } finally {
            em.close();
        }
    }

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
