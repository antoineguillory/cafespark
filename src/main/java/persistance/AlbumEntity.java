package persistance;

import javax.persistence.*;

@Entity
@Table(name = "album", schema = "ma_db", catalog = "")
public class AlbumEntity {
    private int id;
    private String nomalb;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nomalb")
    public String getNom() {
        return nomalb;
    }

    public void setNom(String nom) {
        this.nomalb = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlbumEntity that = (AlbumEntity) o;

        if (id != that.id) return false;
        if (nomalb != null ? !nomalb.equals(that.nomalb) : that.nomalb != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nomalb != null ? nomalb.hashCode() : 0);
        return result;
    }
}
