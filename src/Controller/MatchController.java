package Controller;

import EJBclasse.MatchEJB;
import Java.Match;

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
    private Match match;
    private List<Match> matchList = new ArrayList<>();

    public List<Match> getMatchList(){

        matchList = matchEJB.findMatch();
        return  matchList;
    }

    public void addNewMatch() {
        match = matchEJB.addNew(match);
        matchList = matchEJB.findMatch();
        //return "employeeList.xhtml";
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
