package EJBclasse;

import Java.Pari;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by tran on 31/10/2016.
 */
@Stateless
public class PariEJB {
    @PersistenceContext(unitName = "PersistenceUnit")
    private EntityManager entityManager;

    public List<Pari> findPari(){
        TypedQuery<Pari> query = entityManager.createNamedQuery("findPari", Pari.class);
        return query.getResultList();
    }


    public Pari getPariById(int id) {
        return entityManager.find(Pari.class, id);
    }
    public Pari addNew(Pari pari) {
        entityManager.persist(pari);
        return pari;
    }
}
