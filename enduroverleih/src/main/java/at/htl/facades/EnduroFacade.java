package at.htl.facades;


import at.htl.entities.Enduro;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EnduroFacade {

    @PersistenceContext
    EntityManager em;

    public EnduroFacade() {
    }

    public void persistEnduro(Enduro e){
        em.persist(e);
    }
    public List<Enduro> getAllEnduros(){
        return (List<Enduro>)(em.createQuery("Select e from Enduro e").getResultList());
    }
}
