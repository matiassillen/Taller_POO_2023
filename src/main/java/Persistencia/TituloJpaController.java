/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.Titulo;
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
public class TituloJpaController implements Serializable {

    public TituloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public TituloJpaController(){
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Titulo titulo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(titulo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Titulo titulo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            titulo = em.merge(titulo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = titulo.getIdTitulo();
                if (findTitulo(id) == null) {
                    throw new NonexistentEntityException("The titulo with id " + id + " no longer exists.");
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
            Titulo titulo;
            try {
                titulo = em.getReference(Titulo.class, id);
                titulo.getIdTitulo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The titulo with id " + id + " no longer exists.", enfe);
            }
            em.remove(titulo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Titulo> findTituloEntities() {
        return findTituloEntities(true, -1, -1);
    }

    public List<Titulo> findTituloEntities(int maxResults, int firstResult) {
        return findTituloEntities(false, maxResults, firstResult);
    }

    private List<Titulo> findTituloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Titulo.class));
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

    public Titulo findTitulo(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Titulo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTituloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Titulo> rt = cq.from(Titulo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
