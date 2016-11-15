package Controller;

import EJBclasse.PariEJB;
import Java.Pari;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tran on 06/01/2016.
 */
@ManagedBean
@RequestScoped
public class PariController {
    @EJB
    private PariEJB pariEJB;
    private Pari pari;
    private List<Pari> pariList = new ArrayList<>();

    public List<Pari> getVendeurList(){

        pariList = pariEJB.findObjets();
        return  pariList;
    }

    public void addNewPari() {
        pari = pariEJB.addNew(pari);
        pariList = pariEJB.findObjets();
        //return "employeeList.xhtml";
    }

    public Pari getPari() {
        return pari;
    }

    public void setPari(Pari pari) {
        this.pari = pari;
    }

    public List<Pari> getPariList() {
        return pariList;
    }

    public void setPariList(List<Pari> pariList) {
        this.pariList = pariList;
    }
}
