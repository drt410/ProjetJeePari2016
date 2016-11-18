package Controller;

import EJBclasse.ParieurEJB;
import Java.Parieur;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tran on 05/01/2016.
 */
@ManagedBean
@RequestScoped
public class ParieurController {

    @EJB
    private ParieurEJB parieurEJB;
    private Parieur parieur;
    private List<Parieur> parieurList = new ArrayList<>();
    private boolean edit;

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

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public void editParieur(Parieur parieu) {
        parieur=parieu;
        edit=true;
    }

    public void deleteParieur(Parieur parieu) {
        parieurEJB.deleteParieur(parieu);
        parieurList.remove(parieu);
    }

    public void saveParieur(){
        parieurEJB.updateParieur(parieur);
        edit=false;
    }
}
