package Java; /**
 * Created by tran on 31/10/2016.
 */
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "BOOKMAKERS")
@NamedQuery(name = "findBookmakers", query = "SELECT b FROM Bookmakers b")
public class Bookmakers implements Serializable {
    @Id
    private int id;
    private String nom;
    @OneToMany
    private List<Cote> coteList;

   public Bookmakers(int id, String nom, List<Cote> coteList) {
        this.id = id;
        this.nom = nom;
        this.coteList = coteList;
    }
    public Bookmakers() {
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

    public List<Cote> getCoteList() {
        return coteList;
    }

    public void setCoteList(List<Cote> encheres) {
        this.coteList = coteList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bookmakers that = (Bookmakers) o;

        if (id != that.id) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        return result;
    }
}
