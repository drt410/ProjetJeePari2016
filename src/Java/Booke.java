package Java;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by tran on 16/11/2016.
 */
@Entity
@IdClass(BookePK.class)
public class Booke {
    private int bookmakerId;
    private int coteId;

    @Id
    @Column(name = "BOOKMAKER_ID")
    public int getBookmakerId() {
        return bookmakerId;
    }

    public void setBookmakerId(int bookmakerId) {
        this.bookmakerId = bookmakerId;
    }

    @Id
    @Column(name = "COTE_ID")
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

        Booke booke = (Booke) o;

        if (bookmakerId != booke.bookmakerId) return false;
        if (coteId != booke.coteId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookmakerId;
        result = 31 * result + coteId;
        return result;
    }
}
