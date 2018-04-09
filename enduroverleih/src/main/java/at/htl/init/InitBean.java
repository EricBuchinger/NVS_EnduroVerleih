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
        Kunde kunde2 = new Kunde("Ines", "Scherfler");
        kundeFacade.persistKunde(kunde);
        kundeFacade.persistKunde(kunde2);
        Enduro enduro = new Enduro("200","50","Husqvarna","FE 501");
        enduroFacade.persistEnduro(enduro);
        Verleih verleih = new Verleih(kunde,"10.4.2018","30.4.2018",enduro);
        verleihFacade.persistVerleih(verleih);
        enduro = new Enduro("150","40","KTM","EXC 125");
        verleih = new Verleih(kunde2,"01.04.2018","30.08.2018",enduro);
        enduroFacade.persistEnduro(enduro);
        verleihFacade.persistVerleih(verleih);
        enduro = new Enduro("200","45","Husaberg","FE 250");
        enduroFacade.persistEnduro(enduro);
        enduro = new Enduro("200","50","Husqvarna","FE 701");
        enduroFacade.persistEnduro(enduro);
        System.out.println("*****Works*****");
    }
}
