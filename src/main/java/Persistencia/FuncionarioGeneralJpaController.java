/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.FuncionarioGeneral;
<<<<<<< HEAD
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
=======
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Rol;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author trapo
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
 */
public class FuncionarioGeneralJpaController implements Serializable {

    public FuncionarioGeneralJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
<<<<<<< HEAD
=======
    private EntityManagerFactory emf = null;
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
    
    public FuncionarioGeneralJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
<<<<<<< HEAD
    
    private EntityManagerFactory emf = null;
=======
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FuncionarioGeneral funcionarioGeneral) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
<<<<<<< HEAD
            em.persist(funcionarioGeneral);
=======
            Rol rol = funcionarioGeneral.getRol();
            if (rol != null) {
                rol = em.getReference(rol.getClass(), rol.getId_rol());
                funcionarioGeneral.setRol(rol);
            }
            em.persist(funcionarioGeneral);
            if (rol != null) {
                rol.getFuncionarioGeneral().add(funcionarioGeneral);
                rol = em.merge(rol);
            }
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
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
<<<<<<< HEAD
            funcionarioGeneral = em.merge(funcionarioGeneral);
=======
            FuncionarioGeneral persistentFuncionarioGeneral = em.find(FuncionarioGeneral.class, funcionarioGeneral.getId());
            Rol rolOld = persistentFuncionarioGeneral.getRol();
            Rol rolNew = funcionarioGeneral.getRol();
            if (rolNew != null) {
                rolNew = em.getReference(rolNew.getClass(), rolNew.getId_rol());
                funcionarioGeneral.setRol(rolNew);
            }
            funcionarioGeneral = em.merge(funcionarioGeneral);
            if (rolOld != null && !rolOld.equals(rolNew)) {
                rolOld.getFuncionarioGeneral().remove(funcionarioGeneral);
                rolOld = em.merge(rolOld);
            }
            if (rolNew != null && !rolNew.equals(rolOld)) {
                rolNew.getFuncionarioGeneral().add(funcionarioGeneral);
                rolNew = em.merge(rolNew);
            }
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
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
<<<<<<< HEAD
=======
            Rol rol = funcionarioGeneral.getRol();
            if (rol != null) {
                rol.getFuncionarioGeneral().remove(funcionarioGeneral);
                rol = em.merge(rol);
            }
>>>>>>> f1b2a889c99d5a30cb19cdc03a672a061b0e52e6
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
