package Java;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by tran on 31/10/2016.
 */
@Entity
@Table(name = "PARIEUR")
@NamedQuery(name = "findParieur", query = "SELECT p FROM Parieur p ORDER BY p.limcoins")
public class Parieur implements Serializable {

    @Id
    private int id;
    private String nom;
    private int limcoins;
    @OneToMany
    private List<Match> matchList;
    @OneToMany(mappedBy = "parieur")
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

    public void setLimcoins(Integer limcoins) {
        this.limcoins = limcoins;
    }

    public int miser(int montant)
    {
        int mise;
        mise = limcoins-montant;

        return mise;
    }
    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NOM")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "LIMCOINS")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parieur parieur = (Parieur) o;

        if (id != parieur.id) return false;
        if (limcoins != parieur.limcoins) return false;
        if (nom != null ? !nom.equals(parieur.nom) : parieur.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + limcoins;
        return result;
    }
}
