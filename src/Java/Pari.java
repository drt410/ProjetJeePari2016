package Java;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tran on 31/10/2016.
 */
@Entity
@Table(name = "PARI")
@NamedQuery(name = "findPari", query = "SELECT p FROM Pari p ")

public class Pari implements Serializable {
    @Id
    private int id;
    private int montant;
    @OneToOne
    private Match match;
    @OneToOne
    private Cote cote;
/*    @OneToMany
   private List<Parieur> parieurList;*/

    public Pari(int montant, Match match, Cote cote) {
        this.montant = montant;
        this.match = match;
        this.cote = cote;
    }

    public Pari() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Cote getCote() {
        return cote;
    }

    public void setCote(Cote cote) {
        this.cote = cote;
    }
/*
    public List<Parieur> getParieurList() {
        return parieurList;
    }

    public void setParieurList(List<Parieur> parieurList) {
        this.parieurList = parieurList;
    }*/
}
