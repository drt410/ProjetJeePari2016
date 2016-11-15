package EJBclasse;

import Java.Utilisateur;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by tran on 31/10/2016.
 */
@Stateless
public class UtilisateurEJB {
    @PersistenceContext(unitName = "PersistenceUnit")
    private EntityManager entityManager;

    public List<Utilisateur> findUtilisateur(){
        TypedQuery<Utilisateur> query = entityManager.createNamedQuery("allUser", Utilisateur.class);
        return query.getResultList();
    }


    public Utilisateur getUtilisateurrById(int id) {
        return entityManager.find(Utilisateur.class, id);
    }
    public Utilisateur addNew(Utilisateur utilisateur) {
        entityManager.persist(utilisateur);

        return utilisateur;
    }

    public Utilisateur updateUser(Utilisateur user) {
        return entityManager.merge(user);
    }

    public void deleteUser(Utilisateur user) {
        entityManager.remove(entityManager.merge(user));
    }

    public String validate(String nom,String mdp) {
        String flag="failure";

        Query q = entityManager.createQuery("SELECT u FROM Utilisateur u where u.nom =:login AND u.motdePasse = :pass ");
        q.setParameter("login",nom);
        q.setParameter("pass",mdp);
        try{
            Utilisateur user = (Utilisateur) q.getSingleResult();
            System.out.println("HELLO");

            flag="success";


        }catch(Exception e){
            return null;
        }

        return flag;
    }
}
