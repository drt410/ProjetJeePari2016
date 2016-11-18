package EJBclasse;

import Java.Bookmakers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by tran on 31/10/2016.
 */
@Stateless
public class BookmakersEJB {
    @PersistenceContext(unitName = "PersistenceUnit")
    private EntityManager entityManager;

    public List<Bookmakers> findBookmakers(){
        TypedQuery<Bookmakers> query = entityManager.createNamedQuery("findBookmakers", Bookmakers.class);
        return query.getResultList();
    }
    public Bookmakers updateBookmakers(Bookmakers bookmakers) {
        return entityManager.merge(bookmakers);
    }

    public void deleteBookmakers(Bookmakers bookmakers) {
        entityManager.remove(entityManager.merge(bookmakers));
    }

    public Bookmakers getBookmakersById(int id) {
        return entityManager.find(Bookmakers.class, id);
    }
    public Bookmakers addNew(Bookmakers bookmakers) {
        entityManager.persist(bookmakers);
        return bookmakers;
    }
}
