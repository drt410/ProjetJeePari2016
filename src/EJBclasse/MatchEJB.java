package EJBclasse;

import Java.Match;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by tran on 06/01/2016.
 */
@Stateful
public class MatchEJB {
    @PersistenceContext(unitName = "PersistenceUnit")
    private EntityManager entityManager;

    public List<Match> findMatch(){
        TypedQuery<Match> query = entityManager.createNamedQuery("findMatch", Match.class);
        return query.getResultList();
    }


    public Match getMatchById(int id) {
        return entityManager.find(Match.class, id);
    }
    public Match addNew(Match match) {
        entityManager.persist(match);
        return match;
    }
}
