package application;

/**
 * Application principale
 *
 * @author elepeigneu
 */
import service.Service;
import daojpa.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import modele.*;

public class Predictif {

    /**
     * Début de l'application
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        JpaUtil.creerEntityManager();
        initSigne();
        initMedium();
        initEmploye();
        initPredictions();

        JpaUtil.fermerEntityManager();
        initClient();
        demo();

    }

    /**
     * Initialise un jeu de données pour les médiums
     */
    public static void initMedium() {
        JpaUtil.ouvrirTransaction();

        MediumDaoJpa mdj = new MediumDaoJpa();

        List<Medium> medium = new ArrayList();
        Medium medium1 = new Medium("Irma");
        mdj.createMedium(medium1);
        medium.add(medium1);
        Medium medium2 = new Medium("Skander");
        mdj.createMedium(medium2);
        medium.add(medium2);
        Medium medium3 = new Medium("Grenouille");
        mdj.createMedium(medium3);
        medium.add(medium3);

        JpaUtil.validerTransaction();

    }

    /**
     * Initialise un jeu de données pour les employés
     */
    public static void initEmploye() {
        JpaUtil.ouvrirTransaction();

        EmployeDaoJpa emj = new EmployeDaoJpa();
        String mdp = "motdepasse";
        Employe employe1 = new Employe("Lisa", mdp);
        Employe employe2 = new Employe("Felix", mdp);
        Employe employe3 = new Employe("Hugues", mdp);
        emj.createEmploye(employe1);
        emj.createEmploye(employe2);
        emj.createEmploye(employe3);
        JpaUtil.validerTransaction();
    }

    /**
     * Initialise un jeu de données pour les clients
     */
    public static void initClient() {
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        MediumDaoJpa mdj = new MediumDaoJpa();
        List<Medium> medium1 = new ArrayList();
        Medium m = mdj.findMediumByName("Irma");

        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();
        medium1.add(m);

        ArrayList<String> prenoms = new ArrayList<String>();
        ArrayList<String> noms = new ArrayList<String>();

        prenoms.add("Thierry");
        prenoms.add("Paul");
        prenoms.add("Hugues");
        prenoms.add("Vincent");
        prenoms.add("Ba");
        prenoms.add("Carol");
        prenoms.add("Albert");
        prenoms.add("Albert");
        prenoms.add("Franck");
        prenoms.add("Jean");
        noms.add("Henry");
        noms.add("Fabre");
        noms.add("Verlin");
        noms.add("Daeden");
        noms.add("Frip");
        noms.add("Gornald");
        noms.add("Duck");
        noms.add("Donald");
        noms.add("Provost");
        noms.add("Aimarre");

        for (int i = 0; i < 10; i++) {
            int annee = new Random().nextInt(2005 - 1900 + 1) + 1900;
            int mois = new Random().nextInt(11) + 1;
            int jour = new Random().nextInt(27) + 1;
            Calendar date = new GregorianCalendar();
            date.set(annee, mois, jour);
            Service.creerClient(new Client(noms.get(i), prenoms.get(i), "M", date, "20 Avenue Albert Einstein", "0123456789", noms.get(i) + prenoms.get(i) + "@yahoo.fr", medium1));
        }
    }

    /**
     * Initialise un jeu de données pour les signes astrologiques
     */
    public static void initSigne() {
        JpaUtil.ouvrirTransaction();

        SigneDaoJpa sdj = new SigneDaoJpa();

        Signe signe1 = new Signe("Capricorne", 1);
        sdj.createSigne(signe1);

        Signe signe2 = new Signe("Verseau", 2);
        sdj.createSigne(signe2);

        Signe signe3 = new Signe("Poissons", 3);
        sdj.createSigne(signe3);

        Signe signe4 = new Signe("Bélier", 4);
        sdj.createSigne(signe4);

        Signe signe5 = new Signe("Taureau", 5);
        sdj.createSigne(signe5);

        Signe signe6 = new Signe("Gémeaux", 6);
        sdj.createSigne(signe6);

        Signe signe7 = new Signe("Cancer", 7);
        sdj.createSigne(signe7);

        Signe signe8 = new Signe("Lion", 8);
        sdj.createSigne(signe8);

        Signe signe9 = new Signe("Vierge", 9);
        sdj.createSigne(signe9);

        Signe signe10 = new Signe("Balance", 10);
        sdj.createSigne(signe10);

        Signe signe11 = new Signe("Scorpion", 11);
        sdj.createSigne(signe11);

        Signe signe12 = new Signe("Sagittaire", 0);
        sdj.createSigne(signe12);

        JpaUtil.validerTransaction();
    }

    /**
     * Initialise un jeu de données pour les prédictions
     */
    private static void initPredictions() {
        JpaUtil.ouvrirTransaction();

        PredictionDaoJpa pdj = new PredictionDaoJpa();
        SigneDaoJpa sdj = new SigneDaoJpa();

        ArrayList<Signe> signes = new ArrayList<Signe>();
        signes.add(sdj.findSigneByNumMois(10));
        signes.add(sdj.findSigneByNumMois(01));
        signes.add(sdj.findSigneByNumMois(02));
        signes.add(sdj.findSigneByNumMois(05));

        ArrayList<String> predictions = new ArrayList();

        // Amour
        predictions.add("Veillez à dialoguer plus souvent avec votre conjoint ou partenaire, au lieu de vous replier sur vous-même et de jouer les mystérieux personnages impossibles à comprendre.");
        predictions.add("Saturne, bien aspecté, influencera votre secteur amour, vous insufflant un besoin de sérieux et de stabilité sur le plan conjugal");
        predictions.add("La présente journée favorisera le règne de la tranquillité, de la compréhension et de la complicité avec votre conjoint ou partenaire.");
        predictions.add("Si vous acceptez de prendre un peu de recul, vous vous apercevrez que vos actuels sujets de dispute avec votre conjoint ou partenaire sont assez futiles et ne concernent pas des questions de fond.");
        predictions.add("Si vous vivez seul, votre charme en hausse sera d'une rare efficacité. Une rencontre importante pourrait avoir lieu.");
        predictions.add("Célibataire, pour tomber amoureux, il faudra sans doute patienter encore quelque temps. Mais en attendant, une belle aventure n'est nullement à exclure !");
        predictions.add("Vous bénéficierez d'une chance réelle qui vous épargnera les disputes, les tromperies et les jalousies.");
        predictions.add("Si vous vivez seul, votre charme en hausse sera d'une rare efficacité. Une rencontre importante pourrait avoir lieu.");
        predictions.add("Il serait mal venu de chercher à provoquer la jalousie de votre partenaire. Ses réactions risquent d'être très violentes, et ce serait l'escalade de l'agressivité, ou le début de la fin d'une union.");
        predictions.add("Célibataire, chez vous, même une timide attraction naissante deviendra vite une grande passion. Aussi serez-vous sans doute le seul à ne pas cumuler les aventures ce jour.");

        for (int i = 0; i < predictions.size(); i++) {
            pdj.createPredictionAmour(new Prediction_Amour('♥', (i % 4) + 1, predictions.get(i), signes.get(i % signes.size())));
        }

        // Travail
        predictions.clear();
        predictions.add("Des modifications soudaines sont possibles dans le cadre de votre métier. Il faudra vous adapter rapidement, quitte, si nécessaire, à fournir un effort supplémentaire.");
        predictions.add("Il sera important de préparer minutieusement le terrain avant de mettre en chantier les projets de votre vie. Prenez donc votre temps, vous y gagnerez.");
        predictions.add("Pour vous, voici une journée fructueuse ! Vous saurez tirer habilement parti de toutes les occasions qui passeront à votre portée, et vous réussirez à développer votre situation professionnelle.");
        predictions.add("Cet aspect d'Uranus vous poussera à mettre les bouchées doubles pour atteindre vos objectifs professionnels. Vous progresserez à pas de géant.");
        predictions.add("Votre route vers la réussite professionnelle sera barrée par Pluton maléficié. La situation sera difficile à encaisser sur le plan psychique. ");
        predictions.add("En affaires, vous ne ferez pas de sentiment ; si vous avez en face de vous des interlocuteurs coriaces, vous saurez briser leur résistance.");
        predictions.add("Durant cette journée, ceux qui créent, inventent ou ont des dons artistiques seront les plus avantagés.");
        predictions.add("Avec l'appui de Mars, vous saurez exploiter à fond tous vos atouts. Pas question de laisser filer une occasion qui passera à votre portée.");
        predictions.add("Beaucoup de contretemps ou de retards en perspective. Mais vous sortirez vainqueur si vous savez conserver un profil bas et surtout faire preuve de patience.");
        predictions.add("Des propositions professionnelles vous paraîtront très alléchantes. Toutefois, étudiez-les soigneusement avant de prendre une décision définitive. Sinon, vous risquez d'avoir une mauvaise surprise.");

        for (int i = 0; i < predictions.size(); i++) {

            pdj.createPredictionTravail(new Prediction_Travail('♦', (i % 4) + 1, predictions.get(i)));
        }

        // Santé
        predictions.clear();
        predictions.add("Votre santé sera influencée par Jupiter. Cet astre est certes positif, mais il peut malgré tout, dans un premier temps, réveiller des malaises dus à une maladie chronique. ");
        predictions.add("Ne cherchez pas particulièrement à dépenser votre énergie, cherchez plutôt des activités adéquates pour développer votre potentiel.");
        predictions.add("Depuis peu, les migraines, les douleurs rhumatismales sont en nette diminution, et cette amélioration devrait se poursuivre pendant quelque temps encore grâce à une ambiance astrale propice. ");
        predictions.add("Bien aspectées, plusieurs planètes s'allieront pour vous doter d'une forme et d'un moral à toute épreuve");
        predictions.add("Pluton présidera cette fois à votre secteur santé. Pensez à ménager votre organisme, ou vous pourriez avoir des ennuis de santé.");
        predictions.add("Il arrive trop souvent que vous vous réfugiez, inconsciemment bien sûr, dans de petites maladies sans importance dès qu'apparaît un problème ou une contrariété d'une certaine gravité.");
        predictions.add("Physiquement, vous vous porterez aussi bien que possible : résistance nerveuse à souhait, bonne utilisation de l'énergie psychique, capacité de récupération rapide après l'effort soutenu.");
        predictions.add("Avec le Soleil dans votre camp, vous serez tout feu tout flamme, bénéficiant à la fois d'un tonus physique sans faille et d'une grande joie de vivre. ");
        predictions.add("Quelque peu déstabilisé par les turbulences planétaires actuelles, vous ne serez pas vraiment dans votre assiette.");
        predictions.add("Uranus en aspect tonique vous stimulera, mais pourra aussi vos rendre nerveux, d'où quelques légers troubles possibles : allergies cutanées, insomnie, tachycardie, etc. Rien de grave.");

        ArrayList<String> conseils = new ArrayList<String>();
        conseils.add("Soignez-vous sans attendre");
        conseils.add("Entreprenez une cure de jouvence");
        conseils.add("Attention aux troubles de sommeil");
        conseils.add("Une promenade vous fera du bien");
        conseils.add("Evitez tout particulièrement les efforts excessifs");
        conseils.add("Tâchez de cultiver l'optimisme et le courage");
        conseils.add("Evitez l'abus de soleil");
        conseils.add("Attention au surplus d'énergie");
        conseils.add("Ecoutez de la bonne musique");
        conseils.add("Faites vous aider par la médecine douce");

        for (int i = 0; i < predictions.size(); i++) {
            pdj.createPredictionSante(new Prediction_Sante('☼', (i % 4) + 1, predictions.get(i), conseils.get(i)));
        }

        JpaUtil.validerTransaction();

    }

    /**
     * Lance la démo pour la soutenance
     */
    public static void demo() {
        boolean fin = false;
        System.out.println("╱╲╱╳╲╱╲ DEMO PREDICT'IF ╱╲╱╳╲╱╲");
        // MENU PRINCIPAL
        while (!fin) {
            System.out.println(System.lineSeparator() + "---- Menu principal :");
            System.out.println("1 : Inscription d'un client puis envoi du mail");
            System.out.println("2 : Affichage de la liste des clients");
            System.out.println("3 : Création puis affichage d'un horoscope");
            System.out.println("4 : Connexion client");
            System.out.println("5 : Quitter la démo");
            int choix = Saisie.lireInteger("Choix : ");
            switch (choix) {
                case 1:
                    demo_inscriptionClient();
                    break;
                case 2:
                    List<Client> clients = Service.obtenirClients();
                    for (Client c : clients) {
                        System.out.println(c);
                        System.out.println("-----------------------------------");
                    }
                    break;
                case 3:
                    demo_creerHoroscope();
                    break;
                case 4 :
                    String nom = Saisie.lireChaine("Nom : ");
                    String mdp = Saisie.lireChaine("Mdp : ");
                    Employe c = Service.connexionEmploye(nom, mdp);
                    if(c == null)
                    {
                        System.out.println("Erreur d'identification");
                    }
                    else
                    {
                        System.out.println(c);
                        for(Client cl : c.getClients())
                        {
                            System.out.println(cl);
                        }
                    }
                        
                    break;
                default:
                    System.out.println("Ce choix n'est pas disponible.");
                    break;
                case 5:
                    fin = true;
                    break;
            }
        }
    }

    /**
     * Création interactive d'un client
     */
    public static void demo_inscriptionClient() {
        String nom = Saisie.lireChaine("Nom : ");
        String prenom = Saisie.lireChaine("Prénom : ");
        String civilite = Saisie.lireChaine("Civilité (M ou Mme) : ");
        System.out.println("Date de naissance :");
        int jour = Saisie.lireInteger("JJ : ");
        int mois = Saisie.lireInteger("MM : ");
        int annee = Saisie.lireInteger("AAAA : ");
        String tel = Saisie.lireChaine("Num tel : ");
        String adresse = Saisie.lireChaine("Adresse : ");
        String email = Saisie.lireChaine("Email : ");
        System.out.println("Mediums disponibles : ");
        List<Medium> mediums = Service.obtenirMediums();
        for (Medium m : mediums) {
            System.out.println("    - " + m);
        }
        String fin_saisie = "O";
        int med;
        Medium medium_add;
        List<Medium> mediums_aAjouter = new ArrayList();
        while (!fin_saisie.equals("X")) {
            med = Saisie.lireInteger("Id médium : ");
            medium_add = Service.obtenirMediumById(med);
            if (medium_add == null) {
                System.out.println("RATE");
            }
            mediums_aAjouter.add(medium_add);
            fin_saisie = Saisie.lireChaine("Continuer ? X pour arrêter : ");
        }
        Client cl;
        Calendar date = new GregorianCalendar();
        date.set(annee, mois, jour);
        cl = new Client(nom, prenom, civilite, date, adresse, tel, email, mediums_aAjouter);

        Service.creerClient(cl);

        System.out.println("---- Fin saisie");
        System.out.println("---- Client créé :");
        cl = Service.obtenirClientById(cl.getId());
        System.out.println(cl);

    }

    /**
     * Création interactive d'un horoscope
     */
    public static void demo_creerHoroscope() {
        System.out.println("Choix du client :");
        List<Client> clients = Service.obtenirClients();
        for (Client c : clients) {
            System.out.println(c);
        }
        int id_client = Saisie.lireInteger("Choix id client : ");
        Client client = Service.obtenirClientById(id_client);

        System.out.println(System.lineSeparator() + "Choix du medium :");
        List<Medium> mediums = Service.obtenirMediumByClient(client.getId());
        for (Medium m : mediums) {
            System.out.println(m);
        }
        int id_medium = Saisie.lireInteger("Choix id medium : ");
        Medium medium = Service.obtenirMediumById(id_medium);

        System.out.println(System.lineSeparator() + "Choix des prédictions :");
        List<Prediction_Amour> psAmour = Service.obtenirPredictionsAmour();
        for (Prediction_Amour predamour : psAmour) {
            System.out.println(predamour);
        }
        int id_pA = Saisie.lireInteger("Choix id amour : ");
        Prediction_Amour pA = Service.obtenirPredictionAmourById(id_pA);

        System.out.println(System.lineSeparator());
        List<Prediction_Sante> psSante = Service.obtenirPredictionsSante();
        for (Prediction_Sante predsante : psSante) {
            System.out.println(predsante);
        }
        int id_pS = Saisie.lireInteger("Choix id sante : ");
        Prediction_Sante pS = Service.obtenirPredictionSanteById(id_pS);

        System.out.println(System.lineSeparator());
        List<Prediction_Travail> psTravail = Service.obtenirPredictionsTravail();
        for (Prediction_Travail predtravail : psTravail) {
            System.out.println(predtravail);
        }
        int id_pT = Saisie.lireInteger("Choix id travail : ");
        Prediction_Travail pT = Service.obtenirPredictionTravailById(id_pT);

        Horoscope hor = new Horoscope(pA, pS, pT, client, medium);
        Service.creerHoroscope(hor);

        System.out.println("---- Fin saisie");
        System.out.println("---- Lite horoscopes du client :");
        client = Service.obtenirClientById(client.getId());
        List<Horoscope> horoscopes = client.getHoroscopes();
        System.out.println(horoscopes.get(0));
    }
}
