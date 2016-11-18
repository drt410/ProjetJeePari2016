package EJBclasse;

import Java.Parieur;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by tran on 05/01/2016.
 */
@Stateless
public class ParieurEJB {
    @PersistenceContext(unitName = "PersistenceUnit")
    private EntityManager entityManager;

    public List<Parieur> findParieur(){
        TypedQuery<Parieur> query = entityManager.createNamedQuery("findParieur", Parieur.class);
        return query.getResultList();
    }

    public Parieur updateParieur(Parieur parieur) {
        return entityManager.merge(parieur);
    }

    public void deleteParieur(Parieur parieur) {
        entityManager.remove(entityManager.merge(parieur));
    }

    public Parieur getParieurById(int id) {
        return entityManager.find(Parieur.class, id);
    }

    public Parieur addNew(Parieur parieur) {
        entityManager.persist(parieur);
        return parieur;
    }
}
