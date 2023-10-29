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
 * @author Matías Sillen Ríos
 */
public class RolJpaController implements Serializable {

    /**
     * Constructor de la clase que permite asignar una instancia de
     * EntityManagerFactory al controlador de roles.
     *
     * @param emf La fábrica de EntityManagers que se utilizará para gestionar
     * entidades.
     */
    public RolJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Constructor de la clase que crea una instancia de EntityManagerFactory
     * con un nombre específico ("TallerPooPU").
     */
    public RolJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }

    private EntityManagerFactory emf = null;

    /**
     * Obtiene una instancia de EntityManager del EntityManagerFactory asociado
     * al controlador.
     *
     * @return Una instancia de EntityManager para gestionar entidades.
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Crea un nuevo rol en la base de datos y establece la relación con los
     * usuarios correspondientes.
     *
     * @param rol El rol que se va a crear.
     */
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

    /**
     * Edita un rol existente en la base de datos y actualiza la relación con
     * los usuarios.
     *
     * @param rol El rol que se va a editar.
     * @throws NonexistentEntityException Si el rol no existe en la base de
     * datos.
     * @throws Exception Si ocurre un error durante la edición.
     */
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

    /**
     * Elimina un rol de la base de datos y actualiza la relación con los
     * usuarios.
     *
     * @param id El ID del rol que se va a eliminar.
     * @throws NonexistentEntityException Si el rol no existe en la base de
     * datos.
     */
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

    /**
     * Obtiene una lista de todos los roles en la base de datos.
     *
     * @return Una lista de roles.
     */
    public List<Rol> findRolEntities() {
        return findRolEntities(true, -1, -1);
    }

    /**
     * Obtiene una lista de roles con opciones de paginación.
     *
     * @param maxResults El número máximo de resultados a obtener.
     * @param firstResult El índice del primer resultado a obtener.
     * @return Una lista de roles con paginación.
     */
    public List<Rol> findRolEntities(int maxResults, int firstResult) {
        return findRolEntities(false, maxResults, firstResult);
    }

    /**
     * Obtiene una lista de roles con opciones de paginación.
     *
     * @param all Indica si se deben obtener todos los roles o no.
     * @param maxResults El número máximo de resultados a obtener.
     * @param firstResult El índice del primer resultado a obtener.
     * @return Una lista de roles con opciones de paginación.
     */
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

    /**
     * Busca y devuelve un rol por su ID en la base de datos.
     *
     * @param id El ID del rol que se desea buscar.
     * @return El rol con el ID especificado.
     */
    public Rol findRol(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rol.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Busca y devuelve un rol por su ID en la base de datos.
     *
     * @param id El ID del rol que se desea buscar.
     * @return El rol con el ID especificado.
     */
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
