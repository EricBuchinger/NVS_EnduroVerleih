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
import java.time.LocalDateTime;
import java.util.*;

@RequestScoped
@ManagedBean(name="indexController")
@Model
public class IndexController implements Serializable {

    List<Enduro> enduros;
    List<Verleih> verliehene;
    List<Kunde> kunden;
    Enduro currentEnduro;
    Verleih currentVerleih;
    String gesamtLeihe;
    String vorname;
    String nachname;
    @Inject
    EnduroFacade enduroFacade;

    @Inject
    VerleihFacade verleihFacade;

    @Inject
    KundeFacade kundeFacade;

    public IndexController() {
        currentEnduro = new Enduro();
    }
    public String moveToLeihPage() {
        return "leihpage";
    }
    public String getGesamtLeihe(){
        double c = Double.parseDouble(currentEnduro.getPrice()) + Double.parseDouble(currentEnduro.getHorsepower())*5;
        gesamtLeihe = String.valueOf(c);
        return gesamtLeihe;
    }
    public void doSaveEnduro(){
        enduros = enduroFacade.getAllEnduros();
        enduroFacade.persistEnduro(currentEnduro);
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
        kunden = kundeFacade.getAllKunden();
        return kunden;
    }
    public void speichereLeihe(){
        if(vorname!="" && nachname!="") {
            Kunde kunde = new Kunde(vorname, nachname);
            kundeFacade.persistKunde(kunde);
            System.out.println(currentEnduro.getBrand());
            //Verleih verleih = new Verleih(kunde
            //        , LocalDateTime.now().toString()
            //        , LocalDateTime.now().plusDays(30).toString()
            //        ,getEnduros().get(getEnduros().indexOf(currentEnduro)));
            //verleihFacade.persistVerleih(verleih);
        }

    }
    public Verleih getCurrentVerleih() {
        return currentVerleih;
    }
    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    public String moveToMainPage(){
        return "index";
    }
    public void setCurrentEnduro(Enduro currentEnduro) {
        this.currentEnduro = currentEnduro;
        System.out.println(currentEnduro.getBrand());
    }

    public void setCurrentVerleih(Verleih currentVerleih) {
        this.currentVerleih = currentVerleih;
        System.out.println(currentVerleih.getBis());
    }
}
