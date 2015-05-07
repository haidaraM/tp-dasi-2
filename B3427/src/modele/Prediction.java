package modele;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Estelle
 */
@Entity
public class Prediction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    @Column(nullable = false)
    protected int niveau;
    @Column(nullable = false)
    protected char icone;
    @Column(nullable = false)
    protected String texte;

    public Prediction() {
        icone = '#';
        texte = "Non initialisé";
    }

    public Prediction(int niveau, char icone, String texte) {
        this.niveau = niveau;
        this.icone = icone;
        this.texte = texte;
    }

    public char getIcone() {
        return icone;
    }

    public String getTexte() {
        return texte;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prediction)) {
            return false;
        }
        Prediction other = (Prediction) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "predictif.Prediction[ id=" + id + " ]";
    }

}
