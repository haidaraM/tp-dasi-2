package daojpa;

import dao.EmployeDao;
import java.util.List;
import javax.persistence.Query;
import modele.Client;
import modele.Employe;

/**
 * Gère les interactions pour les employés entre la BDD et l'application
 *
 * @author Estelle et Skander
 */
public class EmployeDaoJpa implements EmployeDao {

    /**
     * Crée un employé
     *
     * @param employe L'employé initialisé avec les valeurs à enregistrer
     */
    @Override
    public void createEmploye(Employe employe) {
        JpaUtil.obtenirEntityManager().persist(employe);
    }

    /**
     * Obtiens un employé selon son identifiant
     *
     * @param id L'identifiant de l'employé à persister
     * @return L'employé si trouvé, null sinon
     */
    @Override
    public Employe findEmployeById(int id) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select e from Employe e where e.id=:emp");
        query.setParameter("emp", id);
        List<Employe> result = (List<Employe>) query.getResultList();
        if (!result.isEmpty()) {
            return (result.get(0));
        }
        return null;
    }

    /**
     * Retourne la liste de tous les employés enregistrés
     *
     * @return La liste des employés
     */
    @Override
    public List<Employe> getAllEmploye() {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select e from Employe e");
        List<Employe> result = (List<Employe>) query.getResultList();
        return result;
    }

    /**
     * Cherche l'employé ayant le plus petit nombre de clients à sa charge
     *
     * @param employes La liste des employés à considérer dans la recherche
     * @return L'employé ayant le moins de clients
     */
    @Override
    public Employe findEmployeMin(List<Employe> employes) {
        int n = employes.size();
        Employe employeMin = employes.get(0);
        for (int i = 1; i < n; i++) {
            if (employes.get(i).getNombreClient() < employeMin.getNombreClient()) {
                employeMin = employes.get(i);
            }
        }
        return employeMin;
    }

    /**
     * Affecte un client à un employé
     *
     * @param employe L'employé en charge du nouveau client
     * @param client Le nouveau client de l'employé
     */
    @Override
    public void affecterClient(Employe employe, Client client) {
        List<Client> clients = employe.getClients();
        clients.add(client);
        employe.setClients(clients);
        JpaUtil.obtenirEntityManager().persist(employe);
    }

    /**
     * Vérifie si le couple employé/mdp existe vraiment
     *
     * @param nom Login de l'employé
     * @param mdp Mot de passe de l'employé
     * @return L'employé si valide, null si invalide
     */
    public Employe identification(String nom, String mdp) {
        Query query = JpaUtil.obtenirEntityManager().createQuery("select e from Employe e where e.nom=:login and e.mdp=:pass");
        query.setParameter("login", nom);
        query.setParameter("pass", mdp);
        List<Employe> result = (List<Employe>) query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

}
