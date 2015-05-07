package modele;

/**
 *
 * @author elepeigneu
 */
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author elepeigneu
 */
@Entity
public class Medium implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, unique = true)
    private String nom;

    @Override
    public String toString() {
        return "(" + id + ") " + nom;
    }

    public Medium() {
    }

    public Medium(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

}
