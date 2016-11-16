package Java;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tran on 31/10/2016.
 */
@Entity
@Table(name = "UTILISATEUR")
@NamedQuery(name = "allUser", query = "SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {

    private int id;
    private String nom;
    private String motdePasse;
    private String type;
    /*public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }*/
    private String motdepasse;

    public Utilisateur(int id, String nom, String motdepasse, String type) {
        this.id = id;
        this.nom = nom;
        this.motdepasse = motdepasse;
        this.type = type;
    }

    public Utilisateur() {
    }


    @Basic
    @Column(name = "MOTDEPASSE")
    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
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
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utilisateur that = (Utilisateur) o;

        if (id != that.id) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (motdepasse != null ? !motdepasse.equals(that.motdepasse) : that.motdepasse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (motdepasse != null ? motdepasse.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
