package dao;

import java.util.List;
import modele.Client;
import modele.Employe;

/**
 *
 * @author elepeigneu
 */
public interface EmployeDao {

    public void createEmploye(Employe employe);

    public Employe findEmployeById(int id);

    public List<Employe> getAllEmploye();

    public Employe findEmployeMin(List<Employe> Employes);

    public void affecterClient(Employe employe, Client client);

    public Employe identification(String nom, String mdp);
}
