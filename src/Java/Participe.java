package Java;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tran on 16/11/2016.
 */
@Entity
public class Participe {
    private int id;
    private int matchId;
    private int participantsId;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MATCH_ID")
    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    @Basic
    @Column(name = "PARTICIPANTS_ID")
    public int getParticipantsId() {
        return participantsId;
    }

    public void setParticipantsId(int participantsId) {
        this.participantsId = participantsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participe participe = (Participe) o;

        if (matchId != participe.matchId) return false;
        if (participantsId != participe.participantsId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = matchId;
        result = 31 * result + participantsId;
        return result;
    }
}
