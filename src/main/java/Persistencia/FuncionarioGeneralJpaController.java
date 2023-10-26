/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.FuncionarioGeneral;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Matías Sillen Ríos
 */
public class FuncionarioGeneralJpaController implements Serializable {

    public FuncionarioGeneralJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public FuncionarioGeneralJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FuncionarioGeneral funcionarioGeneral) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usu = funcionarioGeneral.getUsu();
            if (usu != null) {
                usu = em.getReference(usu.getClass(), usu.getId());
                funcionarioGeneral.setUsu(usu);
            }
            em.persist(funcionarioGeneral);
            if (usu != null) {
                FuncionarioGeneral oldFuncionarioGeneralOfUsu = usu.getFuncionarioGeneral();
                if (oldFuncionarioGeneralOfUsu != null) {
                    oldFuncionarioGeneralOfUsu.setUsu(null);
                    oldFuncionarioGeneralOfUsu = em.merge(oldFuncionarioGeneralOfUsu);
                }
                usu.setFuncionarioGeneral(funcionarioGeneral);
                usu = em.merge(usu);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FuncionarioGeneral funcionarioGeneral) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FuncionarioGeneral persistentFuncionarioGeneral = em.find(FuncionarioGeneral.class, funcionarioGeneral.getId());
            Usuario usuOld = persistentFuncionarioGeneral.getUsu();
            Usuario usuNew = funcionarioGeneral.getUsu();
            if (usuNew != null) {
                usuNew = em.getReference(usuNew.getClass(), usuNew.getId());
                funcionarioGeneral.setUsu(usuNew);
            }
            funcionarioGeneral = em.merge(funcionarioGeneral);
            if (usuOld != null && !usuOld.equals(usuNew)) {
                usuOld.setFuncionarioGeneral(null);
                usuOld = em.merge(usuOld);
            }
            if (usuNew != null && !usuNew.equals(usuOld)) {
                FuncionarioGeneral oldFuncionarioGeneralOfUsu = usuNew.getFuncionarioGeneral();
                if (oldFuncionarioGeneralOfUsu != null) {
                    oldFuncionarioGeneralOfUsu.setUsu(null);
                    oldFuncionarioGeneralOfUsu = em.merge(oldFuncionarioGeneralOfUsu);
                }
                usuNew.setFuncionarioGeneral(funcionarioGeneral);
                usuNew = em.merge(usuNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = funcionarioGeneral.getId();
                if (findFuncionarioGeneral(id) == null) {
                    throw new NonexistentEntityException("The funcionarioGeneral with id " + id + " no longer exists.");
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
            FuncionarioGeneral funcionarioGeneral;
            try {
                funcionarioGeneral = em.getReference(FuncionarioGeneral.class, id);
                funcionarioGeneral.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The funcionarioGeneral with id " + id + " no longer exists.", enfe);
            }
            Usuario usu = funcionarioGeneral.getUsu();
            if (usu != null) {
                usu.setFuncionarioGeneral(null);
                usu = em.merge(usu);
            }
            em.remove(funcionarioGeneral);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FuncionarioGeneral> findFuncionarioGeneralEntities() {
        return findFuncionarioGeneralEntities(true, -1, -1);
    }

    public List<FuncionarioGeneral> findFuncionarioGeneralEntities(int maxResults, int firstResult) {
        return findFuncionarioGeneralEntities(false, maxResults, firstResult);
    }

    private List<FuncionarioGeneral> findFuncionarioGeneralEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FuncionarioGeneral.class));
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

    public FuncionarioGeneral findFuncionarioGeneral(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FuncionarioGeneral.class, id);
        } finally {
            em.close();
        }
    }

    public int getFuncionarioGeneralCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FuncionarioGeneral> rt = cq.from(FuncionarioGeneral.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
