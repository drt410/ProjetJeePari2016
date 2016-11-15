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
@NamedQuery(name = "findMatch", query = "SELECT m FROM Match m ")
public class Match implements Serializable {
    @Id
    private int id;
    private Date date;
    @OneToMany
    private List<Cote> coteList;
    @OneToMany
    private List<Pari> pariList;

    private static int countdown = 60000;
    private Timer timer;
    private int i;
    public Match(int id, Date date) {
        this.id = id;
        this.date = date;
        timer = new Timer(countdown, (ActionListener) this);
        timer.start();
    }

    public Match() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

}
