package Controller;

import EJBclasse.ParieurEJB;
import Java.Parieur;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tran on 05/01/2016.
 */
@ManagedBean
@RequestScoped
public class ParieurController implements Serializable {

    @EJB
    private ParieurEJB parieurEJB;
    private Parieur parieur;
    private List<Parieur> parieurList = new ArrayList<>();

        public List<Parieur> getParieurList(){

            parieurList = parieurEJB.findParieur();
            return  parieurList;
        }

    public void addNewParieur() {
        parieur = parieurEJB.addNew(parieur);
        parieurList = parieurEJB.findParieur();
        //return "employeeList.xhtml";
    }

    public Parieur getParieur() {
        return parieur;
    }

    public void setParieur(Parieur parieur) {
        this.parieur = parieur;
    }

    public void setParieurList(List<Parieur> parieurList) {
        this.parieurList = parieurList;
    }
}
