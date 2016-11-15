package EJBclasse;

import Java.Cote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by tran on 31/10/2016.
 */
@Stateless
public class CoteEJB {
    @PersistenceContext(unitName = "PersistenceUnit")
    private EntityManager entityManager;

    public List<Cote> findCote(){
        TypedQuery<Cote> query = entityManager.createNamedQuery("findCote", Cote.class);
        return query.getResultList();
    }


    public Cote getCoteById(int id) {
        return entityManager.find(Cote.class, id);
    }
    public Cote addNew(Cote cote) {
        entityManager.persist(cote);
        return cote;
    }
}
