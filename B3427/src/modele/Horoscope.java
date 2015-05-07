package modele;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;

import javax.persistence.*;

/**
 *
 * @author elepeigneu
 */
@Entity
public class Horoscope implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Prediction_Amour pA;
    @ManyToOne
    private Prediction_Sante pS;
    @ManyToOne
    private Prediction_Travail pT;
    @ManyToOne
    private Client c;
    @ManyToOne
    private Medium m;
    @Temporal(TemporalType.DATE)
    private Calendar date;

    public Horoscope() {
        this.pA = null;
        this.pS = null;
        this.pT = null;
        this.c = null;
        this.date = null;
    }

    public Horoscope(Prediction_Amour pA, Prediction_Sante pS, Prediction_Travail pT, Client client, Medium m) {
        this.pA = pA;
        this.pS = pS;
        this.pT = pT;
        this.date = Calendar.getInstance(Locale.FRENCH);
        this.c = client;
        this.m = m;
    }

    public Calendar getDate() {
        return date;
    }

    public Client getC() {
        return c;
    }

    public Prediction_Amour getpA() {
        return pA;
    }

    public Prediction_Sante getpS() {
        return pS;
    }

    public Prediction_Travail getpT() {
        return pT;
    }

    public Medium getMedium() {
        return m;
    }

    @Override
    public String toString() {
        return "Horoscope : " + System.lineSeparator() + "-> Amour : "
                + pA.getId() + System.lineSeparator() + "-> Sante : "
                + pS.getId() + System.lineSeparator() + "-> Travail : "
                + pT.getId() + System.lineSeparator() + "-> Medium : " + m
                + System.lineSeparator() + "-> Client : " + c.getPrenom() + " " + c.getNom();
    }

}
