package at.htl.entities;

import javax.persistence.*;

@Entity
public class Verleih {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToOne
    Kunde kunde;
    @OneToOne
    Enduro enduro;

    String von;
    String bis;

    public Enduro getEnduro() {
        return enduro;
    }

    public void setEnduro(Enduro enduro) {
        this.enduro = enduro;
    }


    public Verleih(Kunde kunde, String von, String bis, Enduro enduro) {
        this.kunde = kunde;
        this.von = von;
        this.bis = bis;
        this.enduro = enduro;
    }

    public Verleih() {
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public String getVon() {
        return von;
    }

    public void setVon(String von) {
        this.von = von;
    }

    public String getBis() {
        return bis;
    }

    public void setBis(String bis) {
        this.bis = bis;
    }
}
