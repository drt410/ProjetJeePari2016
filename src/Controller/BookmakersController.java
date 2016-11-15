package Controller;

import EJBclasse.BookmakersEJB;
import Java.Bookmakers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tran on 31/10/2016.
 */
@ManagedBean
@RequestScoped
public class BookmakersController {

    @EJB
    private BookmakersEJB bookmakersEJB;
    private Bookmakers bookmakers;
    private List<Bookmakers> bookmakersList = new ArrayList<>();

    public List<Bookmakers> getBookmakersList(){

        bookmakersList = bookmakersEJB.findBookmakers();
        return  bookmakersList;
    }

    public void addNewBookmakers() {
        bookmakers = bookmakersEJB.addNew(bookmakers);
        bookmakersList = bookmakersEJB.findBookmakers();
    }

    public String viewBook(){
        return "book.xhtml";
    }

    public Bookmakers getBookmakers() {
        return bookmakers;
    }

    public void setBookmakers(Bookmakers bookmakers) {
        this.bookmakers = bookmakers;
    }

    public void setBookmakersList(List<Bookmakers> bookmakersList) {
        this.bookmakersList = bookmakersList;
    }
}
