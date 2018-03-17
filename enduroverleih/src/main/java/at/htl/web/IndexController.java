package at.htl.web;

import at.htl.entities.Enduro;
import at.htl.facades.EnduroFacade;

import javax.enterprise.inject.Model;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Named
@RequestScoped
@Model
public class IndexController implements Serializable {

    List<Enduro> enduros;
    Enduro currentEnduro;

    @Inject
    EnduroFacade enduroFacade;

    public IndexController() {
        currentEnduro = new Enduro();
    }
    public void doSaveEnduro(){
        enduros = enduroFacade.getAllEnduros();
        enduroFacade.persistEnduro(currentEnduro);
    }

    public List<Enduro> getEnduros() {
        enduros=enduroFacade.getAllEnduros();
        return enduros;

    }
    public Enduro getCurrentEnduro(){
        return currentEnduro;
    }
}
