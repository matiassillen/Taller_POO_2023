/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.Recepcionista;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class RecepcionistaJpaController implements Serializable {

    public RecepcionistaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public RecepcionistaJpaController(){
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Recepcionista recepcionista) {
        if (recepcionista.getRol() == null) {
            recepcionista.setRol(new ArrayList<Rol>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Rol> attachedRol = new ArrayList<Rol>();
            for (Rol rolRolToAttach : recepcionista.getRol()) {
                rolRolToAttach = em.getReference(rolRolToAttach.getClass(), rolRolToAttach.getId_rol());
                attachedRol.add(rolRolToAttach);
            }
            recepcionista.setRol(attachedRol);
            em.persist(recepcionista);
            for (Rol rolRol : recepcionista.getRol()) {
                rolRol.getFuncionarioGeneral().add(recepcionista);
                rolRol = em.merge(rolRol);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Recepcionista recepcionista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Recepcionista persistentRecepcionista = em.find(Recepcionista.class, recepcionista.getId());
            ArrayList<Rol> rolOld = persistentRecepcionista.getRol();
            ArrayList<Rol> rolNew = recepcionista.getRol();
            ArrayList<Rol> attachedRolNew = new ArrayList<Rol>();
            for (Rol rolNewRolToAttach : rolNew) {
                rolNewRolToAttach = em.getReference(rolNewRolToAttach.getClass(), rolNewRolToAttach.getId_rol());
                attachedRolNew.add(rolNewRolToAttach);
            }
            rolNew = attachedRolNew;
            recepcionista.setRol(rolNew);
            recepcionista = em.merge(recepcionista);
            for (Rol rolOldRol : rolOld) {
                if (!rolNew.contains(rolOldRol)) {
                    rolOldRol.getFuncionarioGeneral().remove(recepcionista);
                    rolOldRol = em.merge(rolOldRol);
                }
            }
            for (Rol rolNewRol : rolNew) {
                if (!rolOld.contains(rolNewRol)) {
                    rolNewRol.getFuncionarioGeneral().add(recepcionista);
                    rolNewRol = em.merge(rolNewRol);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = recepcionista.getId();
                if (findRecepcionista(id) == null) {
                    throw new NonexistentEntityException("The recepcionista with id " + id + " no longer exists.");
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
            Recepcionista recepcionista;
            try {
                recepcionista = em.getReference(Recepcionista.class, id);
                recepcionista.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The recepcionista with id " + id + " no longer exists.", enfe);
            }
            ArrayList<Rol> rol = recepcionista.getRol();
            for (Rol rolRol : rol) {
                rolRol.getFuncionarioGeneral().remove(recepcionista);
                rolRol = em.merge(rolRol);
            }
            em.remove(recepcionista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Recepcionista> findRecepcionistaEntities() {
        return findRecepcionistaEntities(true, -1, -1);
    }

    public List<Recepcionista> findRecepcionistaEntities(int maxResults, int firstResult) {
        return findRecepcionistaEntities(false, maxResults, firstResult);
    }

    private List<Recepcionista> findRecepcionistaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Recepcionista.class));
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

    public Recepcionista findRecepcionista(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Recepcionista.class, id);
        } finally {
            em.close();
        }
    }

    public int getRecepcionistaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Recepcionista> rt = cq.from(Recepcionista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
