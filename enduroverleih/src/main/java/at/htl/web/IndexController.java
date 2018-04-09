package at.htl.web;

import at.htl.entities.Enduro;
import at.htl.entities.Kunde;
import at.htl.entities.Verleih;
import at.htl.facades.EnduroFacade;
import at.htl.facades.KundeFacade;
import at.htl.facades.VerleihFacade;
import org.primefaces.context.RequestContext;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RequestScoped
@ManagedBean(name="indexController")
public class IndexController implements Serializable {

    List<Enduro> enduros;
    List<Verleih> verliehene;
    List<Kunde> kunden;
    Enduro currentEnduro;
    Verleih currentVerleih;
    Kunde currentKunde;

    @Inject
    EnduroFacade enduroFacade;

    @Inject
    VerleihFacade verleihFacade;

    @Inject
    KundeFacade kundeFacade;

    public IndexController() {
        currentEnduro = new Enduro();
    }
    public void doSaveEnduro(){
        enduros = enduroFacade.getAllEnduros();
        enduroFacade.persistEnduro(currentEnduro);
    }
    public void buttonJetztLeihen() {
        System.out.println("****WORKS*****");
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message Title", "Message body");
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
    public void buttonJetztZurueckgeben() {
        System.out.println("*****Button works****");
    }
    public void buttonKundeLoeschen() {
        System.out.println("*****Button works****");
    }
    public List<Enduro> getEnduros() {
        enduros=enduroFacade.getAllEnduros();
        return enduros;
    }
    public List<Verleih> getVerliehene(){
        verliehene = verleihFacade.getAllVerleihs();
        return verliehene;
    }
    public Enduro getCurrentEnduro(){
        return currentEnduro;
    }
    public List<Kunde> getKunden(){
        return kundeFacade.getAllKunden();
    }
    public Verleih getCurrentVerleih() {
        return currentVerleih;
    }

    public Kunde getCurrentKunde() {
        return currentKunde;
    }
}
