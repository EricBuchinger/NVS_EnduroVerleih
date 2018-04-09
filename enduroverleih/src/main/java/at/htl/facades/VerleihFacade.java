package at.htl.facades;

import at.htl.entities.Enduro;
import at.htl.entities.Verleih;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class VerleihFacade {

    @PersistenceContext
    EntityManager em;

    public VerleihFacade() {
    }

    public void persistVerleih(Verleih v){
        em.persist(v);
    }

    public List<Verleih> getAllVerleihs(){
        return (List<Verleih>)em.createQuery("Select v from Verleih v ").getResultList();
    }
}
