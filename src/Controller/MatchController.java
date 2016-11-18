package Controller;

import EJBclasse.MatchEJB;
import Java.Cote;
import Java.Match;
import Java.Match2;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tran on 07/01/2016.
 */
@ManagedBean
@RequestScoped
public class MatchController {

    @EJB
    private MatchEJB matchEJB;
    private Match2 match = new Match2();
    private List<Match2> matchList = new ArrayList<>();
    private boolean edit;

    public List<Match2> getMatchList(){
        matchList = matchEJB.findMatch();
        return  matchList;
    }

    public void addNewMatch() {
        match = matchEJB.addNew(match);
        matchList = matchEJB.findMatch();
        //return "employeeList.xhtml";
    }


    public Match2 getMatch() {
        return match;
    }

    public void setMatch(Match2 match) {
        this.match = match;
    }

    public String viewMatch(){
        return "Match.xhtml";
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public void editMatch(Match2 matc) {
        match=matc;
        edit=true;
    }

    public void deleteMatch(Match2 match) {
        matchEJB.deleteMatch(match);
        matchList.remove(match);
    }

    public void saveMatch(){
        matchEJB.updateMatch(match);
        edit=false;
    }
}
