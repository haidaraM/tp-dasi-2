package dao;

import java.util.List;
import modele.Prediction;
import modele.Prediction_Amour;
import modele.Prediction_Sante;
import modele.Prediction_Travail;

/**
 *
 * @author Estelle
 */
public interface PredictionDao {

    public void createPrediction(Prediction p);

    public void createPredictionAmour(Prediction_Amour p);

    public void createPredictionTravail(Prediction_Travail p);

    public void createPredictionSante(Prediction_Sante p);

    /**
     * Recherche une prédiction santé par son identifiant
     *
     * @param id L'identifiant de la prédiction
     * @return La prédiction si trouvée, null sinon
     */
    public Prediction_Sante getPredictionSanteById(long id);

    /**
     * Recherche une prédiction amour par son identifiant
     *
     * @param id L'identifiant de la prédiction
     * @return La prédiction si trouvée, null sinon
     */
    public Prediction_Amour getPredictionAmourById(long id);

    /**
     * Recherche une prédiction travail par son identifiant
     *
     * @param id L'identifiant de la prédiction
     * @return La prédiction si trouvée, null sinon
     */
    public Prediction_Travail getPredictionTravailById(long id);

    public List<Prediction_Sante> obtenirPredictionSante();

    public List<Prediction_Amour> obtenirPredictionAmour();

    public List<Prediction_Travail> obtenirPredictionTravail();

    public List<Prediction> rechPredictionSante(String recherche);

    public List<Prediction> rechPredictionAmour(String recherche);

    public List<Prediction> rechPredictionTravail(String recherche);
}
