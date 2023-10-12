/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.AntecedenteClinico;
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
public class AntecedenteClinicoJpaController implements Serializable {

    public AntecedenteClinicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public AntecedenteClinicoJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AntecedenteClinico antecedenteClinico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(antecedenteClinico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AntecedenteClinico antecedenteClinico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            antecedenteClinico = em.merge(antecedenteClinico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = antecedenteClinico.getNumAntecedente();
                if (findAntecedenteClinico(id) == null) {
                    throw new NonexistentEntityException("The antecedenteClinico with id " + id + " no longer exists.");
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
            AntecedenteClinico antecedenteClinico;
            try {
                antecedenteClinico = em.getReference(AntecedenteClinico.class, id);
                antecedenteClinico.getNumAntecedente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The antecedenteClinico with id " + id + " no longer exists.", enfe);
            }
            em.remove(antecedenteClinico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AntecedenteClinico> findAntecedenteClinicoEntities() {
        return findAntecedenteClinicoEntities(true, -1, -1);
    }

    public List<AntecedenteClinico> findAntecedenteClinicoEntities(int maxResults, int firstResult) {
        return findAntecedenteClinicoEntities(false, maxResults, firstResult);
    }

    private List<AntecedenteClinico> findAntecedenteClinicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AntecedenteClinico.class));
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

    public AntecedenteClinico findAntecedenteClinico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AntecedenteClinico.class, id);
        } finally {
            em.close();
        }
    }

    public int getAntecedenteClinicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AntecedenteClinico> rt = cq.from(AntecedenteClinico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
