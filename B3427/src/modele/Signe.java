package modele;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author elepeigneu
 */
@Entity

public class Signe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    @Column(nullable = false, unique = true)
    private String nom;
    private int numMois;

    public Signe() {
    }

    public Signe(String nom, int numMois) {
        this.nom = nom;
        this.numMois = numMois;
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return nom;
    }

}
