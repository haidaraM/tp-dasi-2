package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Employé de l'entreprise de voyance
 *
 * @author Estelle et Skander
 */
@Entity
public class Employe implements Serializable {

    /**
     * Identifiant
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /**
     * Nom (et login) de l'employé
     */
    @Column(nullable = false, unique = true)
    private String nom;
    /**
     * Mot de passe de l'employé
     */
    @Column(nullable = false)
    private String mdp;
    /**
     * Clients à la charge de l'employé
     */
    @OneToMany
    private List<Client> Clients;

    /**
     * Constructeur par défaut
     */
    public Employe() {
    }

    /**
     * Initialise un employé avec son nom et son mot de passe
     *
     * @param nom Son nom
     * @param mdp Son mot de passe
     */
    public Employe(String nom, String mdp) {
        this.nom = nom;
        this.mdp = mdp;
        this.Clients = new ArrayList<Client>();

    }

    /**
     * Affiche un employé
     *
     * @return La mise en forme d'un employé
     */
    @Override
    public String toString() {
        return "(" + id + ") " + nom;
    }

    /**
     * Obtiens l'identifiant de l'employé
     *
     * @return L'identifiant
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiens le nom de l'employé
     *
     * @return Le nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Obtiens les clients de l'employé
     *
     * @return La liste de ses clients
     */
    public List<Client> getClients() {
        return Clients;
    }

    /**
     * Indique le nombre de clients de l'employé
     *
     * @return Le nombre de clients
     */
    public int getNombreClient() {
        return this.Clients.size();
    }

    public void setClients(List<Client> Clients) {
        this.Clients = Clients;
    }
}
