/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.Rol;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author trapo
 */
public class RolJpaController implements Serializable {

    public RolJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
     public RolJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rol rol) {
        if (rol.getUsuario() == null) {
            rol.setUsuario(new ArrayList<Usuario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Usuario> attachedUsuario = new ArrayList<Usuario>();
            for (Usuario usuarioUsuarioToAttach : rol.getUsuario()) {
                usuarioUsuarioToAttach = em.getReference(usuarioUsuarioToAttach.getClass(), usuarioUsuarioToAttach.getId());
                attachedUsuario.add(usuarioUsuarioToAttach);
            }
            rol.setUsuario(attachedUsuario);
            em.persist(rol);
            for (Usuario usuarioUsuario : rol.getUsuario()) {
                usuarioUsuario.getRol().add(rol);
                usuarioUsuario = em.merge(usuarioUsuario);
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
            List<Usuario> usuarioOld = persistentRol.getUsuario();
            List<Usuario> usuarioNew = rol.getUsuario();
            List<Usuario> attachedUsuarioNew = new ArrayList<Usuario>();
            for (Usuario usuarioNewUsuarioToAttach : usuarioNew) {
                usuarioNewUsuarioToAttach = em.getReference(usuarioNewUsuarioToAttach.getClass(), usuarioNewUsuarioToAttach.getId());
                attachedUsuarioNew.add(usuarioNewUsuarioToAttach);
            }
            usuarioNew = attachedUsuarioNew;
            rol.setUsuario(usuarioNew);
            rol = em.merge(rol);
            for (Usuario usuarioOldUsuario : usuarioOld) {
                if (!usuarioNew.contains(usuarioOldUsuario)) {
                    usuarioOldUsuario.getRol().remove(rol);
                    usuarioOldUsuario = em.merge(usuarioOldUsuario);
                }
            }
            for (Usuario usuarioNewUsuario : usuarioNew) {
                if (!usuarioOld.contains(usuarioNewUsuario)) {
                    usuarioNewUsuario.getRol().add(rol);
                    usuarioNewUsuario = em.merge(usuarioNewUsuario);
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
            List<Usuario> usuario = rol.getUsuario();
            for (Usuario usuarioUsuario : usuario) {
                usuarioUsuario.getRol().remove(rol);
                usuarioUsuario = em.merge(usuarioUsuario);
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
