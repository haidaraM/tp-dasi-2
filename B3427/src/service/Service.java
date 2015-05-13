package service;

import daojpa.*;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import modele.*;

/**
 * Rassemble tous les services utilisables par les IHM que propose l'application
 *
 * @author Estelle et Skander
 */
public class Service {

    private static String MAIL_ENTREPRISE = "predictif@etoiles.com";

    // EMPLOYE
    /**
     * Vérifie l'indentification d'un employé
     *
     * @param nom Le login de l'employé (= son nom)
     * @param mdp Son mot de passe
     * @return L'employé si valide, null si invalide
     */
    public static Employe connexionEmploye(String nom, String mdp) {
        Employe res;
        // Création du contexte
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        EmployeDaoJpa edj = new EmployeDaoJpa();
        res = edj.identification(nom, mdp);
        // Fermeture du contexte
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();
        return res;
    }

    // CLIENT
    /**
     * Crée un client en base de données
     *
     * @param c Le client à créer
     * @return true si ok, false si erreur
     */
    public static boolean creerClient(Client c) {
        // Création du contexte
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        ClientDaoJpa cdj = new ClientDaoJpa();

        SigneDaoJpa sdj = new SigneDaoJpa();

        try {
            Signe signe = sdj.findSigneByNumMois(c.getNaissanceMois()+1);
            c.setSigne(signe);

            EmployeDaoJpa edj = new EmployeDaoJpa();
            List<Employe> employes = edj.getAllEmploye();
            Employe employe = edj.findEmployeMin(employes);
            c.setEmploye(employe);
            edj.affecterClient(employe, c);

            cdj.createClient(c);

            // Si ok, on envoie le mail
            envoyerMailOK(c);
            JpaUtil.validerTransaction();
            JpaUtil.fermerEntityManager();
            return true;
        } catch (Exception e) {
            envoyerMailKO(c);
            JpaUtil.annulerTransaction();
            JpaUtil.fermerEntityManager();
            return false;
        }

    }

    /**
     * Prépare l'entête du mail d'inscription
     *
     * @param c Le client à qui s'adresse le mail
     */
    private static void enteteMail(Client c) {
        System.out.println("----------------------------------------------");
        System.out.println("");
        System.out.println("Expediteur : " + MAIL_ENTREPRISE);
        System.out.println("Pour : " + c.getEmail());
        System.out.println("Sujet : Bienvenue");
        System.out.println("Corps :");
        System.out.println("Bonjour " + c.getPrenom());
    }

    /**
     * Envoie le mail de validation d'inscription
     *
     * @param c Le client à qui s'adresse le mail
     */
    private static void envoyerMailOK(Client c) {
        enteteMail(c);
        System.out.println("Nous vous confirmons votre inscription à l'agence Predict'IF. Votre numéro de client est : " + c.getId());
        System.out.println("");
        System.out.println("----------------------------------------------");
    }

    /**
     * Envoie le mail d'invalidation d'inscription
     *
     * @param c Le client à qui s'adresse le mail
     */
    private static void envoyerMailKO(Client c) {
        enteteMail(c);
        System.out.println("Votre inscription à l'agence Predict'IF a échouée. Merci de recommencer ultérieurement.");
        System.out.println("");
        System.out.println("----------------------------------------------");
    }

    /**
     * Recherche un client par son identifiant
     *
     * @param id L'identifiant du client voulu
     * @return Le client s'il existe, null sinon
     */
    public static Client obtenirClientById(long id) {
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        ClientDaoJpa cdj = new ClientDaoJpa();
        Client c = cdj.findClientById(id);

        // Fermeture du contexte
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();
        return c;
    }

    /**
     * Retourne la liste des clients enregistrés dans la liste
     *
     * @return La liste des clients
     */
    public static List<Client> obtenirClients() {
        // Création du contexte
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        ClientDaoJpa cdj = new ClientDaoJpa();
        List<Client> clients = cdj.getAllClient();

        // Fermeture du contexte
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();

        return clients;
    }

    // MEDIUM
    /**
     * Retourne la liste des mediums enregistrés dans la liste
     *
     * @return La liste des mediums
     */
    public static List<Medium> obtenirMediums() {
        // Création du contexte
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        MediumDaoJpa mdj = new MediumDaoJpa();
        List<Medium> mediums = mdj.getAllMedium();

        // Fermeture du contexte
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();

        return mediums;

    }

    /**
     * Recherche un medium par son nom
     *
     * @param nom Le nom du medium à chercher
     * @return Le medium trouvé, null sinon
     */
    public static Medium obtenirMediumByName(String nom) {
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        MediumDaoJpa mdj = new MediumDaoJpa();
        Medium m = mdj.findMediumByName(nom);

        // Fermeture du contexte
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();
        return m;
    }

    /**
     * Retourne les mediums favoris d'un client
     *
     * @param idClient Le client dont on souhaite avoir les mediums favoris
     * @return La liste des mediusms favoris du client
     */
    public static List<Medium> obtenirMediumByClient(long idClient) {
        // Création du contexte
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        ClientDaoJpa cdj = new ClientDaoJpa();
        Client c = cdj.findClientById(idClient);
        List<Medium> mediums = c.getMedium();

        // Fermeture du contexte
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();

        return mediums;
    }

    /**
     * Recherche un medium par son identifiant
     *
     * @param idMedium L'identifiant du medium
     * @return Le medium si trouvé, null sinon
     */
    public static Medium obtenirMediumById(long idMedium) {
        // Création du contexte
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        MediumDaoJpa mdj = new MediumDaoJpa();
        Medium m = mdj.findMediumById(idMedium);

        // Fermeture du contexte
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();

        return m;
    }

    // PREDICTIONS
    /**
     * Retourne l'ensemble des prédictions de type Amour
     *
     * @return La listes des prédictions amour
     */
    public static List<Prediction_Amour> obtenirPredictionsAmour() {
        // Création du contexte
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        PredictionDaoJpa pdj = new PredictionDaoJpa();
        List<Prediction_Amour> predictions = pdj.obtenirPredictionAmour();

        // Fermeture du contexte
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();

        return predictions;
    }

    /**
     * Retourne l'ensemble des prédictions de type Sante
     *
     * @return La listes des prédictions sante
     */
    public static List<Prediction_Sante> obtenirPredictionsSante() {
        // Création du contexte
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        PredictionDaoJpa pdj = new PredictionDaoJpa();
        List<Prediction_Sante> predictions = pdj.obtenirPredictionSante();

        // Fermeture du contexte
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();

        return predictions;
    }

    /**
     * Retourne l'ensemble des prédictions de type Travail
     *
     * @return La listes des prédictions travail
     */
    public static List<Prediction_Travail> obtenirPredictionsTravail() {
        // Création du contexte
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        PredictionDaoJpa pdj = new PredictionDaoJpa();
        List<Prediction_Travail> predictions = pdj.obtenirPredictionTravail();

        // Fermeture du contexte
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();

        return predictions;
    }

    /**
     * Recherche une prédiction amour par son identifiant
     *
     * @param id L'identifiant de la prédiction
     * @return La prédiction si trouvée, null sinon
     */
    public static Prediction_Amour obtenirPredictionAmourById(long id) {
        // Création du contexte
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        PredictionDaoJpa pdj = new PredictionDaoJpa();
        Prediction_Amour prediction = pdj.getPredictionAmourById(id);

        // Fermeture du contexte
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();

        return prediction;
    }

    /**
     * Recherche une prédiction travail par son identifiant
     *
     * @param id L'identifiant de la prédiction
     * @return La prédiction si trouvée, null sinon
     */
    public static Prediction_Travail obtenirPredictionTravailById(long id) {
        // Création du contexte
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        PredictionDaoJpa pdj = new PredictionDaoJpa();
        Prediction_Travail prediction = pdj.getPredictionTravailById(id);

        // Fermeture du contexte
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();

        return prediction;
    }

    /**
     * Recherche une prédiction santé par son identifiant
     *
     * @param id L'identifiant de la prédiction
     * @return La prédiction si trouvée, null sinon
     */
    public static Prediction_Sante obtenirPredictionSanteById(long id) {
        // Création du contexte
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        PredictionDaoJpa pdj = new PredictionDaoJpa();
        Prediction_Sante prediction = pdj.getPredictionSanteById(id);

        // Fermeture du contexte
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();

        return prediction;
    }

    // HOROSCOPE
    /**
     * Crée un horoscope
     *
     * @param h L'horoscope à enregistrer initalisé
     * @return true si réussi, false si echec
     */
    public static boolean creerHoroscope(Horoscope h) {
        // Création du contexte
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        HoroscopeDaoJpa hdj = new HoroscopeDaoJpa();
        ClientDaoJpa cdj = new ClientDaoJpa();
        try {
            Client cl = cdj.findClientById(h.getC().getId());
            hdj.creerHoroscope(h);
            cdj.affecterHoroscope(cl, h);

            envoyerHoroscope(h);
            // Fermeture du contexte
            JpaUtil.validerTransaction();
            JpaUtil.fermerEntityManager();
            return true;
        } catch (Exception e) {
            JpaUtil.annulerTransaction();
            JpaUtil.fermerEntityManager();
            return false;
        }
    }

    /**
     * Envoie le mail d'envoi de l'horoscope
     *
     * @param h L'horoscope auquel le mail correspond
     */
    public static void envoyerHoroscope(Horoscope h) {
        System.out.println("---------------------------------------------");
        System.out.println("");
        System.out.println(h.getC().getPrenom() + " " + h.getC().getNom());
        System.out.println(h.getC().getAdresse());
        System.out.println(h.getC().getTel());
        System.out.println("Votre numéro client : " + h.getC().getId());
        System.out.println("Votre signe : " + h.getC().getSigne());
        String med = "";
        for (Medium m : h.getC().getMedium()) {
            med += m.getNom() + "; ";
        }
        System.out.println("Vos mediums favoris : " + med);
        System.out.println("");
        System.out.println("Le " + Calendar.getInstance(Locale.FRENCH).get(Calendar.DAY_OF_MONTH) + "/"
                + (Calendar.getInstance(Locale.FRENCH).get(Calendar.MONTH) + 1) + "/" + Calendar.getInstance(Locale.FRENCH).get(Calendar.YEAR) + ",");
        System.out.println("");
        System.out.println("Cher(e) " + h.getC().getPrenom() + ", aujourd'hui votre voyance vous est offerte par " + h.getMedium().getNom());
        System.out.println("Travail (" + h.getpT().getIcone() + ") : " + h.getpT().getTexte());
        System.out.println("");
        System.out.println("Sante (" + h.getpS().getIcone() + ") : " + h.getpS().getTexte());
        System.out.println("Notre conseil : " + h.getpS().getConseil());
        System.out.println("");
        System.out.println("Amour (" + h.getpA().getIcone() + ") : " + h.getpA().getTexte());
        System.out.println("Votre signe partenaire : " + h.getpA().getPartenaire());
        System.out.println("");
        System.out.println("---------------------------------------------");
    }

    /**
     * Donne l'ensemble des prédiction amour précédemment attribuées à un client
     *
     * @param c Le client voulu
     * @return La liste des prédictions qu'il a déjà reçu
     */
    public static List<Prediction_Amour> historiquePredictionsAmour(Client c) {
        // Création du contexte
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        HoroscopeDaoJpa hdj = new HoroscopeDaoJpa();
        List<Prediction_Amour> predictions = hdj.findPredictionAmourByClient(c);

        // Fermeture du contexte
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();

        return predictions;
    }

    /**
     * Donne l'ensemble des prédiction sante précédemment attribuées à un client
     *
     * @param c Le client voulu
     * @return La liste des prédictions qu'il a déjà reçu
     */
    public static List<Prediction_Sante> historiquePredictionsSante(Client c) {
        // Création du contexte
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        HoroscopeDaoJpa hdj = new HoroscopeDaoJpa();
        List<Prediction_Sante> predictions = hdj.findPredictionSanteByClient(c);

        // Fermeture du contexte
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();

        return predictions;
    }

    /**
     * Donne l'ensemble des prédiction travail précédemment attribuées à un
     * client
     *
     * @param c Le client voulu
     * @return La liste des prédictions qu'il a déjà reçu
     */
    public static List<Prediction_Travail> historiquePredictionsTravail(Client c) {
        // Création du contexte
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        HoroscopeDaoJpa hdj = new HoroscopeDaoJpa();
        List<Prediction_Travail> predictions = hdj.findPredictionTravailByClient(c);

        // Fermeture du contexte
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();

        return predictions;
    }
}
