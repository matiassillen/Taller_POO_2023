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
import Model.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public UsuarioJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getRol() == null) {
            usuario.setRol(new ArrayList<Rol>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FuncionarioGeneral funcionarioGeneral = usuario.getFuncionarioGeneral();
            if (funcionarioGeneral != null) {
                funcionarioGeneral = em.getReference(funcionarioGeneral.getClass(), funcionarioGeneral.getId());
                usuario.setFuncionarioGeneral(funcionarioGeneral);
            }
            List<Rol> attachedRol = new ArrayList<Rol>();
            for (Rol rolRolToAttach : usuario.getRol()) {
                rolRolToAttach = em.getReference(rolRolToAttach.getClass(), rolRolToAttach.getId_rol());
                attachedRol.add(rolRolToAttach);
            }
            usuario.setRol(attachedRol);
            em.persist(usuario);
            if (funcionarioGeneral != null) {
                Usuario oldUsuOfFuncionarioGeneral = funcionarioGeneral.getUsu();
                if (oldUsuOfFuncionarioGeneral != null) {
                    oldUsuOfFuncionarioGeneral.setFuncionarioGeneral(null);
                    oldUsuOfFuncionarioGeneral = em.merge(oldUsuOfFuncionarioGeneral);
                }
                funcionarioGeneral.setUsu(usuario);
                funcionarioGeneral = em.merge(funcionarioGeneral);
            }
            for (Rol rolRol : usuario.getRol()) {
                rolRol.getUsuario().add(usuario);
                rolRol = em.merge(rolRol);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getId());
            FuncionarioGeneral funcionarioGeneralOld = persistentUsuario.getFuncionarioGeneral();
            FuncionarioGeneral funcionarioGeneralNew = usuario.getFuncionarioGeneral();
            List<Rol> rolOld = persistentUsuario.getRol();
            List<Rol> rolNew = usuario.getRol();
            if (funcionarioGeneralNew != null) {
                funcionarioGeneralNew = em.getReference(funcionarioGeneralNew.getClass(), funcionarioGeneralNew.getId());
                usuario.setFuncionarioGeneral(funcionarioGeneralNew);
            }
            List<Rol> attachedRolNew = new ArrayList<Rol>();
            for (Rol rolNewRolToAttach : rolNew) {
                rolNewRolToAttach = em.getReference(rolNewRolToAttach.getClass(), rolNewRolToAttach.getId_rol());
                attachedRolNew.add(rolNewRolToAttach);
            }
            rolNew = attachedRolNew;
            usuario.setRol(rolNew);
            usuario = em.merge(usuario);
            if (funcionarioGeneralOld != null && !funcionarioGeneralOld.equals(funcionarioGeneralNew)) {
                funcionarioGeneralOld.setUsu(null);
                funcionarioGeneralOld = em.merge(funcionarioGeneralOld);
            }
            if (funcionarioGeneralNew != null && !funcionarioGeneralNew.equals(funcionarioGeneralOld)) {
                Usuario oldUsuOfFuncionarioGeneral = funcionarioGeneralNew.getUsu();
                if (oldUsuOfFuncionarioGeneral != null) {
                    oldUsuOfFuncionarioGeneral.setFuncionarioGeneral(null);
                    oldUsuOfFuncionarioGeneral = em.merge(oldUsuOfFuncionarioGeneral);
                }
                funcionarioGeneralNew.setUsu(usuario);
                funcionarioGeneralNew = em.merge(funcionarioGeneralNew);
            }
            for (Rol rolOldRol : rolOld) {
                if (!rolNew.contains(rolOldRol)) {
                    rolOldRol.getUsuario().remove(usuario);
                    rolOldRol = em.merge(rolOldRol);
                }
            }
            for (Rol rolNewRol : rolNew) {
                if (!rolOld.contains(rolNewRol)) {
                    rolNewRol.getUsuario().add(usuario);
                    rolNewRol = em.merge(rolNewRol);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = usuario.getId();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            FuncionarioGeneral funcionarioGeneral = usuario.getFuncionarioGeneral();
            if (funcionarioGeneral != null) {
                funcionarioGeneral.setUsu(null);
                funcionarioGeneral = em.merge(funcionarioGeneral);
            }
            List<Rol> rol = usuario.getRol();
            for (Rol rolRol : rol) {
                rolRol.getUsuario().remove(usuario);
                rolRol = em.merge(rolRol);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
