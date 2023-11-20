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

/**
 *
 * La clase `UsuarioJpaController` se encarga de controlar la persistencia de
 * los Usuarios en la base de datos. Proporciona métodos para crear, editar,
 * eliminar y recuperar Usuarios.
 */
public class UsuarioJpaController implements Serializable {

    /**
     * Constructor de la clase UsuarioJpaController con un EntityManagerFactory
     * proporcionado.
     *
     * @param emf El EntityManagerFactory utilizado para interactuar con la base
     * de datos.
     */
    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Constructor de la clase UsuarioJpaController que crea un
     * EntityManagerFactory interno.
     */
    public UsuarioJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }

    private EntityManagerFactory emf = null;

    /**
     * Obtiene un EntityManager para interactuar con la base de datos.
     *
     * @return Un EntityManager.
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Crea un nuevo registro de usuario en la base de datos.
     *
     * @param usuario El registro de usuario que se va a crear.
     */
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

    /**
     * Edita un registro de usuario existente en la base de datos.
     *
     * @param usuario El registro de usuario que se va a editar.
     * @throws NonexistentEntityException Si el registro de usuario no existe en
     * la base de datos.
     * @throws Exception Si se produce un error durante la edición.
     */
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

    /**
     * Elimina un registro de usuario de la base de datos por su ID.
     *
     * @param id El ID del registro de usuario que se va a eliminar.
     * @throws NonexistentEntityException Si el registro de usuario no existe en
     * la base de datos.
     */
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

    /**
     * Obtiene una lista de registros de usuario desde la base de datos.
     *
     * @return Una lista de registros de usuario.
     */
    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    /**
     * Obtiene una lista de registros de usuario con opciones de paginación.
     *
     * @param maxResults El número máximo de resultados a obtener.
     * @param firstResult El índice del primer resultado a obtener.
     * @return Una lista de registros de usuario con opciones de paginación.
     */
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

    /**
     * Busca y devuelve un registro de usuario por su ID en la base de datos.
     *
     * @param id El ID del registro de usuario que se desea buscar.
     * @return El registro de usuario con el ID especificado.
     */
    public Usuario findUsuario(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene el número total de registros de usuario en la base de datos.
     *
     * @return El número total de registros de usuario.
     */
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
