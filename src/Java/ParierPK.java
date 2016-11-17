package Java;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by tran on 17/11/2016.
 */
public class ParierPK implements Serializable {
    private Integer parieurId;
    private Integer pariId;

    @Column(name = "PARIEUR_ID")
    @Basic
    @Id
    public Integer getParieurId() {
        return parieurId;
    }

    public void setParieurId(Integer parieurId) {
        this.parieurId = parieurId;
    }

    @Column(name = "PARI_ID")
    @Basic
    @Id
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

        ParierPK parierPK = (ParierPK) o;

        if (parieurId != null ? !parieurId.equals(parierPK.parieurId) : parierPK.parieurId != null) return false;
        if (pariId != null ? !pariId.equals(parierPK.pariId) : parierPK.pariId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = parieurId != null ? parieurId.hashCode() : 0;
        result = 31 * result + (pariId != null ? pariId.hashCode() : 0);
        return result;
    }
}
