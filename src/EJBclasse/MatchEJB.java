package EJBclasse;

import Java.Cote;
import Java.Match;
import Java.Match2;

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

    public List<Match2> findMatch(){
        TypedQuery<Match2> query = entityManager.createNamedQuery("findMatch", Match2.class);
        return query.getResultList();
    }
    public Match2 updateMatch(Match2 match2) {
        return entityManager.merge(match2);
    }

    public void deleteMatch(Match2 match2) {
        entityManager.remove(entityManager.merge(match2));
    }


    public Match2 getMatchById(int id) {
        return entityManager.find(Match2.class, id);
    }
    public Match2 addNew(Match2 match) {
        entityManager.persist(match);
        return match;
    }


}
