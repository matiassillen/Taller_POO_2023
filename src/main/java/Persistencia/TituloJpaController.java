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
import Model.Medico;
import Model.Especialidad;
import Model.Titulo;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Matías Sillen Ríos
 */
public class TituloJpaController implements Serializable {

    /**
     * Constructor de la clase TituloJpaController con un EntityManagerFactory
     * proporcionado.
     *
     * @param emf El EntityManagerFactory utilizado para interactuar con la base
     * de datos.
     */
    public TituloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Constructor de la clase TituloJpaController que crea un
     * EntityManagerFactory interno.
     */
    public TituloJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }

    /**
     * Obtiene un EntityManager para interactuar con la base de datos.
     *
     * @return Un EntityManager.
     */
    private EntityManagerFactory emf = null;

    /**
     * Crea un nuevo título en la base de datos.
     *
     * @param titulo El título que se va a crear.
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Edita un título existente en la base de datos.
     *
     * @param titulo El título que se va a editar.
     * @throws NonexistentEntityException Si el título no existe en la base de
     * datos.
     * @throws Exception Si se produce un error durante la edición.
     */
    public void create(Titulo titulo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Medico medico = titulo.getMedico();
            if (medico != null) {
                medico = em.getReference(medico.getClass(), medico.getId());
                titulo.setMedico(medico);
            }
            Especialidad especialidad = titulo.getEspecialidad();
            if (especialidad != null) {
                especialidad = em.getReference(especialidad.getClass(), especialidad.getId());
                titulo.setEspecialidad(especialidad);
            }
            em.persist(titulo);
            if (medico != null) {
                Titulo oldTituloOfMedico = medico.getTitulo();
                if (oldTituloOfMedico != null) {
                    oldTituloOfMedico.setMedico(null);
                    oldTituloOfMedico = em.merge(oldTituloOfMedico);
                }
                medico.setTitulo(titulo);
                medico = em.merge(medico);
            }
            if (especialidad != null) {
                Titulo oldTituloOfEspecialidad = especialidad.getTitulo();
                if (oldTituloOfEspecialidad != null) {
                    oldTituloOfEspecialidad.setEspecialidad(null);
                    oldTituloOfEspecialidad = em.merge(oldTituloOfEspecialidad);
                }
                especialidad.setTitulo(titulo);
                especialidad = em.merge(especialidad);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Edita un título existente en la base de datos.
     *
     * @param titulo El título que se va a editar.
     * @throws NonexistentEntityException Si el título no existe en la base de
     * datos.
     * @throws Exception Si se produce un error durante la edición.
     */
    public void edit(Titulo titulo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Titulo persistentTitulo = em.find(Titulo.class, titulo.getId());
            Medico medicoOld = persistentTitulo.getMedico();
            Medico medicoNew = titulo.getMedico();
            Especialidad especialidadOld = persistentTitulo.getEspecialidad();
            Especialidad especialidadNew = titulo.getEspecialidad();
            if (medicoNew != null) {
                medicoNew = em.getReference(medicoNew.getClass(), medicoNew.getId());
                titulo.setMedico(medicoNew);
            }
            if (especialidadNew != null) {
                especialidadNew = em.getReference(especialidadNew.getClass(), especialidadNew.getId());
                titulo.setEspecialidad(especialidadNew);
            }
            titulo = em.merge(titulo);
            if (medicoOld != null && !medicoOld.equals(medicoNew)) {
                medicoOld.setTitulo(null);
                medicoOld = em.merge(medicoOld);
            }
            if (medicoNew != null && !medicoNew.equals(medicoOld)) {
                Titulo oldTituloOfMedico = medicoNew.getTitulo();
                if (oldTituloOfMedico != null) {
                    oldTituloOfMedico.setMedico(null);
                    oldTituloOfMedico = em.merge(oldTituloOfMedico);
                }
                medicoNew.setTitulo(titulo);
                medicoNew = em.merge(medicoNew);
            }
            if (especialidadOld != null && !especialidadOld.equals(especialidadNew)) {
                especialidadOld.setTitulo(null);
                especialidadOld = em.merge(especialidadOld);
            }
            if (especialidadNew != null && !especialidadNew.equals(especialidadOld)) {
                Titulo oldTituloOfEspecialidad = especialidadNew.getTitulo();
                if (oldTituloOfEspecialidad != null) {
                    oldTituloOfEspecialidad.setEspecialidad(null);
                    oldTituloOfEspecialidad = em.merge(oldTituloOfEspecialidad);
                }
                especialidadNew.setTitulo(titulo);
                especialidadNew = em.merge(especialidadNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = titulo.getId();
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

    /**
     * Elimina un título de la base de datos por su ID.
     *
     * @param id El ID del título que se va a eliminar.
     * @throws NonexistentEntityException Si el título no existe en la base de
     * datos.
     */
    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Titulo titulo;
            try {
                titulo = em.getReference(Titulo.class, id);
                titulo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The titulo with id " + id + " no longer exists.", enfe);
            }
            Medico medico = titulo.getMedico();
            if (medico != null) {
                medico.setTitulo(null);
                medico = em.merge(medico);
            }
            Especialidad especialidad = titulo.getEspecialidad();
            if (especialidad != null) {
                especialidad.setTitulo(null);
                especialidad = em.merge(especialidad);
            }
            em.remove(titulo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Obtiene una lista de títulos desde la base de datos.
     *
     * @return Una lista de títulos.
     */
    public List<Titulo> findTituloEntities() {
        return findTituloEntities(true, -1, -1);
    }

    /**
     * Obtiene una lista de títulos con opciones de paginación.
     *
     * @param maxResults El número máximo de resultados a obtener.
     * @param firstResult El índice del primer resultado a obtener.
     * @return Una lista de títulos con opciones de paginación.
     */
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

    /**
     * Busca y devuelve un título por su ID en la base de datos.
     *
     * @param id El ID del título que se desea buscar.
     * @return El título con el ID especificado.
     */
    public Titulo findTitulo(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Titulo.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene el número total de títulos en la base de datos.
     *
     * @return El número total de títulos.
     */
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
