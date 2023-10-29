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
 * La clase `FuncionarioGeneralJpaController` se encarga de controlar la
 * persistencia de los funcionarios generales en la base de datos. Proporciona
 * métodos para crear, editar, eliminar y recuperar funcionarios generales.
 */
public class FuncionarioGeneralJpaController implements Serializable {

    /**
     * Constructor de la clase que permite especificar la `EntityManagerFactory`
     * a utilizar.
     *
     * @param emf La `EntityManagerFactory` que se utilizará para interactuar
     * con la base de datos.
     */
    public FuncionarioGeneralJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Constructor de la clase que utiliza la configuración predeterminada para
     * la `EntityManagerFactory`.
     */
    public FuncionarioGeneralJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }

    private EntityManagerFactory emf = null;

    /**
     * Obtiene una instancia de `EntityManager` para interactuar con la base de
     * datos.
     *
     * @return Una instancia de `EntityManager`.
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Crea un nuevo funcionario general en la base de datos.
     *
     * @param funcionarioGeneral El objeto `FuncionarioGeneral` que se
     * registrará en la base de datos.
     */
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

    /**
     * Edita un funcionario general existente en la base de datos.
     *
     * @param funcionarioGeneral El objeto `FuncionarioGeneral` con los cambios
     * que se aplicarán en la base de datos.
     * @throws NonexistentEntityException Si el funcionario general no existe en
     * la base de datos.
     * @throws Exception Si ocurre un error durante la edición.
     */
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

    /**
     * Elimina un funcionario general de la base de datos por su ID.
     *
     * @param id El ID del funcionario general que se eliminará de la base de
     * datos.
     * @throws NonexistentEntityException Si el funcionario general no existe en
     * la base de datos.
     */
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

    /**
     * Obtiene una lista de todos los funcionarios generales registrados en la
     * base de datos.
     *
     * @return Lista de objetos `FuncionarioGeneral`.
     */
    public List<FuncionarioGeneral> findFuncionarioGeneralEntities() {
        return findFuncionarioGeneralEntities(true, -1, -1);
    }

    /**
     * Obtiene una lista de funcionarios generales registrados en la base de
     * datos con opciones de paginación.
     *
     * @param maxResults El número máximo de resultados a devolver.
     * @param firstResult El índice del primer resultado a devolver.
     * @return Lista de objetos `FuncionarioGeneral` que cumplen con las
     * opciones de paginación.
     */
    public List<FuncionarioGeneral> findFuncionarioGeneralEntities(int maxResults, int firstResult) {
        return findFuncionarioGeneralEntities(false, maxResults, firstResult);
    }

 

    /**
     * Obtiene una lista de funcionarios generales registrados en la base de
     * datos con opciones de paginación.
     *
     * @param all Indica si se deben devolver todos los funcionarios generales
     * sin aplicar opciones de paginación.
     * @param maxResults El número máximo de resultados a devolver.
     * @param firstResult El índice del primer resultado a devolver.
     * @return Lista de objetos `FuncionarioGeneral` que cumplen con las
     * opciones de paginación.
     */
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

    /**
     * Obtiene un funcionario general por su ID.
     *
     * @param id El ID del funcionario general que se busca.
     * @return El objeto `FuncionarioGeneral` encontrado o null si no existe.
     */
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
