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
    private String scoreCote;
    private Double victoireCote;
    private Double defaiteCote;
    private Integer nbButCote;
    @OneToOne
    @JoinColumn(name = "PARI_ID")
    private Pari pari;
    @ManyToOne
    private Match2 match;

    private Integer pariId;

    public Cote(int id, String scoreCote, Double victoireCote, Double defaiteCote, Integer nbButCote) {
        this.id = id;
        this.scoreCote = scoreCote;
        this.victoireCote = victoireCote;
        this.defaiteCote = defaiteCote;
        this.nbButCote = nbButCote;
    }

    public Cote() {
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
    @Column(name = "SCORE_COTE")
    public String getScoreCote() {
        return scoreCote;
    }

    public void setScoreCote(String scoreCote) {
        this.scoreCote = scoreCote;
    }

    @Basic
    @Column(name = "VICTOIRE_COTE")
    public Double getVictoireCote() {
        return victoireCote;
    }

    public void setVictoireCote(Double victoireCote) {
        this.victoireCote = victoireCote;
    }

    @Basic
    @Column(name = "DEFAITE_COTE")
    public Double getDefaiteCote() {
        return defaiteCote;
    }

    public void setDefaiteCote(Double defaiteCote) {
        this.defaiteCote = defaiteCote;
    }

    @Basic
    @Column(name = "NB_BUT_COTE")
    public Integer getNbButCote() {
        return nbButCote;
    }

    public void setNbButCote(Integer nbButCote) {
        this.nbButCote = nbButCote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cote cote = (Cote) o;

        if (id != cote.id) return false;
        if (scoreCote != null ? !scoreCote.equals(cote.scoreCote) : cote.scoreCote != null) return false;
        if (victoireCote != null ? !victoireCote.equals(cote.victoireCote) : cote.victoireCote != null) return false;
        if (defaiteCote != null ? !defaiteCote.equals(cote.defaiteCote) : cote.defaiteCote != null) return false;
        if (nbButCote != null ? !nbButCote.equals(cote.nbButCote) : cote.nbButCote != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (scoreCote != null ? scoreCote.hashCode() : 0);
        result = 31 * result + (victoireCote != null ? victoireCote.hashCode() : 0);
        result = 31 * result + (defaiteCote != null ? defaiteCote.hashCode() : 0);
        result = 31 * result + (nbButCote != null ? nbButCote.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "PARI_ID")
    public Integer getPariId() {
        return pariId;
    }

    public void setPariId(Integer pariId) {
        this.pariId = pariId;
    }
}
