package persistance;

import javax.persistence.*;

@Entity
@Table(name = "titremusical", schema = "ma_db", catalog = "")
public class TitremusicalEntity {
    private int id;
    private String titre;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "titre")
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TitremusicalEntity that = (TitremusicalEntity) o;

        if (id != that.id) return false;
        if (titre != null ? !titre.equals(that.titre) : that.titre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (titre != null ? titre.hashCode() : 0);
        return result;
    }
}
