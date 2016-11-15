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
    @GeneratedValue(strategy= GenerationType.AUTO)
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

    public List<Cote> getCoteList() {
        return coteList;
    }

    public void setCoteList(List<Cote> encheres) {
        this.coteList = coteList;
    }


}
