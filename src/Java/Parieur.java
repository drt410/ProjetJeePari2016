package Java;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by tran on 31/10/2016.
 */
@Entity
@Table(name = "PARIEUR")
@NamedQuery(name = "findParieur", query = "SELECT p FROM Parieur p")
public class Parieur implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name = "NOM_PARIEUR")
    private String nom;
    @Column(name = "LIMCOINS_PARIEUR")
    private int limcoins;
    @OneToMany
    private List<Match> matchList;
    @OneToMany
    private List<Pari> pariList;

    public Parieur() {
    }

    public Parieur(int id, String nom, int limcoins, List<Match> matchList, List<Pari> pariList) {
        this.id = id;
        this.nom = nom;
        this.limcoins = limcoins;
        this.matchList = matchList;
        this.pariList = pariList;
    }

    public int parier(int montant)
    {
        int mise;
        mise = limcoins-montant;

        return mise;
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

    public int getLimcoins() {
        return limcoins;
    }

    public void setLimcoins(int limcoins) {
        this.limcoins = limcoins;
    }

    public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }

    public List<Pari> getPariList() {
        return pariList;
    }

    public void setPariList(List<Pari> pariList) {
        this.pariList = pariList;
    }
}
