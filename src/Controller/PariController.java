package Controller;

import EJBclasse.CoteEJB;
import EJBclasse.MatchEJB;
import EJBclasse.PariEJB;
import Java.*;

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
    @EJB
    private CoteEJB coteEJB;
    @EJB
    private MatchEJB matchEJB;
    private Cote cote;
    private Pari pari;
    private Parieur parieur;
    private Match2 match2;
    private List<Pari> pariList = new ArrayList<>();
    private List<Cote> coteList = new ArrayList<>();
    private List<Match2> matchList = new ArrayList<>();


    public List<Pari> getPariList(){

        pariList = pariEJB.findPari();
        return  pariList;
    }

    public Double Parier(){
        Double coef =match2.getCoteList().get(cote.getId()).getVictoireCote();
        Double somme= parieur.miser(0)*coef;
        return somme;


    }
    public String viewPari(){
        return "Pari.xhtml";
    }

    public void addNewPari() {
        pari.setMontant(Parier());
        pari = pariEJB.addNew(pari);
        coteList=coteEJB.findCote();
        matchList=matchEJB.findMatch();
        pariList = pariEJB.findPari() ;
        //return "employeeList.xhtml";
    }

    public Pari getPari() {
        return pari;
    }

    public void setPari(Pari pari) {
        this.pari = pari;
    }


    public void setPariList(List<Pari> pariList) {
        this.pariList = pariList;
    }
}
