package Java;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by tran on 16/11/2016.
 */
public class BookePK implements Serializable {
    private int bookmakerId;
    private int coteId;

    @Column(name = "BOOKMAKER_ID")
    @Id
    public int getBookmakerId() {
        return bookmakerId;
    }

    public void setBookmakerId(int bookmakerId) {
        this.bookmakerId = bookmakerId;
    }

    @Column(name = "COTE_ID")
    @Id
    public int getCoteId() {
        return coteId;
    }

    public void setCoteId(int coteId) {
        this.coteId = coteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookePK bookePK = (BookePK) o;

        if (bookmakerId != bookePK.bookmakerId) return false;
        if (coteId != bookePK.coteId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookmakerId;
        result = 31 * result + coteId;
        return result;
    }
}
