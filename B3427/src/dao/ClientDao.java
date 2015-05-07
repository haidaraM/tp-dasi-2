package dao;

import java.util.List;
import modele.Client;
import modele.Horoscope;

/**
 *
 * @author elepeigneu
 */
public interface ClientDao {

    public void createClient(Client client);

    public Client findClientById(long id);

    public List<Client> getAllClient();

    public void affecterHoroscope(Client c, Horoscope h);
}
