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
import Model.FuncionarioGeneral;
import Model.Rol;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Matías Sillen Ríos
 */
public class RolJpaController implements Serializable {

    public RolJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public RolJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }

    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rol rol) {
        if (rol.getFuncionarioGeneral() == null) {
            rol.setFuncionarioGeneral(new ArrayList<FuncionarioGeneral>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<FuncionarioGeneral> attachedFuncionarioGeneral = new ArrayList<FuncionarioGeneral>();
            for (FuncionarioGeneral funcionarioGeneralFuncionarioGeneralToAttach : rol.getFuncionarioGeneral()) {
                funcionarioGeneralFuncionarioGeneralToAttach = em.getReference(funcionarioGeneralFuncionarioGeneralToAttach.getClass(), funcionarioGeneralFuncionarioGeneralToAttach.getId());
                attachedFuncionarioGeneral.add(funcionarioGeneralFuncionarioGeneralToAttach);
            }
            rol.setFuncionarioGeneral(attachedFuncionarioGeneral);
            em.persist(rol);
            for (FuncionarioGeneral funcionarioGeneralFuncionarioGeneral : rol.getFuncionarioGeneral()) {
                Rol oldRolOfFuncionarioGeneralFuncionarioGeneral = funcionarioGeneralFuncionarioGeneral.getRol();
                funcionarioGeneralFuncionarioGeneral.setRol(rol);
                funcionarioGeneralFuncionarioGeneral = em.merge(funcionarioGeneralFuncionarioGeneral);
                if (oldRolOfFuncionarioGeneralFuncionarioGeneral != null) {
                    oldRolOfFuncionarioGeneralFuncionarioGeneral.getFuncionarioGeneral().remove(funcionarioGeneralFuncionarioGeneral);
                    oldRolOfFuncionarioGeneralFuncionarioGeneral = em.merge(oldRolOfFuncionarioGeneralFuncionarioGeneral);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rol rol) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol persistentRol = em.find(Rol.class, rol.getId_rol());
            ArrayList<FuncionarioGeneral> funcionarioGeneralOld = persistentRol.getFuncionarioGeneral();
            ArrayList<FuncionarioGeneral> funcionarioGeneralNew = rol.getFuncionarioGeneral();
            ArrayList<FuncionarioGeneral> attachedFuncionarioGeneralNew = new ArrayList<FuncionarioGeneral>();
            for (FuncionarioGeneral funcionarioGeneralNewFuncionarioGeneralToAttach : funcionarioGeneralNew) {
                funcionarioGeneralNewFuncionarioGeneralToAttach = em.getReference(funcionarioGeneralNewFuncionarioGeneralToAttach.getClass(), funcionarioGeneralNewFuncionarioGeneralToAttach.getId());
                attachedFuncionarioGeneralNew.add(funcionarioGeneralNewFuncionarioGeneralToAttach);
            }
            funcionarioGeneralNew = attachedFuncionarioGeneralNew;
            rol.setFuncionarioGeneral(funcionarioGeneralNew);
            rol = em.merge(rol);
            for (FuncionarioGeneral funcionarioGeneralOldFuncionarioGeneral : funcionarioGeneralOld) {
                if (!funcionarioGeneralNew.contains(funcionarioGeneralOldFuncionarioGeneral)) {
                    funcionarioGeneralOldFuncionarioGeneral.setRol(null);
                    funcionarioGeneralOldFuncionarioGeneral = em.merge(funcionarioGeneralOldFuncionarioGeneral);
                }
            }
            for (FuncionarioGeneral funcionarioGeneralNewFuncionarioGeneral : funcionarioGeneralNew) {
                if (!funcionarioGeneralOld.contains(funcionarioGeneralNewFuncionarioGeneral)) {
                    Rol oldRolOfFuncionarioGeneralNewFuncionarioGeneral = funcionarioGeneralNewFuncionarioGeneral.getRol();
                    funcionarioGeneralNewFuncionarioGeneral.setRol(rol);
                    funcionarioGeneralNewFuncionarioGeneral = em.merge(funcionarioGeneralNewFuncionarioGeneral);
                    if (oldRolOfFuncionarioGeneralNewFuncionarioGeneral != null && !oldRolOfFuncionarioGeneralNewFuncionarioGeneral.equals(rol)) {
                        oldRolOfFuncionarioGeneralNewFuncionarioGeneral.getFuncionarioGeneral().remove(funcionarioGeneralNewFuncionarioGeneral);
                        oldRolOfFuncionarioGeneralNewFuncionarioGeneral = em.merge(oldRolOfFuncionarioGeneralNewFuncionarioGeneral);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = rol.getId_rol();
                if (findRol(id) == null) {
                    throw new NonexistentEntityException("The rol with id " + id + " no longer exists.");
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
            Rol rol;
            try {
                rol = em.getReference(Rol.class, id);
                rol.getId_rol();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rol with id " + id + " no longer exists.", enfe);
            }
            ArrayList<FuncionarioGeneral> funcionarioGeneral = rol.getFuncionarioGeneral();
            for (FuncionarioGeneral funcionarioGeneralFuncionarioGeneral : funcionarioGeneral) {
                funcionarioGeneralFuncionarioGeneral.setRol(null);
                funcionarioGeneralFuncionarioGeneral = em.merge(funcionarioGeneralFuncionarioGeneral);
            }
            em.remove(rol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rol> findRolEntities() {
        return findRolEntities(true, -1, -1);
    }

    public List<Rol> findRolEntities(int maxResults, int firstResult) {
        return findRolEntities(false, maxResults, firstResult);
    }

    private List<Rol> findRolEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rol.class));
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

    public Rol findRol(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rol.class, id);
        } finally {
            em.close();
        }
    }

    public int getRolCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rol> rt = cq.from(Rol.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
