package at.htl.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Versicherung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToOne
    Kunde kunde;

    @OneToOne
    Enduro enduro;

    Date abgeschlossen;
    Date beendet;
    int gebühr;
}
