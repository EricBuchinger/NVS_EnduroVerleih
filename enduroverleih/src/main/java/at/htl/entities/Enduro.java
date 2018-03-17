package at.htl.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Enduro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String price;
    String horsepower;

    @OneToMany
    List<Verleih> verleihs;

    public Enduro() {
    }

    public Enduro(int id, String price, String horsepower, List<Verleih> verleihs) {
        this.id = id;
        this.price = price;
        this.horsepower = horsepower;
        this.verleihs = verleihs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(String horsepower) {
        this.horsepower = horsepower;
    }

    public List<Verleih> getVerleihs() {
        return verleihs;
    }

    public void setVerleihs(List<Verleih> verleihs) {
        this.verleihs = verleihs;
    }
}
