package at.htl.facades;

import at.htl.entities.Enduro;
import at.htl.entities.Kunde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class KundeFacade {

    @PersistenceContext
    EntityManager em;

    public KundeFacade() {
    }

    public void persistKunde(Kunde d){
        em.persist(d);
    }

    public List<Kunde> getAllKunden() {
        return em.createQuery("Select k from Kunde k").getResultList();
    }
}
