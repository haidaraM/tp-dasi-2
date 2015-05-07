package daojpa;

import dao.MediumDao;
import java.util.List;
import javax.persistence.Query;
import modele.Medium;

/**
 * Gère les interactions pour les médiums entre la BDD et l'application
 *
 * @author Estelle et Skander
 */
public class MediumDaoJpa implements MediumDao {

    /**
     * Créer un médium en base de données
     *
     * @param medium Le médium initialisé avec les valeurs à persister
     */
    @Override
    public void createMedium(Medium medium) {
        JpaUtil.obtenirEntityManager().persist(medium);
    }

    /**
     * Cherche un médium selon son nom
     *
     * @param nom Le nom du médium à trouver
     * @return Le médium s'il existe, null sinon
     */
    @Override
    public Medium findMediumByName(String nom) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select m from Medium m where m.nom = :med");
        query.setParameter("med", nom);
        List<Medium> result = (List<Medium>) query.getResultList();
        if (!result.isEmpty()) {
            return (result.get(0));
        }
        return null;
    }

    /**
     * Cherche un médium selon son id
     *
     * @param id L'identifiant du médium à trouver
     * @return Le médium s'il existe, null sinon
     */
    @Override
    public Medium findMediumById(long id) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select m from Medium m where m.id=:mid");
        query.setParameter("mid", id);
        List<Medium> result = (List<Medium>) query.getResultList();
        if (!result.isEmpty()) {
            return (result.get(0));
        }
        return null;
    }

    /**
     * Retourne tous les clients enregistrés
     *
     * @return La liste de tous les médiums
     */
    @Override
    public List<Medium> getAllMedium() {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select e from Medium e");
        List<Medium> result = (List<Medium>) query.getResultList();
        return result;
    }

}
