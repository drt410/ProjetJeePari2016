package Java;

import javax.persistence.*;

/**
 * Created by tran on 17/11/2016.
 */
@Entity
@IdClass(ParierPK.class)
public class Parier {
    private Integer parieurId;
    private Integer pariId;

    @Id
    @Column(name = "PARIEUR_ID")
    public Integer getParieurId() {
        return parieurId;
    }

    public void setParieurId(Integer parieurId) {
        this.parieurId = parieurId;
    }

    @Id
    @Column(name = "PARI_ID")
    public Integer getPariId() {
        return pariId;
    }

    public void setPariId(Integer pariId) {
        this.pariId = pariId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parier parier = (Parier) o;

        if (parieurId != null ? !parieurId.equals(parier.parieurId) : parier.parieurId != null) return false;
        if (pariId != null ? !pariId.equals(parier.pariId) : parier.pariId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = parieurId != null ? parieurId.hashCode() : 0;
        result = 31 * result + (pariId != null ? pariId.hashCode() : 0);
        return result;
    }
}
