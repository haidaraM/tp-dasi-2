package modele;

import javax.persistence.*;

/**
 *
 * @author Estelle
 */
@Entity
public class Prediction_Travail extends Prediction {

    public Prediction_Travail() {

    }

    @Override
    public String toString() {
        return "Travail " + niveau + " (" + id + ") :" + System.lineSeparator() + "-> " + texte;
    }

    public Prediction_Travail(char icone, int niveau, String texte) {
        super(niveau, icone, texte);
    }

}
