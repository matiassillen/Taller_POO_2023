/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.Especialidad;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Titulo;
import Model.Medico;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * La clase `EspecialidadJpaController` se encarga de controlar la persistencia de las especialidades médicas en la base de datos.
 * Proporciona métodos para crear, editar, eliminar y recuperar especialidades médicas.
 */
public class EspecialidadJpaController implements Serializable {
/**
     * Constructor de la clase que permite especificar la `EntityManagerFactory` a utilizar.
     * 
     * @param emf La `EntityManagerFactory` que se utilizará para interactuar con la base de datos.
     */
    public EspecialidadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
     /**
     * Constructor de la clase que utiliza la configuración predeterminada para la `EntityManagerFactory`.
     */
    public EspecialidadJpaController() {
        emf = Persistence.createEntityManagerFactory("TallerPooPU");
    }
    
    private EntityManagerFactory emf = null;
/**
     * Obtiene una instancia de `EntityManager` para interactuar con la base de datos.
     * 
     * @return Una instancia de `EntityManager`.
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    /**
     * Crea una nueva especialidad médica en la base de datos.
     * 
     * @param especialidad El objeto `Especialidad` que se registrará en la base de datos.
     */
    public void create(Especialidad especialidad) {
        if (especialidad.getMedico() == null) {
            especialidad.setMedico(new ArrayList<Medico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Titulo titulo = especialidad.getTitulo();
            if (titulo != null) {
                titulo = em.getReference(titulo.getClass(), titulo.getId());
                especialidad.setTitulo(titulo);
            }
            List<Medico> attachedMedico = new ArrayList<Medico>();
            for (Medico medicoMedicoToAttach : especialidad.getMedico()) {
                medicoMedicoToAttach = em.getReference(medicoMedicoToAttach.getClass(), medicoMedicoToAttach.getId());
                attachedMedico.add(medicoMedicoToAttach);
            }
            especialidad.setMedico(attachedMedico);
            em.persist(especialidad);
            if (titulo != null) {
                Especialidad oldEspecialidadOfTitulo = titulo.getEspecialidad();
                if (oldEspecialidadOfTitulo != null) {
                    oldEspecialidadOfTitulo.setTitulo(null);
                    oldEspecialidadOfTitulo = em.merge(oldEspecialidadOfTitulo);
                }
                titulo.setEspecialidad(especialidad);
                titulo = em.merge(titulo);
            }
            for (Medico medicoMedico : especialidad.getMedico()) {
                medicoMedico.getEspecialidad().add(especialidad);
                medicoMedico = em.merge(medicoMedico);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
/**
     * Edita una especialidad médica existente en la base de datos.
     * 
     * @param especialidad El objeto `Especialidad` con los cambios que se aplicarán en la base de datos.
     * @throws NonexistentEntityException Si la especialidad médica no existe en la base de datos.
     * @throws Exception Si ocurre un error durante la edición.
     */
    public void edit(Especialidad especialidad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Especialidad persistentEspecialidad = em.find(Especialidad.class, especialidad.getId());
            Titulo tituloOld = persistentEspecialidad.getTitulo();
            Titulo tituloNew = especialidad.getTitulo();
            List<Medico> medicoOld = persistentEspecialidad.getMedico();
            List<Medico> medicoNew = especialidad.getMedico();
            if (tituloNew != null) {
                tituloNew = em.getReference(tituloNew.getClass(), tituloNew.getId());
                especialidad.setTitulo(tituloNew);
            }
            List<Medico> attachedMedicoNew = new ArrayList<Medico>();
            for (Medico medicoNewMedicoToAttach : medicoNew) {
                medicoNewMedicoToAttach = em.getReference(medicoNewMedicoToAttach.getClass(), medicoNewMedicoToAttach.getId());
                attachedMedicoNew.add(medicoNewMedicoToAttach);
            }
            medicoNew = attachedMedicoNew;
            especialidad.setMedico(medicoNew);
            especialidad = em.merge(especialidad);
            if (tituloOld != null && !tituloOld.equals(tituloNew)) {
                tituloOld.setEspecialidad(null);
                tituloOld = em.merge(tituloOld);
            }
            if (tituloNew != null && !tituloNew.equals(tituloOld)) {
                Especialidad oldEspecialidadOfTitulo = tituloNew.getEspecialidad();
                if (oldEspecialidadOfTitulo != null) {
                    oldEspecialidadOfTitulo.setTitulo(null);
                    oldEspecialidadOfTitulo = em.merge(oldEspecialidadOfTitulo);
                }
                tituloNew.setEspecialidad(especialidad);
                tituloNew = em.merge(tituloNew);
            }
            for (Medico medicoOldMedico : medicoOld) {
                if (!medicoNew.contains(medicoOldMedico)) {
                    medicoOldMedico.getEspecialidad().remove(especialidad);
                    medicoOldMedico = em.merge(medicoOldMedico);
                }
            }
            for (Medico medicoNewMedico : medicoNew) {
                if (!medicoOld.contains(medicoNewMedico)) {
                    medicoNewMedico.getEspecialidad().add(especialidad);
                    medicoNewMedico = em.merge(medicoNewMedico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = especialidad.getId();
                if (findEspecialidad(id) == null) {
                    throw new NonexistentEntityException("The especialidad with id " + id + " no longer exists.");
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
     * Elimina una especialidad médica de la base de datos por su ID.
     * 
     * @param id El ID de la especialidad médica que se eliminará de la base de datos.
     * @throws NonexistentEntityException Si la especialidad médica no existe en la base de datos.
     */
    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Especialidad especialidad;
            try {
                especialidad = em.getReference(Especialidad.class, id);
                especialidad.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The especialidad with id " + id + " no longer exists.", enfe);
            }
            Titulo titulo = especialidad.getTitulo();
            if (titulo != null) {
                titulo.setEspecialidad(null);
                titulo = em.merge(titulo);
            }
            List<Medico> medico = especialidad.getMedico();
            for (Medico medicoMedico : medico) {
                medicoMedico.getEspecialidad().remove(especialidad);
                medicoMedico = em.merge(medicoMedico);
            }
            em.remove(especialidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    /**
     * Obtiene una lista de todas las especialidades médicas registradas en la base de datos.
     * 
     * @return Lista de objetos `Especialidad`.
     */
    public List<Especialidad> findEspecialidadEntities() {
        return findEspecialidadEntities(true, -1, -1);
    }
    /**
     * Obtiene una lista de especialidades médicas registradas en la base de datos con opciones de paginación.
     * 
     * @param maxResults El número máximo de resultados a devolver.
     * @param firstResult El índice del primer resultado a devolver.
     * @return Lista de objetos `Especialidad` que cumplen con las opciones de paginación.
     */
    public List<Especialidad> findEspecialidadEntities(int maxResults, int firstResult) {
        return findEspecialidadEntities(false, maxResults, firstResult);
    }
    /**
     * Obtiene una lista de especialidades médicas registradas en la base de datos con opciones de paginación.
     * 
     * @param all Indica si se deben devolver todas las especialidades médicas sin aplicar opciones de paginación.
     * @param maxResults El número máximo de resultados a devolver.
     * @param firstResult El índice del primer resultado a devolver.
     * @return Lista de objetos `Especialidad` que cumplen con las opciones de paginación.
     */
    private List<Especialidad> findEspecialidadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Especialidad.class));
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
     * Obtiene una especialidad médica por su ID.
     * 
     * @param id El ID de la especialidad médica que se busca.
     * @return El objeto `Especialidad` encontrado o null si no existe.
     */
    public Especialidad findEspecialidad(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Especialidad.class, id);
        } finally {
            em.close();
        }
    }
    /**
     * Obtiene la cantidad de especialidades médicas registradas en la base de datos.
     * 
     * @return El número de especialidades médicas registradas.
     */
    public int getEspecialidadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Especialidad> rt = cq.from(Especialidad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
