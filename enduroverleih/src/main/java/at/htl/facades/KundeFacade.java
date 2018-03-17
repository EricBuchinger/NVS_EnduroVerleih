package at.htl.facades;

import at.htl.entities.Enduro;
import at.htl.entities.Kunde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class KundeFacade {

    @PersistenceContext
    EntityManager em;

    public KundeFacade() {
    }

    public void persistKunde(Kunde d){
        em.persist(d);
    }
}
