package at.htl.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kunde {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String firstName;
    String LastName;

    public Kunde() {
    }

    public Kunde(String firstName, String lastName) {
        this.firstName = firstName;
        LastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
