package Java;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by tran on 26/10/2016.
 */

public class Administrateur implements Serializable {

    private int id;
    private String nom;
    private ArrayList<Parieur> parieurs;
    private ArrayList<Bookmakers>bookmakerses ;

    public Administrateur(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Administrateur() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}