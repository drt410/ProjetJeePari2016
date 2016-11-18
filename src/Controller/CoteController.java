package Controller;

import EJBclasse.CoteEJB;
import Java.Cote;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tran on 31/10/2016.
 */
@ManagedBean
@RequestScoped
public class CoteController implements Serializable {

    @EJB
    private CoteEJB coteEJB;
    private Cote cote = new Cote();
    private List<Cote> coteList = new ArrayList<>();
    private boolean edit;
    private boolean create;

        public List<Cote> getCoteList(){

            coteList = coteEJB.findCote();
            return  coteList;
        }

    public void addNewCote() {
        cote = coteEJB.addNew(cote);
        coteList = coteEJB.findCote();
        //return "employeeList.xhtml";
    }

    public String viewCote(){
        return "Cote.xhtml";
    }

    public Cote getCote() {
        return cote;
    }

    public void setCote(Cote cote) {
        this.cote = cote;
    }

    public void setCoteList(List<Cote> coteList) {
        this.coteList = coteList;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public boolean isCreate() {
        return create;
    }

    public void setCreate(boolean create) {
        this.create = create;
    }

    public void editCote(Cote cot) {
        cote=cot;
        edit=true;
    }

    public void deleteCote(Cote cot) {
        coteEJB.deleteCote(cot);
        coteList.remove(cot);
    }

    public void saveCote(){
        coteEJB.updateCote(cote);
        edit=false;
    }
}
