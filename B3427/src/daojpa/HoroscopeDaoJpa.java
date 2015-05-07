package daojpa;

import dao.HoroscopeDao;
import java.util.List;
import javax.persistence.*;
import modele.Client;
import modele.Horoscope;
import modele.Prediction_Amour;
import modele.Prediction_Sante;
import modele.Prediction_Travail;

/**
 *
 * @author elepeigneu
 */
public class HoroscopeDaoJpa implements HoroscopeDao {

    @Override
    public Horoscope findHoroscopeById(int id) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select h from Horoscope h where h.id=:hor");
        query.setParameter("hor", id);
        List<Horoscope> result = (List<Horoscope>) query.getResultList();
        if (!result.isEmpty()) {
            return (result.get(0));
        }
        return null;
    }

    @Override
    public void creerHoroscope(Horoscope h) {
        JpaUtil.obtenirEntityManager().persist(h);
    }

    @Override
    public List<Prediction_Amour> findPredictionAmourByClient(Client c) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select h.pA from Horoscope h where h.c=:param");
        query.setParameter("param", c);
        List<Prediction_Amour> result = (List<Prediction_Amour>) query.getResultList();
        return result;
    }

    @Override
    public List<Prediction_Travail> findPredictionTravailByClient(Client c) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select h.pT from Horoscope h where h.c=:param");
        query.setParameter("param", c);
        List<Prediction_Travail> result = (List<Prediction_Travail>) query.getResultList();
        return result;
    }

    @Override
    public List<Prediction_Sante> findPredictionSanteByClient(Client c) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select h.pS from Horoscope h where h.c=:param");
        query.setParameter("param", c);
        List<Prediction_Sante> result = (List<Prediction_Sante>) query.getResultList();
        return result;
    }

}
