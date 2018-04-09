package at.htl.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Enduro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String brand;
    String modell;
    String price;
    String horsepower;

    public Enduro() {
    }

    public Enduro(String price, String horsepower, String brand, String modell) {
        this.price = price;
        this.horsepower = horsepower;
        this.modell = modell;
        this.brand = brand;
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
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
}
