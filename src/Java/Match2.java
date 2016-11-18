package Java;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tran on 17/11/2016.
 */
@Entity
public class Match2 {
    @Id
    private int id;
    private String nomMatch;
    private String lieuMatch;
    private java.util.Date date;
    private java.util.Date javadate;
    private Integer duree;
    @OneToMany
    private List<Cote> coteList;
    @OneToMany
    private List<Pari> pariList;
    private String gagnant;

    public List<Pari> getPariList() {
        return pariList;
    }

    public void setPariList(List<Pari> pariList) {
        this.pariList = pariList;
    }

    public String getGagnant() {
        return gagnant;
    }

    public void setGagnant(String gagnant) {
        Iterator<Pari> iterator = this.pariList.iterator();
        while(iterator.hasNext())
        {
            Pari pari = iterator.next();
            if(pari.getVainqueur().equals(gagnant))
            {
                Cote cote = pari.getCote();
                Parieur parieur = pari.getParieur();
                parieur.setLimcoins(parieur.getLimcoins()+(int)(cote.getVictoireCote()*pari.getMontant()));
            }
        }
        this.gagnant = gagnant;

    }

    public List<Cote> getCoteList() {
        return coteList;
    }

    public void setCoteList(List<Cote> coteList) {
        this.coteList = coteList;
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

    @Basic
    @Column(name = "DATE")
    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
      //  this.setJavadate(new java.util.Date(date.getTime()));
    }

    public java.util.Date getJavadate() {
        return javadate;
    }

    public void setJavadate(java.util.Date javadate) {
        this.javadate = javadate;
        this.setDate(new java.sql.Date(javadate.getTime()));
    }

    @Basic
    @Column(name = "DUREE")
    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Match2 match2 = (Match2) o;

        if (id != match2.id) return false;
        if (nomMatch != null ? !nomMatch.equals(match2.nomMatch) : match2.nomMatch != null) return false;
        if (lieuMatch != null ? !lieuMatch.equals(match2.lieuMatch) : match2.lieuMatch != null) return false;
        if (date != null ? !date.equals(match2.date) : match2.date != null) return false;
        if (duree != null ? !duree.equals(match2.duree) : match2.duree != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nomMatch != null ? nomMatch.hashCode() : 0);
        result = 31 * result + (lieuMatch != null ? lieuMatch.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (duree != null ? duree.hashCode() : 0);
        return result;
    }
}
