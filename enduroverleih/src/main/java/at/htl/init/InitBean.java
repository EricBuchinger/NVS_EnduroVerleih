package at.htl.init;

import at.htl.entities.Enduro;
import at.htl.entities.Kunde;
import at.htl.entities.Verleih;
import at.htl.facades.EnduroFacade;
import at.htl.facades.KundeFacade;
import at.htl.facades.VerleihFacade;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.LinkedList;
import java.util.List;

@Startup
@Singleton
public class InitBean {

    @Inject
    EnduroFacade enduroFacade;

    @Inject
    KundeFacade kundeFacade;

    @Inject
    VerleihFacade verleihFacade;

    @PostConstruct
    public void init(){
        Kunde kunde = new Kunde("Eric","Buchinger");
        kundeFacade.persistKunde(kunde);
        Verleih verleih = new Verleih();
        verleih.setBis("21");
        verleih.setVon("12");
        verleih.setKunde(kunde);
        verleihFacade.persistVerleih(verleih);
        List<Verleih> verleihs = new LinkedList<>();
        verleihs.add(verleih);
        Enduro enduro = new Enduro();
        enduro.setHorsepower("10 PS");
        enduro.setPrice("10000 €");
        enduro.setVerleihs(verleihs);
        enduroFacade.persistEnduro(enduro);
        System.out.println("*****Works*****");
    }
}
