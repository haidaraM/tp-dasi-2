package modele;

import java.io.Serializable;
import java.util.List;
import java.util.Calendar;
import javax.persistence.*;

/**
 * Client du service Predict'if
 *
 * @author Estelle et Skander
 */
@Entity
public class Client implements Serializable {

    /**
     * Le numéro du client
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Nom du client
     */
    @Column(nullable = false)
    private String nom;
    /**
     * Prénom du client
     */
    @Column(nullable = false)
    private String prenom;
    /**
     * Civilité du client
     */
    @Column(nullable = false)
    private String civilite;
    /**
     * Date de naissance du client
     */
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar dateDeNaissance;
    /**
     * Adresse du client
     */
    @Column(nullable = false)
    private String adresse;
    /**
     * Numéro de téléphone du client
     */
    @Column(length = 10, nullable = false)
    private String tel;
    /**
     * Email du client
     */
    @Column(nullable = false)
    private String email;
    /**
     * Mediums favoris du client
     */
    @ManyToMany
    private List<Medium> medium;
    /**
     * Signe du client
     */
    @ManyToOne
    private Signe signe;
    /**
     * Employé assigné au client
     */
    @ManyToOne
    private Employe employe;
    /**
     * Horoscopes créés pour ce client
     */
    @OneToMany
    private List<Horoscope> horoscopes;

    /**
     * Constructeur par défaut
     */
    public Client() {
    }

    /**
     * Formatte un client pour affichage
     *
     * @return Client formatté
     */
    @Override
    public String toString() {
        String res = "(" + id + ") " + civilite + " " + prenom + " " + nom
                + " : " + dateDeNaissance.get(Calendar.DAY_OF_MONTH) + "/" + dateDeNaissance.get(Calendar.MONTH) + "/" + dateDeNaissance.get(Calendar.YEAR) + " (" + signe + ")"
                + "; " + adresse + "; " + tel + "; " + email + System.lineSeparator()
                + "-> Employé : " + employe + System.lineSeparator()
                + "-> Medium(s) : " + System.lineSeparator();
        for (Medium m : medium) {
            res += "    " + m;
        }
        res = res + System.lineSeparator();
        return res;
    }

    /**
     * Initialise un client
     *
     * @param nom Son nom
     * @param prenom Son prénom
     * @param civilite Sa civilité
     * @param dateDeNaissance Sa date de naissance
     * @param adresse Son adresse
     * @param tel Son numéro de téléphone
     * @param email Son email
     * @param medium Ses mediums favoris
     */
    public Client(String nom, String prenom, String civilite, Calendar dateDeNaissance, String adresse, String tel, String email, List<Medium> medium) {
        this.nom = nom;
        this.prenom = prenom;
        this.civilite = civilite;
        this.dateDeNaissance = dateDeNaissance;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
        this.medium = medium;
        this.signe = null;
        this.employe = null;
        this.horoscopes = null;
    }

    public List<Horoscope> getHoroscopes() {
        return horoscopes;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Calendar getDateDeNaissance() {
        return dateDeNaissance;
    }

    public List<Medium> getMedium() {
        return medium;
    }

    public Signe getSigne() {
        return signe;
    }

    public Employe getEmploye() {
        return employe;
    }

    public Long getId() {
        return id;
    }

    public String getCivilite() {
        return civilite;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Signe getUnSigne() {
        return signe;
    }

    public void setSigne(Signe unSigne) {
        this.signe = unSigne;
    }

    public int getNaissanceMois() {
        return dateDeNaissance.get(Calendar.MONTH);
    }

    public void setMedium(List<Medium> medium) {
        this.medium = medium;
    }

    public void setHoroscopes(List<Horoscope> horoscopes) {
        this.horoscopes = horoscopes;
    }

}
