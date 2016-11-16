package Java;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tran on 31/10/2016.
 */
@Entity
@Table(name = "COTE")
@NamedQuery(name = "findCote", query = "SELECT c FROM Cote c")
public class Cote implements Serializable {
    @Id
    private int id;
    private String score;
    private float victoire;
    private float defaite;
    private int nb_but;

    public Cote(int id, String score, float victoire, float defaite, int nb_but) {
        this.id = id;
        this.score = score;
        this.victoire = victoire;
        this.defaite = defaite;
        this.nb_but = nb_but;
    }

    public Cote() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public float getVictoire() {
        return victoire;
    }

    public void setVictoire(float victoire) {
        this.victoire = victoire;
    }

    public float getDefaite() {
        return defaite;
    }

    public void setDefaite(float defaite) {
        this.defaite = defaite;
    }

    public int getNb_but() {
        return nb_but;
    }

    public void setNb_but(int nb_but) {
        this.nb_but = nb_but;
    }
}
