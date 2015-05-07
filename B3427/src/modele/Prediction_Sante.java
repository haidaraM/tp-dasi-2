package modele;

import javax.persistence.*;

/**
 *
 * @author Estelle
 */
@Entity
public class Prediction_Sante extends Prediction {

    String conseil;

    public Prediction_Sante() {
    }

    @Override
    public String toString() {
        return "Santé " + niveau + " (" + id + ") :" + System.lineSeparator() + "-> " + texte + System.lineSeparator() + "-> " + "Conseil : " + conseil;
    }

    public Prediction_Sante(char icone, int niveau, String texte, String conseil) {
        super(niveau, icone, texte);
        this.conseil = conseil;
    }

    public String getConseil() {
        return conseil;
    }

}
