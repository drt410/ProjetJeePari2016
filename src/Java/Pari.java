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
    private Double montant;
    @OneToOne
    private Match match;
    @OneToOne(mappedBy = "pari")
    private Cote cote;

    private Double taux;

    @ManyToOne
    private Parieur parieur;
    private String vainqueur;
    private int coteId;
    private int matchId;

    public Pari(int id, Double montant, Match match, Cote cote, Parieur parieur, int coteId, int matchId) {
        this.id = id;
        this.montant = montant;
        this.match = match;
        this.cote = cote;
        this.parieur = parieur;
        this.coteId = coteId;
        this.matchId = matchId;
    }

    public Pari() {

    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    public Parieur getParieur() {
        return parieur;
    }

    public void setParieur(Parieur parieur) {
        this.parieur = parieur;
    }

    public String getVainqueur() {
        return vainqueur;
    }

    public void setVainqueur(String vainqueur) {
        this.vainqueur = vainqueur;
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
    @Column(name = "MONTANT")
    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
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


    @Column(name = "COTE_ID")
    public int getCoteId() {
        return coteId;
    }

    public void setCoteId(int coteId) {
        this.coteId = coteId;
    }


    @Column(name = "MATCH_ID")
    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pari pari = (Pari) o;

        if (montant != pari.montant) return false;
        if (coteId != pari.coteId) return false;
        if (matchId != pari.matchId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + coteId;
        result = 31 * result + matchId;
        return result;
    }
}
