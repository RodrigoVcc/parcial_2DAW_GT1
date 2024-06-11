package libcode.webapp.negocio;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import libcode.webapp.entidades.Inscripcion;

@Stateless
public class InscripcionService {

    @PersistenceContext(unitName = "pu")
    EntityManager entityManager;
    
    public List<Inscripcion> getInscripciones() {
        Query query = entityManager.createQuery("SELECT e FROM Inscripcion e ORDER BY e.id DESC");
        return query.getResultList();
    }
    
    @Transactional
    public void saveInscripcion(Inscripcion inscripcion) {
        entityManager.persist(inscripcion);        
    }
    
    @Transactional
    public void editInscripcion(Inscripcion inscripcion) {
        entityManager.merge(inscripcion);
    }
    
    @Transactional
    public void deleteInscripcion(Inscripcion inscripcion) {
        Inscripcion inscripcionEliminar = entityManager.find(Inscripcion.class, inscripcion.getId());
        entityManager.remove(inscripcionEliminar);
    }
}
