/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.DiagnosticoClinico;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Paciente;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * La clase `DiagnosticoClinicoJpaController` se encarga de controlar la persistencia de los diagnósticos clínicos en la base de datos.
 * Proporciona métodos para crear, editar, eliminar y recuperar diagnósticos clínicos.
 */
public class DiagnosticoClinicoJpaController implements Serializable {

    /**
     * Constructor de la clase que permite especificar la `EntityManagerFactory` a utilizar.
     * 
     * @param emf La `EntityManagerFactory` que se utilizará para interactuar con la base de datos.
     */
    public DiagnosticoClinicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    /**
     * Constructor de la clase que utiliza la configuración predeterminada para la `EntityManagerFactory`.
     */
    public DiagnosticoClinicoJpaController() {
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
     * Crea un nuevo diagnóstico clínico en la base de datos.
     * 
     * @param diagnosticoClinico El objeto `DiagnosticoClinico` que se registrará en la base de datos.
     */
    public void create(DiagnosticoClinico diagnosticoClinico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente paciente = diagnosticoClinico.getPaciente();
            if (paciente != null) {
                paciente = em.getReference(paciente.getClass(), paciente.getId());
                diagnosticoClinico.setPaciente(paciente);
            }
            em.persist(diagnosticoClinico);
            if (paciente != null) {
                paciente.getDiagnosticoClinico().add(diagnosticoClinico);
                paciente = em.merge(paciente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    /**
     * Edita un diagnóstico clínico existente en la base de datos.
     * 
     * @param diagnosticoClinico El objeto `DiagnosticoClinico` con los cambios que se aplicarán en la base de datos.
     * @throws NonexistentEntityException Si el diagnóstico clínico no existe en la base de datos.
     * @throws Exception Si ocurre un error durante la edición.
     */
    public void edit(DiagnosticoClinico diagnosticoClinico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DiagnosticoClinico persistentDiagnosticoClinico = em.find(DiagnosticoClinico.class, diagnosticoClinico.getId());
            Paciente pacienteOld = persistentDiagnosticoClinico.getPaciente();
            Paciente pacienteNew = diagnosticoClinico.getPaciente();
            if (pacienteNew != null) {
                pacienteNew = em.getReference(pacienteNew.getClass(), pacienteNew.getId());
                diagnosticoClinico.setPaciente(pacienteNew);
            }
            diagnosticoClinico = em.merge(diagnosticoClinico);
            if (pacienteOld != null && !pacienteOld.equals(pacienteNew)) {
                pacienteOld.getDiagnosticoClinico().remove(diagnosticoClinico);
                pacienteOld = em.merge(pacienteOld);
            }
            if (pacienteNew != null && !pacienteNew.equals(pacienteOld)) {
                pacienteNew.getDiagnosticoClinico().add(diagnosticoClinico);
                pacienteNew = em.merge(pacienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = diagnosticoClinico.getId();
                if (findDiagnosticoClinico(id) == null) {
                    throw new NonexistentEntityException("The diagnosticoClinico with id " + id + " no longer exists.");
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
     * Elimina un diagnóstico clínico de la base de datos por su ID.
     * 
     * @param id El ID del diagnóstico clínico que se eliminará de la base de datos.
     * @throws NonexistentEntityException Si el diagnóstico clínico no existe en la base de datos.
     */
    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DiagnosticoClinico diagnosticoClinico;
            try {
                diagnosticoClinico = em.getReference(DiagnosticoClinico.class, id);
                diagnosticoClinico.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The diagnosticoClinico with id " + id + " no longer exists.", enfe);
            }
            Paciente paciente = diagnosticoClinico.getPaciente();
            if (paciente != null) {
                paciente.getDiagnosticoClinico().remove(diagnosticoClinico);
                paciente = em.merge(paciente);
            }
            em.remove(diagnosticoClinico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    /**
     * Obtiene una lista de todos los diagnósticos clínicos registrados en la base de datos.
     * 
     * @return Lista de objetos `DiagnosticoClinico`.
     */
    public List<DiagnosticoClinico> findDiagnosticoClinicoEntities() {
        return findDiagnosticoClinicoEntities(true, -1, -1);
    }
    /**
     * Obtiene una lista de diagnósticos clínicos registrados en la base de datos con opciones de paginación.
     * 
     * @param maxResults El número máximo de resultados a devolver.
     * @param firstResult El índice del primer resultado a devolver.
     * @return Lista de objetos `DiagnosticoClinico` que cumplen con las opciones de paginación.
     */
    public List<DiagnosticoClinico> findDiagnosticoClinicoEntities(int maxResults, int firstResult) {
        return findDiagnosticoClinicoEntities(false, maxResults, firstResult);
    }

    /**
     * Obtiene una lista de diagnósticos clínicos registrados en la base de datos con opciones de paginación.
     * 
     * @param all Indica si se deben devolver todos los diagnósticos clínicos sin aplicar opciones de paginación.
     * @param maxResults El número máximo de resultados a devolver.
     * @param firstResult El índice del primer resultado a devolver.
     * @return Lista de objetos `DiagnosticoClinico` que cumplen con las opciones de paginación.
     */
    private List<DiagnosticoClinico> findDiagnosticoClinicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DiagnosticoClinico.class));
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
     * Obtiene un diagnóstico clínico por su ID.
     * 
     * @param id El ID del diagnóstico clínico que se busca.
     * @return El objeto `DiagnosticoClinico` encontrado o null si no existe.
     */
    public DiagnosticoClinico findDiagnosticoClinico(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DiagnosticoClinico.class, id);
        } finally {
            em.close();
        }
    }
   /**
     * Obtiene la cantidad de diagnósticos clínicos registrados en la base de datos.
     * 
     * @return El número de diagnósticos clínicos registrados.
     */
    public int getDiagnosticoClinicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DiagnosticoClinico> rt = cq.from(DiagnosticoClinico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
