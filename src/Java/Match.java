package Java;

import javax.persistence.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by tran on 31/10/2016.
 */
@Entity
@Table(name = "MATCH")
@NamedQuery(name = "findMatch", query = "SELECT m FROM Match m")
public class Match implements Serializable {
    private static int countdown = 60000;
    @Id
    private int id;
    private Date date;
    @OneToMany
    private List<Cote> coteList;
    @OneToMany
    private List<Pari> pariList;
    private Timer timer;
    private String nomMatch;
    private String lieuMatch;
    private Integer duree;

    public Match(int id, Date date) {
        this.id = id;
        this.date = date;
        timer = new Timer(countdown, (ActionListener) this);
        timer.start();
    }

    public Match() {
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
    @Column(name = "DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Cote> getCoteList() {
        return coteList;
    }

    public void setCoteList(List<Cote> coteList) {
        this.coteList = coteList;
    }

    public List<Pari> getPariList() {
        return pariList;
    }

    public void setPariList(List<Pari> pariList) {
        this.pariList = pariList;
    }

    @Basic
    @Column(name = "NOM_MATCH")
    public String getNomMatch() {
        return nomMatch;
    }

    public void setNomMatch(String nomMatch) {
        this.nomMatch = nomMatch;
    }

    @Basic
    @Column(name = "LIEU_MATCH")
    public String getLieuMatch() {
        return lieuMatch;
    }

    public void setLieuMatch(String lieuMatch) {
        this.lieuMatch = lieuMatch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Match match = (Match) o;

        if (id != match.id) return false;
        if (date != null ? !date.equals(match.date) : match.date != null) return false;
        if (nomMatch != null ? !nomMatch.equals(match.nomMatch) : match.nomMatch != null) return false;
        if (lieuMatch != null ? !lieuMatch.equals(match.lieuMatch) : match.lieuMatch != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nomMatch != null ? nomMatch.hashCode() : 0);
        result = 31 * result + (lieuMatch != null ? lieuMatch.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "DUREE")
    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }
}
