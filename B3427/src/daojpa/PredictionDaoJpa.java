package daojpa;

import dao.PredictionDao;
import java.util.List;
import javax.persistence.Query;
import modele.Prediction;
import modele.Prediction_Amour;
import modele.Prediction_Sante;
import modele.Prediction_Travail;

/**
 * Gère les interactions pour les prédictions entre la BDD et l'application
 *
 * @author Estelle et Skander
 */
public class PredictionDaoJpa implements PredictionDao {

    /**
     * Créer une prédiction en base de données
     *
     * @param p La prédiction initialisée avec les valeurs à persister
     */
    @Override
    public void createPrediction(Prediction p) {
        JpaUtil.obtenirEntityManager().persist(p);
    }

    /**
     * Créer une prédiction d'amour en base de données
     *
     * @param p La prédiction initialisée avec les valeurs à persister
     */
    @Override
    public void createPredictionAmour(Prediction_Amour p) {
        JpaUtil.obtenirEntityManager().persist(p);
    }

    /**
     * Créer une prédiction de travail en base de données
     *
     * @param p La prédiction initialisée avec les valeurs à persister
     */
    @Override
    public void createPredictionTravail(Prediction_Travail p) {
        JpaUtil.obtenirEntityManager().persist(p);
    }

    /**
     * Créer une prédiction de santé en base de données
     *
     * @param p La prédiction initialisée avec les valeurs à persister
     */
    @Override
    public void createPredictionSante(Prediction_Sante p) {
        JpaUtil.obtenirEntityManager().persist(p);
    }

    @Override
    public List<Prediction_Sante> obtenirPredictionSante() {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select s from Prediction_Sante s");
        List<Prediction_Sante> result = (List<Prediction_Sante>) query.getResultList();
        return result;
    }

    @Override
    public List<Prediction_Amour> obtenirPredictionAmour() {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select s from Prediction_Amour s");
        List<Prediction_Amour> result = (List<Prediction_Amour>) query.getResultList();
        return result;
    }

    @Override
    public List<Prediction_Travail> obtenirPredictionTravail() {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select s from Prediction_Travail s");
        List<Prediction_Travail> result = (List<Prediction_Travail>) query.getResultList();
        return result;
    }

    @Override
    public List<Prediction> rechPredictionSante(String recherche) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select s from Prediction_Sante s where s.text like s.texte=:'param'");
        query.setParameter("param", recherche);
        List<Prediction> result = (List<Prediction>) query.getResultList();
        return result;
    }

    @Override
    public List<Prediction> rechPredictionAmour(String recherche) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select s from Prediction_Amour s where s.texte LIKE :param");
        query.setParameter("param", "%" + recherche + "%");
        List<Prediction> result = (List<Prediction>) query.getResultList();
        return result;
    }

    @Override
    public List<Prediction> rechPredictionTravail(String recherche) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select s from Prediction_Travail s where s.text like s.texte=:param");
        query.setParameter("param", recherche);
        List<Prediction> result = (List<Prediction>) query.getResultList();
        return result;
    }

    /**
     * Recherche une prédiction santé par son identifiant
     *
     * @param id L'identifiant de la prédiction
     * @return La prédiction si trouvée, null sinon
     */
    @Override
    public Prediction_Sante getPredictionSanteById(long id) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select p from Prediction_Sante p where p.id=:pid");
        query.setParameter("pid", id);
        List<Prediction_Sante> result = (List<Prediction_Sante>) query.getResultList();
        if (!result.isEmpty()) {
            return (result.get(0));
        }
        return null;
    }

    /**
     * Recherche une prédiction amour par son identifiant
     *
     * @param id L'identifiant de la prédiction
     * @return La prédiction si trouvée, null sinon
     */
    @Override
    public Prediction_Amour getPredictionAmourById(long id) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select p from Prediction_Amour p where p.id=:pid");
        query.setParameter("pid", id);
        List<Prediction_Amour> result = (List<Prediction_Amour>) query.getResultList();
        if (!result.isEmpty()) {
            return (result.get(0));
        }
        return null;
    }

    /**
     * Recherche une prédiction travail par son identifiant
     *
     * @param id L'identifiant de la prédiction
     * @return La prédiction si trouvée, null sinon
     */
    @Override
    public Prediction_Travail getPredictionTravailById(long id) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select p from Prediction_Travail p where p.id=:pid");
        query.setParameter("pid", id);
        List<Prediction_Travail> result = (List<Prediction_Travail>) query.getResultList();
        if (!result.isEmpty()) {
            return (result.get(0));
        }
        return null;
    }

}
