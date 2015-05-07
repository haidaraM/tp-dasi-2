package modele;

import javax.persistence.*;

/**
 *
 * @author Estelle
 */
@Entity
public class Prediction_Amour extends Prediction {

    @JoinColumn
    @ManyToOne
    Signe partenaire;

    @Override
    public String toString() {
        return "Amour " + niveau + " (" + id + ") :" + System.lineSeparator() + "-> " + texte + System.lineSeparator() + "-> " + "Partenaire : " + partenaire;
    }

    public Prediction_Amour() {
    }

    public Prediction_Amour(char icone, int niveau, String texte, Signe partenaire) {
        super(niveau, icone, texte);
        this.partenaire = partenaire;
    }

    public Signe getPartenaire() {
        return partenaire;
    }

}
