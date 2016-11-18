package Controller;

import EJBclasse.BookmakersEJB;
import EJBclasse.ParieurEJB;
import EJBclasse.UtilisateurEJB;
import Java.Bookmakers;
import Java.Parieur;
import Java.Utilisateur;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tran on 31/10/2016.
 */
@ManagedBean
@SessionScoped
public class UtilisateurController {
    @EJB
    private UtilisateurEJB utilisateurEJB;
    @EJB
    private ParieurEJB parieurEJB;
    @EJB
    private BookmakersEJB bookmakersEJB;
    private Utilisateur utilisateur;
    private Parieur parieur;
    private Bookmakers bookmakers;
    private List<Utilisateur> utilisateurList = new ArrayList<>();
    private String userName;
    private String password;
    private String type;
    private boolean edit;

    public UtilisateurController() {
        this.utilisateur = new Utilisateur();
    }

    public List<Utilisateur> getUtilisateurList(){

        utilisateurList = utilisateurEJB.findUtilisateur();
        return  utilisateurList;
    }

   public void addNewUtilisateur() {


       if(utilisateur.getType().equals("Parieur")) {
           utilisateur = utilisateurEJB.addNew(utilisateur);
           parieur = new Parieur(utilisateur.getId(), utilisateur.getNom(), 1000, null, null);
           parieur = parieurEJB.addNew(parieur);
       }

        else if(utilisateur.getType().equals("Bookmakers")) {
           utilisateur = utilisateurEJB.addNew(utilisateur);
            bookmakers = new Bookmakers(utilisateur.getId(),utilisateur.getNom(), null);
            bookmakers = bookmakersEJB.addNew(bookmakers);
        }
        utilisateurList = utilisateurEJB.findUtilisateur();
        //return "employeeList.xhtml";
    }

    public String viewAjout(){
        return "Admin.xhtml";
    }

    public void authentifier(){
        utilisateurEJB.validate(userName,password);
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setUtilisateurList(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompte() {
        return type;
    }

    public void setCompte(String type) {
        this.type = type;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public void editUser(Utilisateur usr) {
        utilisateur=usr;
        edit=true;
    }

    public void deleteUser(Utilisateur usr) {
        utilisateurEJB.deleteUser(usr);
        utilisateurList.remove(usr);
    }

    public void saveUser(){
        utilisateurEJB.updateUser(utilisateur);
        edit=false;
    }
}
