package at.htl.database;

import at.htl.entities.Enduro;
import at.htl.facades.EnduroFacade;
import at.htl.facades.KundeFacade;
import at.htl.facades.VerleihFacade;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DatabaseTest  {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager em;

    @Before
    public void init(){
        entityManagerFactory = Persistence.createEntityManagerFactory("db");
        em = entityManagerFactory.createEntityManager();
    }

    @Test
    public void t010_enduroTableTest() {
        Enduro e = new Enduro();
        e.setPrice("1000 €");
        e.setHorsepower("40 PS");
    }
}