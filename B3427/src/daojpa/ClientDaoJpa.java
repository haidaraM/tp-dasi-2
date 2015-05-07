package daojpa;

import dao.ClientDao;
import java.util.List;
import javax.persistence.Query;
import modele.Client;
import modele.Horoscope;

/**
 * Gère les interactions pour le client entre la BDD et l'application
 *
 * @author Estelle et Skander
 */
public class ClientDaoJpa implements ClientDao {

    /**
     * Créer un client en base de données
     *
     * @param client Le client initialisé avec les valeurs à persister
     */
    @Override
    public void createClient(Client client) {
        JpaUtil.obtenirEntityManager().persist(client);
    }

    /**
     * Obtiens un client selon son identifiant
     *
     * @param id L'identifiant du client à trouver
     * @return Le Client trouvé, sinon null
     */
    @Override
    public Client findClientById(long id) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select e from Client e where e.id=:clt");
        query.setParameter("clt", id);
        List<Client> result = (List<Client>) query.getResultList();
        if (!result.isEmpty()) {
            return (result.get(0));
        }
        return null;
    }

    /**
     * Retourne tous les clients enregistrés
     *
     * @return La liste de tous les clients
     */
    @Override
    public List<Client> getAllClient() {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select c from Client c");
        List<Client> result = (List<Client>) query.getResultList();
        return result;
    }

    /**
     * Affecte un horoscope à un client
     *
     * @param c Le client pour qui l'horoscope a été réalisé
     * @param h L'horoscope a rattacher
     */
    @Override
    public void affecterHoroscope(Client c, Horoscope h) {
        List<Horoscope> horoscopes = c.getHoroscopes();
        horoscopes.add(h);
        c.setHoroscopes(horoscopes);
        JpaUtil.obtenirEntityManager().persist(c);
    }
}
