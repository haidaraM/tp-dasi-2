package dao;

import java.util.List;
import modele.Client;
import modele.Horoscope;
import modele.Prediction_Amour;
import modele.Prediction_Sante;
import modele.Prediction_Travail;

/**
 *
 * @author elepeigneu
 */
public interface HoroscopeDao {

    public Horoscope findHoroscopeById(int id);

    public void creerHoroscope(Horoscope h);

    public List<Prediction_Amour> findPredictionAmourByClient(Client c);

    public List<Prediction_Travail> findPredictionTravailByClient(Client c);

    public List<Prediction_Sante> findPredictionSanteByClient(Client c);

}

/* obtenir horscope par type + creer horoscope*/
